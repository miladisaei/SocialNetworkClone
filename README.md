
# Social Network Clone

<img src="https://raw.githubusercontent.com/miladisaei/SocialNetworkClone/master/screenshots/screenshot1.JPG" data-canonical-src="https://gyazo.com/eb5c5741b6a9a16c692170a41a49c858.png" width="200" height="400" /> | <img src="https://raw.githubusercontent.com/miladisaei/SocialNetworkClone/master/screenshots/screenshot2.JPG" data-canonical-src="https://gyazo.com/eb5c5741b6a9a16c692170a41a49c858.png" width="200" height="400" /> | <img src="https://raw.githubusercontent.com/miladisaei/SocialNetworkClone/master/screenshots/screenshot3.JPG" data-canonical-src="https://gyazo.com/eb5c5741b6a9a16c692170a41a49c858.png" width="200" height="400" />  

In this project, we display a number of posts (in the form of a photo and a text as its caption) along with the number of likes and comments on one page, and the details of the comments can be seen on another page or add a comment. The description of the project is as follows:
1. A fragment as the main page that displays a number of posts along with the number of likes and comments. Also, the user can like the post on this page.
2. By clicking on each of these posts, the user enters the details page of that post, where he can see the complete comments and also like the post or add his own comment to it.
3. The user first sees 10 posts on the first page, and if he scrolls to the end of the page, another 10 posts will be loaded, and this process will be repeated until all the posts are displayed.
4. Initially, 10 comments will be displayed, and each time you click on "Show more", another number of comments will be displayed.

The apk version of the application is available through [this link](https://1drv.ms/u/s!AradwCVm9utTi1kWLmUfbmWajtV1?e=AeQaLE)


# Technologies

Below is a list of features I used:

1.  **Kotlin:** a versatile, statically-typed programming language with advanced features such as null safety, extension functions, and coroutines.

2. **MVVM + CLEAN Architecture:** a clean and scalable approach to software development.

3. **View Binding:** generates a binding class for XML layouts, providing type-safe access to views.

4. **Navigation Component (Single activity, Multiple fragments):** designed for apps that have one main activity with multiple fragment destinations.

5. **Kotlin Coroutines + Flow:** a combination of asynchronous programming tools that simplify concurrency and reactive programming in Kotlin.

6. **Room:** an SQLite object-mapping library that provides an easy way to store, manage, and query data in Android applications.

7. **Hilt Dependency Injection:** a DI library for Android that simplifies dependency injection.

8. **Unit Testing:** a software testing method that verifies the functionality of individual code units or components in isolation.


# Architectures
![MVVM Clean Architecture](https://i.ibb.co/RzSR4nv/MVVM-Clean-Architecture.png)


MVVM with Clean Architecture is a software design pattern that separates concerns into layers, simplifies maintenance, and improves testability and scalability of applications. The MVVM pattern facilitates the separation of presentation logic from business logic, while Clean Architecture promotes loose coupling and separation of concerns between different layers of the application.

principles:
-   Separation of concerns: The application is separated into different layers, each responsible for a specific set of concerns.
-   Testability: The application is designed to be easily testable, with a focus on unit tests.
-   Scalability: The application is designed to be scalable, with the ability to add new features or modify existing ones without affecting other parts of the application.
-   Reusability: The application is designed to be modular, with reusable components that can be used in different parts of the application or in different applications altogether.
-   Maintainability: The application is designed to be easily maintainable, with a clear separation of concerns and a modular design that allows for easy updates and bug fixes.