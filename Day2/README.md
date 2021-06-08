### Creating a hello world java application using archetype plugin
```
mvn archetype:generate \
     -DarchetypArtifactId=maven-archetype-quickstart 
     -DgroupId=org.tektutor 
     -DartifactId=tektutor-hello-app 
     -Dversion=1.0.0 
     -DinteractiveMode=false
```

### Packaging the hello world java application above
```
cd tektutor-hello-app
mvn package
```

### Creating a simple web application using archetype plugin
```world java 
mvn archetype:generate \
     -DarchetypArtifactId=maven-archetype-webapp 
     -DgroupId=org.tektutor 
     -DartifactId=tektutor-web-app 
     -Dversion=1.0.0 
     -DinteractiveMode=false
```

### Packaging the web application above
```
cd tektutor-web-app
mvn package
```
