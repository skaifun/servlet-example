# Servlet Example

## 示例

示例是实现一个 HTTP 接口，并通过日志将参数打印到控制台

- `hello?name=john` => `hello, john!`
- `hello` => `hello, world!`

## 实现

> 因为 Java + 注解的配置形式越来越受欢迎，所以提交是按照先 XML 然后改为等价的 Java+注解的配置方式。

首先是初始化了一个使用原生 Servlet 处理请求的示例，采用的事注解的方式。可以通过`git switch --detach simple-servlet-using-annotation`查看或运行对应的代码。

然后将注解删除，改为 web.xml 方式注册 Servlet。可以通过 `git switch --detach simple-servlet-using-webxml`
查看或运行对应的代码。

接着引入了 SpringMVC，将 Servlet 改为 Controller 之后，还需要添加 IoC 容器配置。并在 web.xml 中注册
DispatcherServlet 并将 IoC 容器配置作为初始化参数传入。可以通过 `git switch --detach springmvc-using-webxml+xml+annotation` 查看或运行对应的代码。

然后是将 IoC 容器配置改为使用 Java + 注解的方式编写，并修改 web.xml 中的配置。可以通过 `git switch --detach springmvc-using-webxml+java+annotation` 查看或运行对应的代码。

最后就是使用 Java 代码取代 web.xml，让配置类 `AppConfig` 实现 `WebApplicationInitializer` 接口，然后在
`onStartup` 方法中配置 `DispatcherServlet`。可以通过 `git switch --detach springmvc-using-java+annotation`
查看或运行对应的代码
