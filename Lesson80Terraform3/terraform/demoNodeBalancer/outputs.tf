output "linode1_ip" {
    value = {
        public_ip = linode_instance.linode1.ip_address
        private_ip = linode_instance.linode1.private_ip_address
    }
  
}

output "linode2_ip" {
     value = {
        public_ip = linode_instance.linode2.ip_address
        private_ip = linode_instance.linode2.private_ip_address
    }
  
}