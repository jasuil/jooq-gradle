# jooq-gradle and apache-spark
jooq-gradle => very simple start project with h2database

how to customize
1. delete org.example.jooq.db packages and subpackages
2. modify build.gradle at
.configuration('xmlns': 'http://www.jooq.org/xsd/jooq-codegen-3.7.0.xsd') {
    jdbc() {
       driver('org.h2.Driver')
        url('jdbc:h2:tcp://localhost/~/jooq')
        user('jasuil')
        password('')
        
    }
3. create db schema
4. in console, gradle build
5. you find out new package, org.example.jooq.db


how to use spark?
in src/test package, find out spark.java, spark2.java
