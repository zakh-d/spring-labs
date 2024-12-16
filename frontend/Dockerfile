FROM nginx:1.27.3

LABEL org.opencontainers.image.title="simple-workout-react"
LABEL org.opencontainers.image.authors="Danylo Zakharchenko"
LABEL org.opencontainers.image.source="https://github.com/zakh-d/spring-labs/"
LABEL org.opencontainers.image.url="https://github.com/zakh-d/spring-labs/"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple Workout application frontend"
LABEL org.opencontainers.image.licenses="MIT"

EXPOSE 80

COPY ./docker/etc/nginx/templates  /etc/nginx/templates/
COPY ./dist/ /usr/share/nginx/html/