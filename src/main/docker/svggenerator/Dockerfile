FROM anapsix/alpine-java:8_server-jre

ADD ${project.build.finalName}.jar /

CMD ["java", "-jar", "${project.build.finalName}.jar" ]

EXPOSE 8080