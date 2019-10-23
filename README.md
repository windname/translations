# Spring-boot with Security and Cocachbase

this application has endpoints to persist translation in JSON format and find the required translation

## start-up couchbase
prerequisits - docker and docker-compose
navigate to docker-compose.yml 
and run command: `docker-compose up -d`
create bucket cms
create index: `CREATE PRIMARY INDEX on cms`