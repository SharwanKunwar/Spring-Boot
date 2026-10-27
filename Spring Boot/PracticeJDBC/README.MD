# JDBC Statement: executeQuery vs executeUpdate vs execute

When you talk to a database from Java using JDBC, the `Statement` interface gives you three main methods to run SQL. Picking the right one depends on what your SQL does. Here's a short, practical guide.

## 1. `executeQuery()` — for SELECT

Use it when your SQL **reads** data and returns rows.

**Syntax**

```java
ResultSet executeQuery(String sql) throws SQLException
```

**Return type:** `ResultSet` (never `null`)

**Example**

```java
try (Connection con = DriverManager.getConnection(url, user, pass);
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery("SELECT id, name FROM users")) {

    while (rs.next()) {
        System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
    }
}
```

**Note:** Throws `SQLException` if you pass a non-SELECT statement like INSERT or UPDATE.

## 2. `executeUpdate()` — for INSERT, UPDATE, DELETE, DDL

Use it when your SQL **changes** data or structure.

**Syntax**

```java
int executeUpdate(String sql) throws SQLException
```

**Return type:** `int`

- For INSERT / UPDATE / DELETE: the **number of rows affected**
- For DDL (CREATE, DROP, ALTER): `0`

**Example**

```java
int rows = st.executeUpdate("UPDATE users SET name = 'Ram' WHERE id = 1");
System.out.println(rows + " row(s) updated");
```

**Note:** Throws `SQLException` if the SQL returns a `ResultSet` (a SELECT). For very large counts, use `executeLargeUpdate()`, which returns `long`.

## 3. `execute()` — when you don't know the SQL type

Use it for **any** SQL, especially dynamic queries or stored procedures that might return rows, counts, or both.

**Syntax**

```java
boolean execute(String sql) throws SQLException
```

**Return type:** `boolean`

- `true` → the result is a `ResultSet` (get it with `getResultSet()`)
- `false` → the result is an update count (get it with `getUpdateCount()`) or there is no result

**Example**

```java
boolean hasResultSet = st.execute(sql);

if (hasResultSet) {
    ResultSet rs = st.getResultSet();
    // read rows
} else {
    int count = st.getUpdateCount();
    System.out.println(count + " row(s) affected");
}
```

## Quick Comparison

| Method | Used for | Return type | Returns |
|---|---|---|---|
| `executeQuery()` | SELECT | `ResultSet` | The rows |
| `executeUpdate()` | INSERT, UPDATE, DELETE, DDL | `int` | Rows affected (0 for DDL) |
| `execute()` | Any SQL | `boolean` | `true` if ResultSet, else `false` |

## Which one should you use?

- Reading data → `executeQuery()`
- Modifying data → `executeUpdate()`
- Unknown or multiple results (stored procedures) → `execute()`

## Pro tip: use PreparedStatement

If your SQL includes user input, don't build it with string concatenation. `Statement` is vulnerable to **SQL injection**. Use `PreparedStatement`, which has the same three methods (without the SQL argument) and safely binds parameters:

```java
PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
ps.setInt(1, 5);
ResultSet rs = ps.executeQuery();
```

## Conclusion

Match the method to the SQL: `executeQuery` for SELECT, `executeUpdate` for changes, and `execute` when you can't be sure. Always close your resources with try-with-resources, and prefer `PreparedStatement` in real applications.