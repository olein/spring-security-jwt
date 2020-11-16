# spring-security-jwt

Steps to follow:

1. run the script in db folder to create necessary tables.
2. uncomment the DataInitializer class inside security folder
3. change database configurations if needed
4. run project

APIs:

* http://localhost:8080/spring-security-jwt/auth/signin (POST)

{
	"username":"admin",
	"password":"password"
}


* http://localhost:8080/spring-security-jwt/api/getData (POST)

header: Authorization : Bearer {{access_token}} 

* http://localhost:8080/spring-security-jwt/api/setData (POST)

header: Authorization : Bearer {{access_token}} 

* http://localhost:8080/spring-security-jwt/api/me (GET)

header: Authorization : Bearer {{access_token}}
