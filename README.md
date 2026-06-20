# Spring Boot Ecosystem — Layer Map

How a request moves from the client down through Spring's modules to the database, and which modules sit on top of Spring Core.

![Spring Boot ecosystem diagram showing Client to SpringBoot Application to Spring Data JPA to Hibernate to JDBC to DB, with SpringBoot Application also branching to Spring MVC, Spring Security, Spring AOP, and Spring Data, all resting on Spring Core](./assets/spring-boot-ecosystem.svg)

<details>
<summary>Mermaid version (renders natively on GitHub, no image file needed)</summary>

```mermaid
flowchart TD
    Client([Client]) --> SBA[SpringBoot Application]
    SBA --> SDJPA((Spring Data JPA))
    SDJPA --> Hibernate((Hibernate))
    Hibernate --> JDBC((JDBC))
    JDBC --> DB[(DB)]

    SBA --> MVC[Spring MVC]
    SBA --> Sec[Spring Security]
    SBA --> AOP[Spring AOP]
    SBA --> Data[Spring Data]

    MVC --> Core[Spring Core]
    Sec --> Core
    AOP --> Core
    Data --> Core
```

</details>

## What it means

| Path | Purpose |
|---|---|
| `Client → SpringBoot Application` | Entry point for every incoming request |
| `→ Spring Data JPA → Hibernate → JDBC → DB` | The persistence chain — JPA is the abstraction, Hibernate is the ORM implementing it, JDBC is the low-level DB driver layer |
| `Spring MVC / Security / AOP / Data` | Pluggable modules a SpringBoot Application can use, each built on top of... |
| `Spring Core` | ...the IoC/DI container every other module depends on |