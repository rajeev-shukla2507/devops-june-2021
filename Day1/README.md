# Maven Overview

### Create a Hello console java application using Maven as a build tool
As a regular user (non-admin)
```devops-june-2021/Day1/Hello/target/classes
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
                    
                    
### Under devops-june-2021/Day1/Hello folder create the below file in src/main/java/org/tektutor/Hello.java
```
package org.tektutor;

public class Hello {

	public String sayHello() {
		return "Hello DevOps!";
	}

	public static void main(String[] args) {
		
		Hello hello = new Hello();
		System.out.println ( hello.sayHello() );

	}

}
```

### Listing Maven compiler plugin goals and argument details
You may type any one of the below commands
```
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1 -Ddetail
mvn help:describe -Dplugin=compiler -Ddetail
```

### Compiling Hello Maven Project
From the devops-june-2021/Day1/Hello Folder folder as regular use(non-admin), try this
```
mvn compile
```
When you type the above command, maven will look for pom.xml file in the current directory, otherwise maven compile will fail.

### Executing the newly compiled Hello java application
Assuming you are in /home/jegan folder
````
cd /home/jegan/devops-june-2021/Day1/Hello/target/classes
tree
java org.tektutor.Hello
````
