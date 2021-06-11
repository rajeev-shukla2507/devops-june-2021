FROM ubuntu:16.04
MAINTAINER Jeganathan Swaminathan <jegan@tektutor.org>

RUN apt-get update && apt-get install -y openssh-server python3 python3 python3 git default-jdk maven 
RUN ln -s -f /usr/bin/python3 /usr/bin/python

RUN mkdir /var/run/sshd
RUN echo 'root:root' | chpasswd
RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# SSH login fix. Otherwise user is kicked off after login
RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd

RUN mkdir -p /root/.ssh

COPY .bashrc /root/.bashrc
RUN chmod 644 /root/.bashrc

COPY settings.xml /usr/share/maven/settings.xml

EXPOSE 22
EXPOSE 80 
CMD ["/usr/sbin/sshd", "-D"]
