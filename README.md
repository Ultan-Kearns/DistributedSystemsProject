# DistributedSystemsProject by Ultan Kearns G00343745

Year 4 project using GRPC

## Link To Github
+ https://github.com/Ultan-Kearns/DistributedSystemsProject
## How to run
+ Start up server file to get server running on port 50551
+ run command java -jar DistributedSystemsPart1.jar on terminal or command line
+ The application should prompt user to enter user ID and password
+ After user ID and password are entered the jar should make a request to the server and will show the UID and hashed password
+ It will also show if the password has been validated by returning a boolean
+ ### IMPORTANT MAY HAVE TO USE MAVEN COMPILE ON POM TO BUILD RESOURCES FOLDER
## How it works
+ Client makes request to server and awaits response
+ Server adds PasswordServiceImpl which makes calls to the Passwords class and server returns the response(String for hash, Boolean for validate) to the client
