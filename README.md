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

...

### 4. 运行
```
---- FINAL COUNTS ---
a : 1389
ate : 1390
beverages : 1390
cold : 1390
cow : 1389
dog : 2779
don't : 2777
fleas : 2778
has : 1390
have : 1389
homework : 1390
i : 4166
like : 2778
man : 1389
my : 2779
the : 1390
think : 1389
----------------------
```
