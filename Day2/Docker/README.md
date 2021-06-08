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

### Deleting a contianer forcibly
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
