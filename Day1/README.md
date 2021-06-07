# Maven Overview

### Create a Hello console java application using Maven as a build tool
As a regular user (non-admin)
```
mkdir Hello
cd Hello
mkdir -p src/main/java/org/tektutor
mkdir -p src/test/java/org/tektutor
touch pom.xml
touch src/main/java/org/tektutor/Hello.java
touch src/test/java/org/tektutor/HelloTest.java

tree
```

The output should look as shown below
[jegan@tektutor Hello]$ tree
.
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── org
    │           └── tektutor
    │               └── Hello.java
    └── test
        └── java
            └── org
                └── tektutor
                    └── HelloTest.java

### Listing Maven compiler plugin goals and argument details
You may type any one of the below commands
```
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1 -Ddetail
mvn help:describe -Dplugin=compiler -Ddetail
```
