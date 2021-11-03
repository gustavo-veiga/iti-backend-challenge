FROM bellsoft/liberica-openjdk-alpine-musl:11

COPY build/install/challenge/ .

ENTRYPOINT "bin/challenge"
EXPOSE 8080
