Yes. Let's design it as a **real system-design exercise**, not just a CRUD project.

# 💰 Expense & Budget Analytics System — System Design

### Goal

Build a backend system that allows users to record **income and expenses**, define **budgets**, and obtain useful **financial analytics**.

For now:

* ❌ No login
* ❌ No JWT
* ❌ No Spring Security
* ❌ No frontend initially
* ✅ Spring Boot
* ✅ PostgreSQL
* ✅ JPA/Hibernate
* ✅ REST API

---

# 1. High-Level Architecture

```text
                    ┌─────────────────────┐
                    │      Client         │
                    │ Postman / React     │
                    └──────────┬──────────┘
                               │
                               │ HTTP/REST
                               ▼
                    ┌─────────────────────┐
                    │    Controllers      │
                    │                     │
                    │ ExpenseController   │
                    │ IncomeController    │
                    │ BudgetController    │
                    │ AnalyticsController│
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │      Services       │
                    │                     │
                    │ ExpenseService      │
                    │ IncomeService       │
                    │ BudgetService       │
                    │ AnalyticsService    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Repositories     │
                    │                     │
                    │ ExpenseRepository   │
                    │ IncomeRepository    │
                    │ BudgetRepository    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     PostgreSQL      │
                    └─────────────────────┘
```

This gives you the architecture you're already familiar with, but the **service and repository layers will contain much more interesting logic**.

---

# 2. Main Modules

I'd divide the application into four modules:

```text
Expense Management
Income Management
Budget Management
Analytics
```

```text
                   Finance System
                         │
       ┌─────────────────┼─────────────────┐
       │                 │                 │
       ▼                 ▼                 ▼
   Expenses           Income           Budgets
       │                 │                 │
       └─────────────────┼─────────────────┘
                         ▼
                    Analytics
```

---

# 3. Database Design

Start with three main tables.

```text
┌─────────────────┐
│    expenses     │
├─────────────────┤
│ id PK           │
│ title           │
│ description     │
│ amount          │
│ category        │
│ payment_method  │
│ expense_date    │
│ created_at      │
│ updated_at      │
└─────────────────┘


┌─────────────────┐
│     income      │
├─────────────────┤
│ id PK           │
│ title           │
│ description     │
│ amount          │
│ source          │
│ income_date     │
│ created_at      │
│ updated_at      │
└─────────────────┘


┌─────────────────┐
│     budgets     │
├─────────────────┤
│ id PK           │
│ category        │
│ amount          │
│ month           │
│ year            │
│ created_at      │
│ updated_at      │
└─────────────────┘
```

For now, there is **no User table**.

---

# 4. Expense Domain

### Expense

```text
Expense
│
├── id
├── title
├── description
├── amount
├── category
├── paymentMethod
├── expenseDate
├── createdAt
└── updatedAt
```

### Category

```text
FOOD
TRANSPORT
SHOPPING
ENTERTAINMENT
HEALTH
EDUCATION
BILLS
TRAVEL
OTHER
```

### PaymentMethod

```text
CASH
CARD
BANK_TRANSFER
DIGITAL_WALLET
```

---

# 5. Income Domain

```text
Income
│
├── id
├── title
├── description
├── amount
├── source
├── incomeDate
├── createdAt
└── updatedAt
```

Income sources:

```text
SALARY
FREELANCE
BUSINESS
INVESTMENT
GIFT
OTHER
```

---

# 6. Budget Domain

A budget belongs to a **category + month + year**.

For example:

```text
FOOD
September
2026
Rs. 10,000
```

Database:

```text
Budget
│
├── id
├── category
├── amount
├── month
├── year
├── createdAt
└── updatedAt
```

### Important business rule

You shouldn't allow:

```text
FOOD + September + 2026
```

to exist twice.

So you should eventually enforce uniqueness on:

```text
(category, month, year)
```

This is one of the first places where you'll practice **database constraints**, rather than relying entirely on Java code.

