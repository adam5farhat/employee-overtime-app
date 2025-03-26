# Use Node.js as the build stage
FROM node:18-alpine as build

# Set working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy the rest of the app and build it
COPY . .
RUN npm run build

# Use Nginx to serve the built files
FROM nginx:alpine

# Copy the React build files to the Nginx HTML folder
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 3000
EXPOSE 3000

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
