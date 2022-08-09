搭建环境，`pom.xml`：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.kk</groupId>
    <artifactId>MyBatisReview</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.28</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
</project>
```

创建`mybatis-config.xml`配置文件：【注意这里的`typeAliases`起别名 `properties`配置文件配置信息 `mappers`映射文件路径】

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--properties: resources ==> 引用配置文件-->
    <properties resource="mybatis-jdbc.properties"/>
    <!--typeAliases 起别名 ==> typeAlias + type alias ===> package + name -->
    <typeAliases>
        <typeAlias type="com.kk.pojo.Student" alias="student"/>
        <package name="com.kk.pojo"/>
    </typeAliases>
    <environments default="mysql">
        <environment id="mysql">
            <!--
                transactionManager 标签：type ==> JDBC/MANAGED
                    JDBC: 表示当前环境中执行 SQL 使用的是 JDBC 原生管理方式，事务的提交需要手动 COMMIT/ROLLBACK
                    MANAGED: 被管理，比如 Spring
                dataSource 标签：type ==> POOLED/UNPOOLED/JNDI
                    POOLED: 表示使用数据库连接池缓存连接数据库
                    UNPOOLED: 表示不使用数据库连接池
                    JNDI: 表示使用上下文中的数据源
            -->
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/kk/mapper/StudentMapper.xml"/>
    </mappers>
    <!--<mappers>-->
    <!--    <package name="com.kk.mapper"/>-->
    <!--</mappers>-->
</configuration>
```

创建`mybatis-jdbc.properties`配置文件：

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/springboot?useSSL=false&serverTimezone=Asia/Shanghai
jdbc.username=root
jdbc.password=123456
```

创建`resources/com.kk.mapper.StudentMapper.xml Sql`映射文件：【注意别落下命名空间`namespace`】

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.kk.mapper.StudentMapper">
    <insert id="insertStudent">
        insert into student(`id`, `name`, `age`) values(4, "pat", 21)
    </insert>
</mapper>
```

创建`com.kk.pojo.Student`类：

```java
package com.kk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Integer age;
}
```

创建`com.kk.mapper.StudentMapper`接口：

```java
package com.kk.mapper;

public interface StudentMapper {
    public abstract int insertStudent();
}
```

创建`com.kk.service.StudentService1`类：

```java
package com.kk.service;

import com.kk.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentService {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int result = studentMapper.insertStudent();
        System.out.println(result);
    }
}
```

启动项目，通过`Navicat`可以发现整个`MyBatis`的基本使用就是这样子的。