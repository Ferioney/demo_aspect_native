# demo_aspect_native

Demo application to show that AspectJ works when bean is declared as class and doesn't work when bean is declared as interface.

- [DefaultHomeService](https://github.com/Ferioney/demo_aspect_native/blob/main/src/main/java/com/example/demo/logic/DefaultHomeService.java) - service with aspect
- [HomeAspect](https://github.com/Ferioney/demo_aspect_native/blob/main/src/main/java/com/example/demo/logic/HomeAspect.java) - aspect
- [Hint configuration](https://github.com/Ferioney/demo_aspect_native/blob/main/src/main/java/com/example/demo/logic/LogicConfiguration.java#L27-L33) 
- [bean declaration](https://github.com/Ferioney/demo_aspect_native/blob/main/src/main/java/com/example/demo/logic/LogicConfiguration.java#L14-L17)

Steps:
- provide service bean as class:
- run application as regular app
- GET /home and see that Aspect works: "From aspect: Welcome!"
- stop app
- build native application: `mvn -Pnative native:compile`
- run app: `./target/demo`
- GET /home and see that Aspect works: "From aspect: Welcome!"
- change service bean declaration from class to interface (from `DefaultHomeService` to `HomeService`)
- build native application: `mvn -Pnative native:compile`
- run app: `./target/demo`: application doesn't start with error:
```
Caused by: java.lang.IllegalArgumentException: error Type referred to is not an annotation type: com$example$demo$logic$AspectAnnotation
        at org.aspectj.weaver.tools.PointcutParser.parsePointcutExpression(PointcutParser.java:319) ~[demo:na]
        at org.springframework.aop.aspectj.AspectJExpressionPointcut.buildPointcutExpression(AspectJExpressionPointcut.java:222) ~[na:na]
        at org.springframework.aop.aspectj.AspectJExpressionPointcut.obtainPointcutExpression(AspectJExpressionPointcut.java:193) ~[na:na]
        at org.springframework.aop.aspectj.AspectJExpressionPointcut.getClassFilter(AspectJExpressionPointcut.java:172) ~[na:na]
```
