# X-Meme (Spring Boot Backend Project)

## About Author 
* Name - Subham Kumar Das

* Check out Author's [Github Repository](https://github.com/loneWolf148)

## About Project
* This project is developed using Spring Boot in Spring Tool Suite ([STS](https://spring.io/tools)) IDE.

* Database used for project - [PostgreSQL](https://www.postgresql.org/)
* ORM Tool Used - Hibernate with JPA
* Web API publicly hosted on [Heroku](https://crio-xmeme-boot.herokuapp.com/)
* Angular frontend code is hosted on [Github Repository](https://github.com/loneWolf148/X-Meme-FrontEnd.git)
* The frontend website is hosted in [Netlify](https://crio-x-meme.netlify.app/)

## [API Controllers](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/controller)

1. [HomeController](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/controller/HomeController.java)
    * Controller associated with rendering home page of Web API.

2. [MemeController](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/controller/MemeController.java)

    * REST Controller associated with API end points, related to Memes which    include fetching memes, uploading memes, updating meme payload. 
3. [ReviewController](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/controller/ReviewController.java)

    * REST Controller associated with API end points, related to reviews which    include uploading reviews, fetching reviews, etc. 

* Documentation of API is hosted in [Heroku](https://crio-xmeme-boot.herokuapp.com/)

## [Entities](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/entity)

1. [Meme](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/entity/Meme.java)

    * Entity which encapsulates Meme structure in database (ORM)
2. [Review](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/entity/Review.java)

    * Entity which encapsulates Review structure in database (ORM)

## [Exceptions](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/exception)

* [MemeException](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/exception/MemeException.java)
    * Custom API Exception 
* [MemeExceptionHandler](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/exception/MemeExceptionHandler.java)
    * REST API Exception Handler which catches MemeException and returns ResponseEntity accordingly

## Other Modules 

* [Configuration](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/config) 

    * Contains custom API configuration to be rendered by Swagger Documentation

* [Services](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/service)
    * [MemeService](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/service/MemeService.java) - Services related to memes. 
    * [ReviewService](https://github.com/loneWolf148/X-Meme-Backend/tree/master/src/main/java/com/lonewolf/memeStream/service/ReviewService.java) - Services realated Reviews