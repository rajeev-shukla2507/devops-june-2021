### Pull the delta changes from https://github.com/tektutor/devops-june-2021.git
```
cd devops-june-2021
git pull
```

### Building custom ubuntu ansible node image
when you execute ssh-keygen accept all defaults by hitting enter - 3 times :)
```
cd devops-june-2021/Day3/ubuntu-ansible
ssh-keygen
cp /home/jegan/.ssh/id_rs.pub authorized_keys
docker build -t tektutor/ansible-ubuntu .
```

Make sure you are replaced the authorized_keys with your public key(id_rsa.pub from /home/jegan/.ssh/id_rsa.pub)

### Building custom centos ansible node image
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
docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ansible-ubuntu:latest
docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ansible-ubuntu:latest
```

### Verify if the 'ubuntu1' and 'ubuntu2' containers are running
```
docker ps
```

### Verify if you are able to login without password onto the 'ubuntu1' and 'ubuntu2' containers via ssh
```
ssh -p 2001 root@localhost
ssh -p 2001 root@localhost
```
When prompted with question "Warning: Are you sure you want to continue connecting (yes/no):" type yes.
When you type yes the finger-print of the ansible node will be added to your known_hosts files at /home/jegan/.ssh/known_hosts.
In the place of 'localhost' you may type the IP Address of the docker server machine.

### Creating centos ansible node containers from our custom image
```
docker run -d --name centos1 --hostname centos1 -p 2003:22 -p 8003:80 tektutor/ansible-centos:latest
docker run -d --name centos2 --hostname centos2 -p 2004:22 -p 8004:80 tektutor/ansible-centos:latest
```
### Verify if the 'centos1' and 'centos2' containers are running
```
docker ps
```

### Verify if you are able to login without password onto the 'ubuntu1' and 'ubuntu2' containers via ssh
```
ssh -p 2003 root@localhost
ssh -p 2004 root@localhost
```
When prompted with question "Warning: Are you sure you want to continue connecting (yes/no):" type yes.
When you type yes the finger-print of the ansible node will be added to your known_hosts files at /home/jegan/.ssh/known_hosts.
In the place of 'localhost' you may type the IP Address of the docker server machine.


### See if ansible ping works
```
cd devops-june-2021/Day3/Ansible
ansible -i hosts all -m ping
```
