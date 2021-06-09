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
If all went smooth, you are expected see "tektutor/ansible-ubuntu:latest" and "tektutor/ansible-centos:latest" images.