---

# 7. DTO Design

Don't expose entities directly.

For Expense:

```text
ExpenseRequestDTO
ExpenseResponseDTO
ExpenseFilterDTO
```

For Income:

```text
IncomeRequestDTO
IncomeResponseDTO
```

For Budget:

```text
BudgetRequestDTO
BudgetResponseDTO
BudgetSummaryDTO
```

For analytics:

```text
FinancialSummaryDTO
CategoryExpenseDTO
MonthlyExpenseDTO
```

---

# 8. API Design

## Expense APIs

```http
POST   /api/expenses
GET    /api/expenses
GET    /api/expenses/{id}
PUT    /api/expenses/{id}
DELETE /api/expenses/{id}
```

### Filtering

```http
GET /api/expenses?category=FOOD

GET /api/expenses?paymentMethod=CARD

GET /api/expenses?startDate=2026-09-01&endDate=2026-09-30

GET /api/expenses?minAmount=100&maxAmount=1000
```

### Search

```http
GET /api/expenses/search?title=restaurant
```

### Pagination

```http
GET /api/expenses?page=0&size=10
```

### Sorting

```http
GET /api/expenses?sort=amount,desc
```

---

# 9. Income APIs

```http
POST   /api/income
GET    /api/income
GET    /api/income/{id}
PUT    /api/income/{id}
DELETE /api/income/{id}
```

And eventually:

```http
GET /api/income?startDate=2026-09-01&endDate=2026-09-30
```

---

# 10. Budget APIs

```http
POST   /api/budgets
GET    /api/budgets
GET    /api/budgets/{id}
PUT    /api/budgets/{id}
DELETE /api/budgets/{id}
```

Then the interesting endpoint:

```http
GET /api/budgets/{id}/summary
```

Example response:

```json
{
  "category": "FOOD",
  "budget": 10000,
  "spent": 7500,
  "remaining": 2500,
  "usagePercentage": 75,
  "status": "SAFE"
}
```

---

# 11. Analytics Module

This is where I want you to spend most of your effort.

## Financial Summary

```http
GET /api/analytics/summary
```

Response:

```json
{
  "totalIncome": 80000,
  "totalExpense": 42500,
  "balance": 37500
}
```

The calculation is:

```text
Balance = Total Income - Total Expense
```

---

## Category Analytics

```http
GET /api/analytics/expenses/category
```

Response:

```json
[
  {
    "category": "FOOD",
    "amount": 12000
  },
  {
    "category": "TRANSPORT",
    "amount": 5000
  },
  {
    "category": "SHOPPING",
    "amount": 8500
  }
]
```

This should ideally be calculated **by the database**, using aggregation/grouping.

You'll get practice with:

```sql
SUM()
GROUP BY
ORDER BY
```

and JPA/JPQL equivalents.

---

# 12. Monthly Analytics

```http
GET /api/analytics/expenses/monthly
```

Response:

```json
[
  {
    "month": "2026-07",
    "amount": 32000
  },
  {
    "month": "2026-08",
    "amount": 38000
  },
  {
    "month": "2026-09",
    "amount": 42500
  }
]
```

Now you're dealing with **date-based aggregation**.

---

# 13. Highest Expense

```http
GET /api/analytics/expenses/highest
```

Response:

```json
{
  "title": "New Laptop",
  "amount": 85000,
  "category": "SHOPPING"
}
```

---

# 14. Average Expense

```http
GET /api/analytics/expenses/average
```

Example:

```json
{
  "averageExpense": 1250.50
}
```

This gives you another database aggregation problem.

---

# 15. Budget Business Logic

Suppose:

```text
Budget:
FOOD = Rs. 10,000

Expenses:
Food #1 = Rs. 2,000
Food #2 = Rs. 3,000
Food #3 = Rs. 2,500
```

Your service calculates:

