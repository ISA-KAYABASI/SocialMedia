# PostgreSQL'in resmi image'ını baz alıyoruz
#FROM postgres:latest
#
## Varsayılan environment değişkenleri
#ENV POSTGRES_USER=postgres
#ENV POSTGRES_PASSWORD=root
#ENV POSTGRES_DB=AuthDB
#
## Eğer özel SQL dosyaları veya veriler eklemek istersen
## COPY init.sql /docker-entrypoint-initdb.d/
#
## PostgreSQL portu
#EXPOSE 5432


# Use the official MongoDB image as the base
FROM mongo:latest

# Set environment variables for MongoDB (modify as needed)
ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=root

# Expose MongoDB's default port
EXPOSE 27017