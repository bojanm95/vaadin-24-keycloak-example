# vaadin-24-keycloak-example

Demo of Vaadin 24 and Keycloak integration

## Getting started

To get your keycloak instance up and running with "sample" realm just run `docker compose up`.
Check out compose.yml for more info about containers you are about to run.
Environment variables are in .env file.

To check out how to configure Keycloak for your own app reffer to Keycloak docs on https://www.keycloak.org/documentation.

vaadin-keycloak-sample is example app if you want to check out how I configured OIDC authentication on my Vaadin app with keycloak.
Take a closer look at pom.xml, package src\main\java\org\bojan\sample\security and application.yml.

This setup is for dev purposes only, DO NOT use this setup in production.
