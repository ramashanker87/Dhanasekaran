# Create CloudFormation for ECR

## Execute cloudformation to create ecr repository

    aws cloudformation deploy --template-file ecr-template.yml --stack-name dhanasekar-ecr-repo

## Verify ECR

###  List all ECR repositories:

    aws ecr describe-repositories 

### Check details of a specific repository:

    aws ecr describe-repositories --repository-names dhana-microservice-repo 

### List images in the repository:

    aws ecr list-images --repository-name dhana-microservice-repo

### Login to ECR (for Docker):

    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 975050323630.dkr.ecr.us-east-1.amazonaws.com

## Push Image to ECR

### Build docker image

### Tag Image with ECR Repository URL:

    docker tag 8889docker/calculator-app:1.0.0 975050323630.dkr.ecr.us-east-1.amazonaws.com/dhana-microservice-repo:calculator-app

### Login to ECR (for Docker):

    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 975050323630.dkr.ecr.us-east-1.amazonaws.com

### Push images:

    docker push 975050323630.dkr.ecr.us-east-1.amazonaws.com/dhana-microservice-repo

### List images in the repository:
    aws ecr list-images --repository-name dhana-microservice-repo
