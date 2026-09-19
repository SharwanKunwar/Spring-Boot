# 🚪 The Journey of a Request in Spring Boot

> What I learned: how a single HTTP request travels through Spring MVC as a short story.

---

## 📖 The Story

One day, a client sent a request to my app:

```http
POST /api/tasks
Host: localhost:8080

{
  "id": 1,
  "name": "sharwan jung kunwar"
}
```

**1. The Gatekeeper — Tomcat** 🏰
The request first reached **Tomcat**, the embedded server that Spring Boot ships with. Tomcat's only job is to receive the request and hand it to the one person in charge inside the castle.

**2. The Manager — DispatcherServlet** 🧭
That person is the **DispatcherServlet**, the front controller. Every request goes through it. It doesn't do the work itself. It just knows who should.

**3. The Map — HandlerMapping** 🗺️
The DispatcherServlet asked **HandlerMapping**: *"Who handles `POST /api/tasks`?"*
HandlerMapping answered: *"`StudentController.createStudent()`."*

**4. The Security Check — `preHandle()`** 🛂
Before going to the controller, the request passed through the **Interceptor**. Its `preHandle()` method is the checkpoint, the place for things like logging, auth checks, or blocking the request entirely.

**5. The Translator — HandlerAdapter** 🔌
Next came the **HandlerAdapter**. It knows how to actually call the controller method. It turns the JSON body into a Java object and invokes `createStudent()`.

**6. The Real Work — StudentController** 🎯
The **StudentController** did the job: it created the student and returned a result.

**7. The Follow-up — `postHandle()`** 📝
Once the controller finished, the Interceptor's `postHandle()` ran. This is the chance to look at or tweak things after the handler ran.

**8. The Cleanup — `afterCompletion()`** 🧹
Finally, `afterCompletion()` ran when everything was done. It's for cleanup and final logging.

**9. The Return Trip** 🔙
The response went back the same way it came: **DispatcherServlet → Tomcat → Client**.

---

## 🧠 Quick Cheat Sheet

| Step | Who | Job |
|------|-----|-----|
| 1 | **Tomcat** | Receives the request and returns the response |
| 2 | **DispatcherServlet** | Front controller that coordinates everything |
| 3 | **HandlerMapping** | Finds the right controller method |
| 4 | **`preHandle()`** | Runs *before* the controller |
| 5 | **HandlerAdapter** | Calls the controller method |
| 6 | **Controller** | Runs the business logic (`createStudent()`) |
| 7 | **`postHandle()`** | Runs *after* the controller |
| 8 | **`afterCompletion()`** | Runs at the very end, for cleanup |

---

## ✅ Key Takeaway

Spring MVC is a pipeline. **Tomcat** receives, **DispatcherServlet** directs, **HandlerMapping** finds, **Interceptors** guard before and after, **HandlerAdapter** executes, and the **Controller** does the actual work.