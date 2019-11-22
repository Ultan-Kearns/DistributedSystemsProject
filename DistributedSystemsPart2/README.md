# README for part 2 of Distributed Systems -<br><br> STUDENT NUMBER:G00343745<br> <br>NAME: Ultan Kearns
# Instructions and links below
+ Instructions to run:
 - Start GRPC password server using "java -jar DistributedSystemsPart1" in folder where it is located
 - Start User Account Service using "java -jar target/DistributedSystemsPart2-0.0.1-SNAPSHOT.jar server userApiConfig.yaml"
 in folder where they are located
 - Start post man and run the following:
    - Create new user - use post: "localhost:9000/users/123/test/test/test"
    - Get all users - use get: "localhost:9000/users/"
    - Update user - use put: "localhost:9000/users/123/te/te/te""
    - Get single user - use get: "localhost:9000/users/123"
    - Delete user - use delete: "localhost:9000/users/123"
    - Login user - use get: "localhost:9000/users/123/test"
+ Link to API: https://app.swaggerhub.com/apis/ultankearns/DistributedSystemsPart2/1.00
+ Link to Github: https://github.com/Ultan-Kearns/DistributedSystemsProject/tree/master/DistributedSystemsPart2
## NOTES
+ If UAC is not connected to server HashedPassword will be blank but user will be submitted
