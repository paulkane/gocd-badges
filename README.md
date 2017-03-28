# gocd-badges

## build
`mvn clean  install`

## docker
`mvn clean install -Pdocker`

`docker run -p 8080 --name gocd-badge --env-file src/main/resources/env.list paulkane/gocd-badges:1.0-SNAPSHOT`

### env.list
host=[https://www.your-gocd-host/]
userName=[user.name]
password=[password]

## Usage
http://ip:8080/badge/go-cd-pipeline