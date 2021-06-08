### Listing Docker Images in Local Registry
```
docker images
```

### Downloading an docker image from Docker Hub(Remote Docker Registry - website)
```
docker pull hello-world:latest
docker pull ubuntu:16.04
```

### Creating a docker container in background mode
```
docker run -dit --name ubuntu1 --hostname ubuntu1 ubuntu:16.04 /bin/bash
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

