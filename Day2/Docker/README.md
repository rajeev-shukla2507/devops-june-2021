### Listing Docker Images in Local Registry
```
docker images
```

### Downloading an docker image from Docker Hub(Remote Docker Registry - website)
```
docker pull hello-world:latest
docker pull ubuntu:16.04
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

### Listing all the currently running containers
```
docker ps
```

### Listing all containers irrespective of their running status
This will list containers even if they are in 'Exited' state.
```
docker ps -a
```
