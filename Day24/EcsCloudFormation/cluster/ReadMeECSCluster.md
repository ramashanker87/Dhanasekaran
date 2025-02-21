# Creating ECS Cluster

## Create Using Cloudformation
    aws cloudformation deploy --template-file ecs-cluster.yml --stack-name dhana-create-ecs-fargate-cluster

### List cluster
    aws ecs list-clusters

### List cluster service
    aws ecs list-services --cluster <CLUSTER_NAME> 
    aws ecs list-services --cluster dhanasekar-test-calculator-cluster

## Delete cloud formation
    aws cloudformation delete-stack --stack-name dhana-create-ecs-fargate-cluster