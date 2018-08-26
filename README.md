# playground-keycloak
Playing with OIDC and JWT using Keycloak and JEE8

## To compile, package and run
```
mvn clean package
mvn payara-micro:start
```

## Open the application
```
http://localhost:8080/keycloak-1.0-SNAPSHOT/index.html      <== The menu page
http://localhost:8080/keycloak-1.0-SNAPSHOT/swagger.html    <== Interactive Swagger UI 
```

## Available URL's
```
http://localhost:8080/keycloak-1.0-SNAPSHOT/frontend
http://localhost:8080/keycloak-1.0-SNAPSHOT/backend
http://localhost:8080/keycloak-1.0-SNAPSHOT/restapi
http://localhost:8080/keycloak-1.0-SNAPSHOT/serverside

http://localhost:8080/keycloak-1.0-SNAPSHOT/swagger.html
```

## Things to test ...
Test out to "two legged authentication", using client service account instead of users accounts between api's.
- [x] Add Swagger UI
- [x] Add OpenAPI security to backend-layer
- [ ] Add OpenAPI security to api-layer 
- [ ] Enable service account for backend client
- [ ] Add some roles to backend client
- [ ] Enforce service account roles in api layer

## How to manually get tokens and call services
```

To use these URL's you need the following information

$KEYCLOAK_URL = Your keycloak base url (https://xxxx)
$REALM = The name of your realm
$CLIENT_ID = The client ID you have defined in keycloak (access_type=confidential, direct access grants enabled=true)
$CLIENT_SECRET = You'll find the secret unded the credentials tab of your client in key cloak
$USERNAME = One of the realm users username
$PASSWORD = One of the realm users password

# Manually get a token directly :
curl --data "grant_type=password&client_id=$CLIENT_ID&client_secret=$CLIENT_SECRET&username=$USERNAME&password=$PASSWORD" \
$KEYCLOAK_URL/auth/realms/$REALM/protocol/openid-csonnect/token

# Pass on the received token to the WEB BACKEND :
curl -i \
-H "Authorization: Bearer $YOUR_TOKEN" \
http://localhost:8080/keycloak-1.0-SNAPSHOT/backend

# Pass on the received token to the RESTAPI :
curl -i \
-H "Authorization: Bearer $YOUR_TOKEN" \
http://localhost:8080/keycloak-1.0-SNAPSHOT/restapi

```

