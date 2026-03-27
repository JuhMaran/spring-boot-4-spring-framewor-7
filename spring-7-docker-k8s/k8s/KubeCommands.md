# Images

* `spring-7-gateway:0.0.1-SNAPSHOT`
* `spring-7-auth-server:0.0.1-SNAPSHOT`
* `spring-7-rest-mvc:0.0.1-SNAPSHOT`
* `spring-7-reactive-mongo:0.0.1-SNAPSHOT`
* `spring-7-reactive:0.0.1-SNAPSHOT`

Display all K8s resources in the default namespace

```bash
kubectl get all
```

Display all K8s resources in the default namespace with more details

```bash 
kubectl get all -o wide
```

## Mongo

Create Deployment for Mongo

```bash
kubectl create deployment mongo --image=mongo --dry-run=client -o yaml > mongo-deployment.yaml
```

Apply Deployment

```bash
kubectl apply -f mongo-deployment.yaml
```

Create Service for Mongo

```bash
kubectl create service clusterip mongo --tcp=27017:27017 --dry-run=client -o yaml > mongo-service.yaml
```

Apply Service for Mongo

```bash
kubectl apply -f mongo-service.yaml
```

Delete Service for Mongo

```bash
kubectl delete service mongo
```

Delete Deployment for Mongo

```bash
kubectl delete deployment mongo
```

View logs for Mongo

```bash 
kubectl logs mongo-<pod-id>
```

## Auth Server

Create Deployment for Auth-server

```bash
kubectl create deployment auth-server --image=spring-7-auth-server:0.0.1-SNAPSHOT --dry-run=client -o yaml > auth-server-deployment.yaml
```

Apply Deployment for Auth-server

```bash
kubectl apply -f auth-server-deployment.yaml
```

Create Service for Auth-server

```bash
kubectl create service clusterip auth-server --tcp=9000:9000 --dry-run=client -o yaml > auth-server-service.yaml
```

Apply Service for Auth-server

```bash
kubectl apply -f auth-server-service.yaml
```

Port forward to Gateway

```bash
kubectl port-forward service/gateway 8080:8080
```

---

## MySQL

Apply Deployment for MySQL

```bash
kubectl create deployment mysql --image=mysql:latest --dry-run=client -o yaml > mysql-deployment.yaml
```

Create Service for MySQL

```bash
kubectl create service clusterip mysql --tcp=3606:3606 --dry-run=client -o yaml > mysql-service.yaml
```

Apply Service for Auth-server

```bash
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml

kubectl get all
```

## Rest MVC

Apply Deployment for Rest MVC

```bash
kubectl create deployment rest-mvc --image=spring-7-rest-mvc:0.0.1-SNAPSHOT --dry-run=client -o yaml > rest-mvc-deployment.yaml
```

Create Service for Rest MVC

```bash
kubectl create service clusterip rest-mvc --tcp=8080:8080 --dry-run=client -o yaml > rest-mvc-service.yaml
```

Apply Service for Rest MVC

```bash
kubectl apply -f rest-mvc-deployment.yaml
kubectl apply -f rest-mvc-service.yaml

kubectl get all
```

## Reactive

Apply Deployment for Reactive

```bash
kubectl create deployment 
```

Create Service for Reactive

```bash
kubectl create service clusterip 
```

Apply Service for Reactive

```bash
```

## Reactive Mongo

Apply Deployment for Reactive Mongo

```bash
kubectl create deployment 
```

Create Service for Reactive Mongo

```bash
kubectl create service clusterip 
```

Apply Service for Reactive Mongo

```bash
```