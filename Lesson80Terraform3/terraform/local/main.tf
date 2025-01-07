resource "local_file" "pet" {
    filename = var.file_name
    content = var.content
    
}

resource "random_pet" "mrs_pet" {
    length = 1
    prefix = var.prefix
    separator = "."  
}


output "random_pet" {
    value = "the random pet is : ${random_pet.mrs_pet.id}"
  
}