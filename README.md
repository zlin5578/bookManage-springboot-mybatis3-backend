# Springboot-MyBatis-MySQL-Demo
This is a demo projec to show you how to setup J2EE web application with Spring Boot, Mybatis, and MySQL.

## How To Use
You can git clone the project. Then use eclipse for J2EE to import the source code as maven project. 

### Clone Project
```
git clone https://github.com/jamesliu668/springboot-mybatis-mysql-demo.git
```

### Create MYSQL
```
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `pages` int(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `bookcaseid` int(10) DEFAULT NULL,
  `abled` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ieh6qsxp6q7oydadktc9oc8t2` (`bookcaseid`),
  CONSTRAINT `FK_ieh6qsxp6q7oydadktc9oc8t2` FOREIGN KEY (`bookcaseid`) REFERENCES `bookcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;

```

### Generate MyBatis DAO Mapper
The goal is not automatically executed by Maven. It can be executed from the command line with the command:
```
mvn mybatis-generator:generate
```

### Check Maven Dependency
```
mvn dependency:resolve
```

### Prepare Maven Dependency
```
mvn dependency:purge-local-repository
```

### Build/Compile Project
```
mvn clean install
```

If you want to build the project without testing, you can run following command:
```
mvn clean install -DskipTests
```

### Run Spring Boot Project with Build-in Tomcat
```
mvn spring-boot:run
```

## How To Test
After running the above commands, you can try the following urls to test the project:
```
http://localhost:8080/test
```
You will see `Hello World` in the browser.

```
http://localhost:8080/user
```
You will see the data in your database.


## Note
1. Files under src/main/java/com/james/demo/mybatis folders are automatically generated by eclipse plugin _MyBatis Generator_
2. In your database, you **must** have a `wp_users` table. Inside the table, you **must** have one record with `ID` column value to be `1`.