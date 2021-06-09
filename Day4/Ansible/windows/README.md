### Windows Ansible Node Setup
In my case I used a Windows 2019 Server. Launch PowerShell ISE and paste the below to install WinRM
```
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$url = "https://raw.githubusercontent.com/ansible/ansible/devel/examples/scripts/ConfigureRemotingForAnsible.ps1"
$file = "$env:temp\ConfigureRemotingForAnsible.ps1"

(New-Object -TypeName System.Net.WebClient).DownloadFile($url, $file)

powershell.exe -ExecutionPolicy ByPass -File $file
```

### Verify if WinRM listeners are running
If WinRM is installed and running, you will see two listeners one at port 5985 and the other at 5986.
```
winrm enumerate winrm/config/Listener
```
