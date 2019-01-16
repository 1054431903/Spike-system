#Spike-system
#### introduction

follow the course of imooc

and this project is based on SpringBoot

##### v 0.0.1
init environment and use tools to create domain,dao and mapper

###### how to use the tool:
1. 在pom文件中添加plugin
```xml
<plugin>
<groupId>org.mybatis.generator</groupId>
<artifactId>mybatis-generator-maven-plugin</artifactId>
<version>1.3.7</version>
<dependencies>
    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-core</artifactId>
        <version>1.3.7</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
<executions>
    <execution>
        <id>mybatis generator</id>
        <phase>package</phase>
        <goals>
            <goal>generate</goal>
        </goals>
    </execution>
</executions>
<configuration>
    <!--允许移动生成的文件-->
    <verbose>true</verbose>
    <!--允许自动覆盖文件-->
    <overwrite>true</overwrite>
    <configurationFile>
        <!--此路径是存放配置文件的路径，sql相关的自动生成就在这里面配置-->
        src/main/resources/mybatis-generator.xml
    </configurationFile>
</configuration>
</plugin>
```
然后配置mybatis-generator.xml，具体配置见文件