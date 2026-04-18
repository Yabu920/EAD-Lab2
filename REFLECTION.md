# Reflection

## 1. Why should the ProductRequest DTO carry the @Valid annotations instead of the Product entity itself?

The `ProductRequest` DTO should carry the validation rules because it represents the data coming from the client. This keeps the API input rules separate from the database entity and makes the code cleaner. It also helps us control what users are allowed to send without tying that directly to the persistence model.

## 2. What is the purpose of the Location header returned on a POST 201 Created response, and which HTTP specification mandates it?

The `Location` header tells the client where the new resource can be found after it is created. This is useful because the client can immediately follow that URL to read the new product. The HTTP specification that defines this behavior is RFC 9110 for HTTP Semantics.

## 3. Explain the difference between @ControllerAdvice and @ExceptionHandler. When would you use each?

`@ExceptionHandler` is used to handle a specific exception in a controller or in a global advice class. `@ControllerAdvice` is used to apply shared exception handling logic across many controllers. I would use `@ExceptionHandler` for the actual handler method, and `@ControllerAdvice` when I want that handler to work for the whole application.

## 4. In MockMvc tests, what would happen to the database state between tests if @Transactional were removed?

If `@Transactional` were removed, the data created in one test would stay in the database for the next test unless we deleted it manually. That could make tests affect each other and cause unreliable results.

## 5. What does RFC 9457 define, and why is it better than returning a generic error message?

RFC 9457 defines Problem Details for HTTP APIs. It gives a standard structure for error responses, such as `type`, `title`, `status`, and `detail`. This is better than a generic error message because it is clearer, more consistent, and easier for clients to understand and handle.

## 6. What is the difference between an integration test (MockMvc) and a unit test (Mockito)? When is each preferable?

An integration test checks how multiple parts of the application work together, like the controller, service, repository, and database. A unit test checks one class or method by itself, usually with mocks such as Mockito. Integration tests are better when we want to test real application behavior, while unit tests are better for fast testing of small pieces of logic.
