

docker-compose.yml ---> docker compose up -d 
docker swarm deployment ---> docker stack deploy --compose-file stack.yml banking

Repo : 

account-service/
├── Dockerfile
└── Dockerfile-2.0

transaction-service/
├── Dockerfile
└── Dockerfile-2.0

notification-service/
├── Dockerfile
└── Dockerfile-2.0

Here Dockerfile : Version 1.0 
=======================================

docker build \
  -f account-service/Dockerfile \
  -t snehalshinde11/account-service:1.0 \
  account-service/

  docker build \
  -f transaction-service/Dockerfile \
  -t snehalshinde11/transaction-service:1.0 \
  transaction-service/

  docker build \
  -f notification-service/Dockerfile \
  -t snehalshinde11/notification-service:1.0 \
  notification-service/


docker push snehalshinde11/account-service:1.0
docker push snehalshinde11/transaction-service:1.0
docker push snehalshinde11/notification-service:1.0


Build 2.0 : Here we have added the healthchecks 
--------------------------
In order to build the image use : 

docker build \
  -f account-service/Dockerfile-2.0 \
  -t snehalshinde11/account-service:2.0 \
  account-service/
  

docker build \
  -f notification-service/Dockerfile-2.0 \
  -t snehalshinde11/notification-service:2.0 \
  notification-service/

docker build \
  -f transaction-service/Dockerfile-2.0 \
  -t snehalshinde11/transaction-service:2.0 \
  transaction-service/

Push Images : 
docker push snehalshinde11/account-service:2.0
docker push snehalshinde11/transaction-service:2.0
docker push snehalshinde11/notification-service:2.0


