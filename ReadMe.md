What's Happening in the background?

- Let's explore some Spring Boot Magic: Enable Debug Logging
  - WARNING: Log change frequently!
- How are our requests handled?
  - DispatcherServlet: Front Controller Pattern
    - Mapping servlets: dispatcherServlet urls=[/]
    - Auto Configuration(DispatcherServletAutoConfiguration)
- How does HelloWorldBean object get converted to JSON?
    - @ResponseBody + JacksonHttpMessageConverters
       - Auto Configuration (JacksonHttpMessageConvertersConfiguration)
- Who is configuring error mapping?
    - Auto Configuration (ErrorMvcAutoConfiguration)
- How are all jars available(Spring, Spring MVC, Jackson, Tomcat)?    
  - Starter project (spring-boot-starter-web), spring-starter-tomcat
-     
-     