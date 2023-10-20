greetgo!

docker pull mongo
docker run -d --name mongo-gpwrcbrbwqisfmxhopmd -e MONGO_INITDB_DATABASE=gpwrcbrbwqisfmxhopmd  -p 27017:27017 mongo

docker pull postgres
docker run -d --name postgres-gpwrcbrbwqisfmxhopmd -p 5432:5432 -e POSTGRES_DB=gpwrcbrbwqisfmxhopmd -e POSTGRES_PASSWORD=postgres postgres