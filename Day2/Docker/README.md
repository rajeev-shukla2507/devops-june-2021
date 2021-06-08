### Listing Docker Images in Local Registry
```
docker images
```

### Downloading an docker image from Docker Hub(Remote Docker Registry - website)
```
docker pull hello-world:latest
docker pull ubuntu:16.04
```

### Deleting a docker image from local registry
```
docker rmi hello-world:latest
```

### Finding more details about a docker image
```
docker image inspect ubuntu:16.04
```

### Creating docker container in background mode
```
docker run -dit --name ubuntu1 --hostname ubuntu1 ubuntu:16.04 /bin/bash
```

### Getting inside a container shell
```
docker exec -it ubuntu1 /bin/bash
```

### Coming out of container
```
exit
```

### Creating docker containers in interactive mode
```
docker run -it --name ubuntu2 --hostname ubuntu2 ubuntu:16.04 /bin/bash
```

### Coming out of the interactive container without exiting the container
```
Ctrl + p + q
```

### Listing all the currently running containers
```
docker ps
```

### Listing all containers irrespective of their running status
This will list containers even if they are in 'Exited' state.
```
docker ps -a
```

### Renaming a container
```
docker ps
docker rename ubuntu1 container-1
docker ps
```

### Deleting a container graciously
```
docker stop ubuntu1 && docker rm ubuntu1
```

### Deleting a container forcibly
```
docker rm -f ubuntu1
```

### Finding more details about a container
```
docker inspect ubuntu2 
```

### Finding IP Address of a container
```
docker inspect ubuntu2 | grep IPA
docker inspect -f {{.NetworkSettings.IPAddress}} ubuntu2
```

### You may also find the IP Address of a container after getting inside the container
```
docker exec -it ubuntu2 bash
hostname -i
exit
```

### Listing all then networks docker supports
```
docker network ls
```

### Creating your own bridge network
```
docker network create my-network-1
```

### Creating a new container and connecting to my-network-1
```
docker run -dit --name c1 --hostname c1 --network=my-network-1 ubuntu:16.04 bash
```

### Find IP Address of c1 container
```
docker inspect c1 | grep IPA
```
Assuming IP Address of c1 container is 172.18.0.2

### Creating another bridge network
```
docker network create my-network-2
```

### Creating a new container and connecting to my-network-1
```
docker run -dit --name c2 --hostname c2 --network=my-network-2 ubuntu:16.04 bash
```


### Find IP Address of c2 container
```
docker inspect c2 | grep IPA
```
Assuming IP Address of c2 container is 172.19.0.2

### Now get inside c1 container
```
docker exec -it c1 bash
```

### Install ifconfig and ping utility inside c1 container
```
apt-get update && apt-get install -y net-tools iputils-ping
```

### From another terminal, get inside c2 container
```
docker exec -it c2 bash
```

### Install ifconfig and ping utility inside c2 container
```
apt update && apt install -y net-tools iputils-ping
```
### From the 'c1' container terminal ping 'c2' container
```
ping 172.18.0.2
```
You may observe, 'c2; container isn't reachable from 'c1' container as they belong to different networks.

### You may connect 'c1' container to my-network-2 so that 'c1' and 'c2' will be able to communicate with each other.
```
docker network connect my-network-2 c1
```

### Now 'c1' container is connected to two networks and has two NIC (Network Interface cards).
```
docker inspect c1
```

### From 'c1' container you may ping 'c2'
```
ping 172.19.0.2
```

### From 'c2' container you may ping 'c1'
```
ping 172.19.0.3
```

### Create an nginx container
```
docker run -d --name web1 --hostname web1 nginx:1.18
```

### Check if the web1 container is running
```
docker ps
```

### Find the IP Address of the web1 container
```
docker inspect web1 | grep IA
```

### Access the nginx web1 container web page
```
curl http://172.17.0.2:80
```
Using the same url http://172.17.0.2:80 you may access from a web browser on the same machine where the container is running.
As the containers are assigned with Private IPs they aren't accessible outside the machine where they are running.


### Volume mounting
```
docker run -d --name mysql1 --hostname mysql1 -v /tmp/mydata:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql:latest
```

### Get inside the 'mysql1' container
```
docker exec -it mysql1 sh
```

### Connect to mysql server
```
mysql -u root -p
```
When prompts for password, type root as the password.

### Create Database, table and insert some rows
```
CREATE DATABASE tektutor;
USE tektutor;
CREATE TABLE training;

INSERT INTO training VALUES ( 1, "DevOps" "5 Days" );
INSERT INTO training VALUES ( 2, "Qt Programming" "5 Days" );
INSERT INTO training VALUES ( 3, "Apache Kafka" "5 Days" );

SELECT * FROM training;
```

### Now come out of the container
```
exit
exit
```

### Delete the 'mysql1' container
```
docker rm -f mysql1
```

### Create a new mysql container and mount the same host path
```
docker run -d --name mysql2 --hostname mysql2 -v /tmp/mydata:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql:latest
```

### Get inside the 'mysql2' container
```
docker exec -it mysql2 bash
```

### Connect to mysql server
```
mysql -u root -p
```
When prompted for password, type root as the password.

### Check if the 'tektutor' database and 'training' table and its records are intact
```
SHOW DATABASES;
USE tektutor;
SHOw TABLES;
SELECT * FROM training;
```
The expectation is, you should see tektutor, training table and its records safe as the mysql data is stored outside the container storage.
