# Use an official Java image as the base image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /app

# Copy the compiled application jar to the container
COPY target/product-catalog-service-1.0.0-SNAPSHOT.jar /app/app.jar

# Set the environment variables for the JVM
ENV JAVA_OPTS="-Xmx512m -Xms512m"

# Expose the port that the application will run on
EXPOSE 8080

# Run the application
CMD java $JAVA_OPTS -jar app.jar