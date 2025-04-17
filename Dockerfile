FROM bellsoft/liberica-openjdk-alpine:latest-cds

# Install curl jq
RUN apk add curl jq

# Workspace
WORKDIR /home/selenium-docker

# Add the required files to run the test
ADD target/docker-resources     .
ADD runner.sh                   runner.sh

# Starting the runner
ENTRYPOINT ["sh", "-c", "sh runner.sh"]
# ENTRYPOINT ["sh", "-c", "java -cp 'libs/*' -Dselenium.grid.enabled=true -Dselenium.grid.hubHost=${HUB_HOST} -Dbrowser=${BROWSER} org.testng.TestNG -threadcount ${THREAD_COUNT} test-suites/${TEST_SUITE}"]
