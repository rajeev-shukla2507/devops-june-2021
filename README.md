# Preparing lab environment
Your lab environment is already installed with Docker, Ansible, Jenkins, Sublime Text Editor.

### Installing Docker Community Edition
```
sudo yum install -y yum-utils
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install docker-ce
sudo systemctl enable docker && sudo sytemctl start docker
sudo usermod -aG docker jegan
sudo su jegan
```

### Installing Ansible
Check the version of python installed on your system
```
python3 --version
```
Create a soft link for python3 
```
sudo ln -s -f /usr/bin/python3.6 /usr/bin/python
```

Download pip tool and install pip
```
curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
chmod +x ./get-pip.py
./get-pip.py
```

Install Ansible as regular user(non-admin)
```
pip install ansible
pip install docker
```

Check the version of ansible
```
ansible --version
```
