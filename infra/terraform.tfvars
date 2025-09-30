aws_region         = "us-east-1"
cluster_name       = "fiap"
service_name       = "automotors-service"
task_family        = "automotors-task"

ecr_repo_url       = "831926610628.dkr.ecr.us-east-1.amazonaws.com/fiapautomotors-api"

vpc_id             = "vpc-08919bb76e216b7e4"
subnet_ids         = ["subnet-0f6cee5cff5b16d2e", "subnet-09a9dff59caa7bf3f"]
security_group_ids = ["sg-02b6103b8311e9bc6"]