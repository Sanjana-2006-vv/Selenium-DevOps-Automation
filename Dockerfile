
FROM maven:3.9.9-eclipse-temurin-17

# Install Chromium browser and its matching driver
RUN apt-get update && \
    apt-get install -y --no-install-recommends chromium chromium-driver && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Download Maven dependencies
RUN mvn -B dependency:go-offline

# Copy Selenium source code
COPY src ./src

# Enable Docker browser configuration
ENV DOCKER=true

# Run Selenium test cases
CMD ["mvn", "-B", "clean", "test"]
