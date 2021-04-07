FROM node:12-alpine as builder
WORKDIR /app
COPY package.json package-lock.json /app/
RUN npm install 
COPY . /app
RUN npm run start