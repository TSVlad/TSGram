minikube start;

kubectl proxy;

kubectl port-forward service/keycloak-service 8484:8080;

kubectl -n kubernetes-dashboard create token admin-user;

