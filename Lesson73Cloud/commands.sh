
# Update and upgrade
sudo apt update
sudo apt upgrade -y

# enter root using ssh
ssh root@172.232.217.85

# Generate SSH key
ssh-keygen -t ed25519 -C "default"



scp C:\Users\iliap/.ssh/id_ed25519.pub root@<your ip address>:~/.ssh/id_ed25519.pub

cat id_ed25519.pub > authorized_keys

ssh root@172.232.217.85 -i C:\Users\<username>\.ssh\id_ed25519