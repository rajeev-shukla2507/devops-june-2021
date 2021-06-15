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
formatTreeString(
  {
    pom.xml
    children: [
      {
    	text: src
       }
    ]
  },
   {
    guideFormat: chalk.dim
  } 
  );
  
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
                    

### Create a pom.xml under Hello folder with the below content
```
<project>
	
	<modelVersion>4.0.0</modelVersion>

	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>

	<groupId>org.tektutor</groupId>
	<artifactId>tektutor-hello-app</artifactId>
	<version>1.0.0</version>

</project>
```

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
### Deleting target folder using maven
From the devops-june-2021/Day1/Hello Folder folder as regular use(non-admin), try this

```
mvn clean
```

### Performing a clean build
From the devops-june-2021/Day1/Hello Folder folder as regular use(non-admin), try this

The below command will delete the target folder and does a compile rebuild
```
mvn clean compile
```
### Integrating JUnit Test Framework into Hello java project
Update your pom.xml as shown 
```
<project>
	
	<modelVersion>4.0.0</modelVersion>

	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>

	<groupId>org.tektutor</groupId>
	<artifactId>tektutor-hello-app</artifactId>
	<version>1.0.0</version>

	<dependencies>
		<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>4.12</version>
		</dependency>
	</dependencies>

</project>
```
### To compile the application and test sources and then invoke test cases
```
mvn test
```

### Listing default life-cycle phases
```
mvn help:describe -Dcmd=compile
```

### Listing clean life-cycle phase
```
mvn help:describe -Dcmd=clean
```

### Listing site life-cycle phases
```
mvn help:describe -Dcmd=site
```

### Setup JFrog Artifactory

#### Download JFrog Artifactory docker image
```
docker pull docker.bintray.io/jfrog/artifactory-oss:latest
```

#### Start the JFrog Artifactory container
```
docker run --name artifactory -d -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```

#### Check if the JFrog Artifactory is running
```
docker ps
```

#### Finding the IP Address of JFrog Artifactory container
```
docker inspect artifactory | grep IPA
```

#### Accessing JFrog Artifactory Web console
From your lab machine Firefox or Chrome web browser
```
http://172.17.0.2:8081
```
Default Login Creditials are
```
username - admin
password - password
```
When it prompts to change the password, you may change it to
```
Admin@123
```
Skip all other configuration by accepting defaults.

Once you have created maven repository in JFrog Artifactory, copy your repository url and supply the url in pom.xml file under <distributionManagement> tag as shown below
```
<distributionManagement>
	<repository>
		<id>artifactory</id>
		<url>http://172.17.0.2:8082/artifactory/tektutor/</url>
	</repository>
</distributionManagement>
	
```

In order to encrypt the password, you need to use the below command
```
mvn --encrypt-master-password Admin@123
```
The above command will display the encrypted password. The encrypted password displayed in your system must be replaced in the below file.
	
You need to create the file /home/jegan/.m2/settings-security.xml with the below command
```
<settingsSecurity>                                                                                                                    	<master>{MK6ZKmMIGbUHrg4wbQcXV7u+bopGzwnMJ2BYgcfEbck=}</master>                                                             
</settingsSecurity> 	
```

#### Generate server password encryption
```	
mvn --encrypt-password Admin@123
```
The password displayed by the above command must be used in the settings.xml file as shown below.
```
<settings>
  <servers>
    <server>
      <id>artifactory</id>
      <username>admin</username>
      <password>{6M9iIepb2XQHQWs9HXmrgO4ASdh6k7LOr0sCFaJ/G6s=}</password>
    </server>
</settings>
```	
To keep things simple, I have not shown the existing settings in the above file, hence you need to retain them as it is. Just need to add a <server></server> tag with the JFrog artifactory credentials captured as shown above.
	
### Deploy Hello project artifacts to JFrog artifactory
```
mvn deploy
```
Once deployed you may see the deployed artifacts from your web browser at the below URL
```
http://172.17.0.2:8082/artifactory/tektutor/
```

### Deployment Configuration for CRM parent pom
```
<project>
	<modelVersion>4.0.0</modelVersion>

	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>

	<groupId>org.tektutor</groupId>
	<artifactId>crm</artifactId>
	<version>1.0.0</version>
	<packaging>pom</packaging>

	<modules>
		<module>frontend</module>
		<module>businesslayer</module>
		<module>backend</module>
		<module>main</module>
	</modules>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<distributionManagement>
		<repository>
			<id>artifactory</id>
			<url>http://172.17.0.2:8082/artifactory/tektutor/</url>
		</repository>
	</distributionManagement>

</project>
```

### Inspecting effective pom
From devops-june-2021/Day1/CRM folder, try the below command
```
mvn help:effective-pom
```

### Setting up SonarQube Server using docker
```
docker run -d --name sonar --hostname sonar sonarqube:latest
```

### Finding IP address of SonarQube container
```
docker inspect sonar | grep IPA
```
	
### Check if the sonarqube container is running
```
docker ps
```
	
### Accessing SonarQube Web Interface from Web browser
```
http://172.17.0.3:9000
```
Login Credentials
username - admin
password - admin

You may change the password to Admin@123
