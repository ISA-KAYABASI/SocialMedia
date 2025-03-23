# Notes

## Adding Docker Images

    PostgreSQL
    userName: postgres
    password: root
    DB: AuthDB
```bash
#docker build -t jesus975/postgresql-authdb .
#docker push jesus975/postgresql-authdb
#docker pull jesus975/postgresql-authdb:latest
docker run -d --name postgresql -p 5432:5432 jesus975/postgresql-authdb:latest
```

    MongoDB
    userName: admin
    password: root
    DB: UserProfileDB
```bash
#docker build -t jesus975/mongodb .
#docker push jesus975/mongodb
#docker pull jesus975/mongodb:latest
docker run -d --name mongodb -p 27017:27017 jesus975/mongodb:latest
```


    mongod
    db.createUser({user: "isa", pwd: "root",roles: ["readWrite","dbAdmin"]})