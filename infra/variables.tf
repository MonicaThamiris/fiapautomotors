variable "aws_region" {}
variable "service_name" {}
variable "cluster_name" {}
variable "vpc_id" {}
variable "task_family" {}
variable "ecr_repo_url" {}
variable "image_tag" {}
variable "subnet_ids" {
  type = list(string)
}
variable "security_group_ids" {
  type = list(string)
}