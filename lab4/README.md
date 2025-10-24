# Elibrary - Lab 4

This repository contains a simple Spring Boot application used for lab exercises.

## Short answers (with examples)

1. What is Spring?

Spring is a large and modular application framework for Java that provides infrastructure support for developing Java applications. It offers features like dependency injection, transaction management, web MVC, data access, security, and more. Spring's core idea is to make Java development easier by managing objects and their lifecycles, promoting loose coupling and testability.

Example (conceptual):
- A `BookService` class is defined as a Spring component and injected into a `BookController` to handle requests.

2. What is Spring Boot?

Spring Boot is an opinionated layer on top of the Spring framework that simplifies creating production-ready Spring applications. It reduces configuration by providing sensible defaults, auto-configuration, an embedded application server (like Tomcat), and a convention-over-configuration approach.

Example (project):
- `ElibraryApplication.java` in this repo is a Spring Boot application with a `main` method that starts the embedded server and loads the Spring context.

3. What is the relation between Spring platform and Spring Boot?

The Spring platform is the broad ecosystem of Spring projects and modules (Spring Framework, Spring Data, Spring Security, Spring Integration, Spring Cloud, etc.). Spring Boot is a project within the Spring platform designed to make it easier to create stand-alone, production-ready applications by auto-configuring the components from the platform.

Example: Spring Boot auto-configures Spring MVC (from the Spring Framework) when it detects `spring-webmvc` on the classpath.

4. What is the relation between Spring platform and Spring framework?

The Spring Framework is the core component of the Spring platform. It provides foundational features such as dependency injection (the IoC container), AOP, transaction management, and the Web MVC framework. The Spring platform includes the Spring Framework plus complementary projects like Spring Data and Spring Security.

Example: The IoC container and `@Component`/`@Autowired` come from the Spring Framework; Spring Data builds on top of the framework to provide repository abstractions.

5. What is Dependency Injection and how is it done in the Spring platform/framework?

Dependency Injection (DI) is a design pattern where an object's dependencies (collaborators) are provided from the outside rather than created by the object itself. This promotes loose coupling and easier testing.

In Spring, DI is provided by the IoC container which manages beans. You typically declare components using annotations like `@Component`, `@Service`, `@Repository`, or `@Controller`, and inject dependencies using `@Autowired`, constructor injection, or `@Inject`.

Example (code):

```java
// Component
@Service
public class BookService {
    // ...business logic...
}

// Controller with constructor injection
@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ...request handling...
}
```

6. What is Inversion of Control (IoC) and how is it related to Spring?

Inversion of Control is a design principle where the control of object creation and lifecycle is inverted: instead of objects creating their dependencies, an external entity (the framework or container) manages and provides them. Spring's IoC container implements this principle by instantiating, configuring, and assembling beans.

Example: In the example above, the `BookController` does not create `BookService`; the Spring container creates and injects it.

---

## How to run this project (quick)

From the project root (where `pom.xml` is located):

```powershell
.\mvnw.cmd spring-boot:run
```

Or build a jar and run:

```powershell
.\mvnw.cmd package; java -jar target\elibrary-0.0.1-SNAPSHOT.jar
```
