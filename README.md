# How to reproduce the issue

1. Run `mvn clean package`
2. Run `cd target`
3. Run the built jar via `java -jar server-query-issue-0.0.1.jar`

You should now see the following exception:

```
Exception in thread "main" java.lang.reflect.InvocationTargetException
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.lang.IllegalStateException: Option key 'failsafeEnabled' does not exists
        at com.ibasco.agql.core.util.Options.getOrDefault(Options.java:117)
        at com.ibasco.agql.core.util.Options.getOrDefault(Options.java:111)
        at com.ibasco.agql.core.util.FailsafeBuilder.buildRetryPolicy(FailsafeBuilder.java:91)
        at com.ibasco.agql.core.transport.FailsafeChannelFactory.buildRetryPolicy(FailsafeChannelFactory.java:97)
        at com.ibasco.agql.core.transport.FailsafeChannelFactory.<init>(FailsafeChannelFactory.java:79)
        at com.ibasco.agql.core.transport.DefaultNettyChannelFactoryProvider.getContextualFactory(DefaultNettyChannelFactoryProvider.java:68)
        at com.ibasco.agql.protocols.valve.source.query.SourceQueryMessenger.createChannelFactory(SourceQueryMessenger.java:223)
        at com.ibasco.agql.core.NettyMessenger.<init>(NettyMessenger.java:84)
        at com.ibasco.agql.protocols.valve.source.query.SourceQueryMessenger.<init>(SourceQueryMessenger.java:110)
        at com.ibasco.agql.protocols.valve.source.query.SourceQueryClient.createMessenger(SourceQueryClient.java:269)
        at com.ibasco.agql.protocols.valve.source.query.SourceQueryClient.createMessenger(SourceQueryClient.java:119)
        at com.ibasco.agql.core.AbstractClient.messenger(AbstractClient.java:123)
        at com.ibasco.agql.core.AbstractClient.send(AbstractClient.java:109)
        at com.ibasco.agql.core.AbstractClient.send(AbstractClient.java:87)
        at com.ibasco.agql.protocols.valve.source.query.SourceQueryClient.getPlayers(SourceQueryClient.java:228)
        at de.darkatra.serverqueryissue.ServerQueryIssueApplication.main(ServerQueryIssueApplication.java:22)
        ... 8 more
```
