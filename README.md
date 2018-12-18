# SpringBoot-Integrate
SpringBoot2.1.1集成kafka+log4j2+httpclient
==================================================
这是一个SpringBoot的实例程序
maven工程interfacedataacquisition在SpringBoot2.1.1的基础上集成了kafka、log4j2和httpclient等组件，用来将http请求拿到的数据保存到kafka主题中。

在kafka消费者监听主题的方法中，如果被监听的主题定义在配置文件中可以使用EL表达式来获取多个kafka主题
@KafkaListener(topics = "#{'${spring.kafka.topics}'.split(',')}")
