### Building custom ubuntu ansible node image
```
cd devops-june-2021/Day3/ubuntu-ansible
ssh-keygen
cp /home/jegan/.ssh/id_rs.pub authorized_keys
docker build -t tektutor/ansible-ubuntu .
```

### Building custom centos ansible node image```
```
cd devops-june-2021/Day3/centos-ansible
cp /home/jegan/.ssh/id_rs.pub authorized_keys
docker build -t tektutor/ansible-centos .
```

### Verify if both images are listed
```
docker images
```
If all went smooth, you are expected to see "tektutor/ansible-ubuntu:latest" and "tektutor/ansible-centos:latest" images.

### Creating ubuntu ansible node containers from our custom image
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ansible-ubuntu
docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ansible-ubuntu
```

### Verify if the containers are running
```
docker ps
```

### Verify if you are able to login with password onto the 'ubuntu1' and 'ubuntu2' containers via ssh
```
ssh -p 2001 root@localhost
ssh -p 2001 root@localhost
```
When prompted with question "Warning: Are you sure you want to continue connection (yes/no):" type yes.
When you type yes the finger-print of the ansible node will be added to your known_hosts files at /home/jegan/.ssh/known_hosts.