```text
Total budget = 10,000
Total spent  = 7,500

Remaining    = 2,500
Usage        = 75%
```

Then:

```text
0% - 79%    → SAFE
80% - 99%   → WARNING
100%+       → EXCEEDED
```

The exact thresholds are your design decision.

---

# 16. Important Business Rules

This is the part I specifically want you to think about.

### Expense

```text
amount > 0
title cannot be empty
expenseDate cannot be null
```

### Income

```text
amount > 0
title cannot be empty
incomeDate cannot be null
```

### Budget

```text
amount > 0
month must be valid
year must be valid

category + month + year must be unique
```

### Analytics

```text
balance = income - expense
```

### Budget

```text
spent = sum(expenses for category/month/year)

remaining = budget - spent

usage = spent / budget × 100
```

---

# 17. Exception Design

Have a centralized exception handler.

```text
exception/
│
├── ResourceNotFoundException
├── DuplicateResourceException
├── InvalidOperationException
└── GlobalExceptionHandler
```

For example:

```http
GET /api/expenses/{non-existing-id}
```

Response:

```json
{
  "status": 404,
  "message": "Expense not found",
  "timestamp": "2026-09-05T14:30:00"
}
```

---

# 18. Backend Package Structure

I would actually recommend organizing it **by feature** rather than putting every entity into one giant package.

Instead of:

```text
controller/
service/
repository/
entity/
dto/
```

you could eventually use:

```text
finance/
│
├── expense/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── mapper/
│   ├── repository/
│   └── service/
│
├── income/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── mapper/
│   ├── repository/
│   └── service/
│
├── budget/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── mapper/
│   ├── repository/
│   └── service/
│
├── analytics/
│   ├── controller/
│   ├── dto/
│   └── service/
│
└── exception/
```

This is a nice opportunity for you to practice a more scalable project structure.

---

# 19. Development Roadmap

Don't build everything simultaneously.

### Phase 1 — Design

```text
Requirements
     ↓
ER Diagram
     ↓
Entities
     ↓
API Contract
     ↓
Business Rules
```

### Phase 2 — Basic Backend

```text
Spring Initializr
     ↓
Environment
     ↓
PostgreSQL
     ↓
Entities
     ↓
Repositories
```

### Phase 3 — CRUD

```text
DTO
 ↓
Mapper
 ↓
Service
 ↓
Controller
```

Implement Expense first.

Then Income.

Then Budget.

---

### Phase 4 — Validation & Exceptions

```text
Bean Validation
      ↓
Custom Exceptions
      ↓
GlobalExceptionHandler
```

---

### Phase 5 — Querying

This is where I would challenge you.

Implement:

```text
Filtering
Searching
Sorting
Pagination
Date ranges
Amount ranges
```

---

### Phase 6 — Analytics

Implement:

```text
SUM
AVG
MAX
GROUP BY
Monthly aggregation
Category aggregation
```

---

### Phase 7 — Business Logic

Implement:

```text
Budget vs actual spending
Remaining budget
Usage percentage
Budget status
```

---

### Phase 8 — Postman

Create a proper collection:

```text
Expense
Income
Budget
Analytics
```

Test both success and failure cases.

---

### Phase 9 — React

Only now:

```text
React
  ↓
Dashboard
  ├── Income
  ├── Expenses
  ├── Budgets
  └── Analytics
```

---

# 🎯 Your actual challenge

I **don't recommend you start coding the entities yet**.

Since your goal is improving system design, your first deliverable should be:

```text
1. Requirements
2. Entity list
3. Attributes for every entity
4. Relationships
5. Business rules
6. API endpoints
```

Then show me your design.

I'll review it and tell you things like:

> ❌ This field doesn't belong here.

> ⚠️ This relationship could cause a problem.

> ✅ This constraint is good.

> 💡 You can solve this query using a database aggregation instead of fetching everything into Java.

That will give you much better practice than me simply handing you the Spring Boot code.

