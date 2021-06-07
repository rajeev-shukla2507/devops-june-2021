# Preparing lab environment
Already your lab environment is already installed with Docker, Ansible, Jenkins, git and Sublime Text Editor.

Your lab environment is already installed with Docker, Ansible, Jenkins, Sublime Text Editor, git and Chrome Web browser.
The below instructions are just for your curiosity, hence you don't need to perform any installations.

### Installing Docker Community Edition
For detailed instructions, refer the official documentation here
https://docs.docker.com/engine/install/centos/

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

### Checking your docker version
```
docker version
```

### You should be able to access docker commands as regular user (non-admin)
```
docker images
```
If the above command returns an empty list of docker images. Your docker is setup correctly.
If not try 
```
sudo su jegan
docker images
```
You need to replace user 'jegan' with your lab machine user.


### Installing Ansible
For detailed instructions, refer the official documentation here https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html

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

### Installing Java Development Kit
```
sudo yum install -y epel-release
sudo yum install -y java-11-openjdk-devel
```
Check the version of javac installed
```
javac -version
java -version
```

### Installing Apache Maven
For detailed instruction refer the official documentation here https://maven.apache.org/download.cgi
```
cd /home/jegan/Downloads
wget https://mirrors.estointernet.in/apache/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
tar xvfz apache-maven-3.8.1-bin.tar.gz
```

Setting up the environment variables
Edit /home/jegan/.bashrc and paste the below at the end of the file 
```
set -o vi
export M2_HOME=/home/jegan/Downloads/apache-maven-3.8.1
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.11.0.9-2.el8_4.x86_64
export PATH=$JAVA_HOME/bin:$M2_HOME/bin:$PATH
```

To apply the environment setting changes
```
source /home/jegan/.bashrc
```

### Download Jenkins
```
cd /home/jegan/Downloads
wget https://get.jenkins.io/war-stable/2.289.1/jenkins.war
```

### Starting Jenkins
```
cd /home/jegan/Downloads
java -jar ./jenkins.war
```
As the above command is a blocking command it would start printing the activities in the interactively fashion.
You need to use a different terminal leaving the jenkins run in the current terminal interactively.  Pressing Ctrl+C will terminate Jenkins, hence avoid using Ctrl+C on the Jenkins terminal. 

### You may access the Jenkins Dashboard from Chrome browser
```
http://localhost:8080
```
