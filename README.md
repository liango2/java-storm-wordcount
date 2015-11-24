# 单词计数


## 配置开发环境

### 1. 使用maven创建项目
```
mvn archetype:create -DgroupId=storm.blueprints -DartifactId=Chapter1 -DpackageName=storm.blueprints.chapter1.v1
```
### 2. cd Chapter1
### 3.修改pom.xml
```
 <dependency>
      <groupId>org.apache.storm</groupId>
      <artifactId>storm-core</artifactId>
      <version>0.9.1-incubating</version>
    </dependency>
```

### 3. 执行:
```
  mvn install
```

