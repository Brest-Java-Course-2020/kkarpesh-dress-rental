FROM tomcat:9.0.35-jdk11-openjdk
ENV spring.profiles.active=docker
ADD build/libs/dress-rental-web.war /usr/local/tomcat/webapps/
EXPOSE 8888
CMD ["catalina.sh", "run"]

