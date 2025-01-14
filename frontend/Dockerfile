FROM node:20-alpine AS builder

ARG VITE_API_HOST
ENV VITE_API_HOST=$VITE_API_HOST
WORKDIR /app
COPY package*.json .
RUN npm ci
ENV NODE_ENV=production
COPY . .
RUN npm run build

FROM nginx:1.27.3-alpine

LABEL org.opencontainers.image.title="simple-workout-react"
LABEL org.opencontainers.image.authors="Danylo Zakharchenko"
LABEL org.opencontainers.image.source="https://github.com/zakh-d/spring-labs/"
LABEL org.opencontainers.image.url="https://github.com/zakh-d/spring-labs/"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"
LABEL org.opencontainers.image.description="Simple Workout application frontend"
LABEL org.opencontainers.image.licenses="MIT"

COPY ./docker/etc/nginx/templates  /etc/nginx/templates/
COPY --from=builder /app/dist/ /usr/share/nginx/html/
EXPOSE 80