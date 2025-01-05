terraform {
    required_providers {
        linode = {
            source = "linode/linode"
            version = "2.25.0"
        }
    }
}

provider "linode" {
    token = var.token
}


# Create a Linode instance
resource "linode_instance" "linodePC" {
    region = var.region
    type = "g6-nanode-1"
    label           = var.label
    image           = "linode/ubuntu24.04"
    authorized_keys = var.ssh_keys
    root_pass       = var.root_pass

}