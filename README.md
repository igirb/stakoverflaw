# Stackoverflow China Edition

## Project Overview

During our Object-Oriented Programming module's Teamwork week, we embarked on an exciting journey to develop a Stackoverflow replica Spring Boot Web API, inspired by the renowned Stackoverflow platform. Our project, affectionately dubbed "Stackoverflow China Edition," serves as our final team endeavor, showcasing our mastery of Java technologies.

## Project Highlights 🚀

Get ready to immerse yourself in the world of Stackoverflow with our China-inspired clone! Our project empowers users to create and manage questions and answers, just like the original platform. Here's a sneak peek into our technology stack:

- **Backend Magic**: Harnessing the power of Java (Spring Boot 3), we've crafted a robust backend system to handle all your requests and responses with finesse.
- **Data Dynamo**: Behind the scenes, PostgreSQL works tirelessly to efficiently manage our vast database of questions and answers.
- **Frontend Tricks**: Empowered by React Vite, our frontend dazzles with lightning-fast performance and cutting-edge features, offering users an immersive experience like never before.

## Built With
* [![React][React.js]][React-url]
* [![Node][NodeJs]][NodeJs-url]
* [![Postgres][PostgreSQL]][Postgres-url]
* [![SpringBoot][Spring]][SpringBoot-url]
* [![Java][Java]][Java-url]

## Installation Guide 🛠️

Ready to dive in? Follow these simple steps to set up "Stackoverflow China Edition" on your machine:

### 1. Clone the Repository

```bash
git clone <REPO_LINK>
```

### 2. Database Setup

Configure your database connection by setting up environmental variables within the project. Ensure you have the following variables set: `POSTGRES_USER`, `POSTGRES_PASSWORD`, and `POSTGRES_URL`.

Configure the application.properties file with your PostgreSQL database credentials.
![image](https://github.com/blankapsz/stackoverflow/assets/134206215/0ac224a5-e940-4379-b318-8170f0034a71)

Create the PSQL table by running the query from table_creation.sql

### 3. Install dependencies by running:

`npm install`

### 4. Start React:

`cd frontend` -> `cd stackoverflow_frontend` -> `npm run dev`

### 5. Start SpringApplication:

`java -jar StackoverflowTwApplication.jar`

## Features

🟣 Register with fictional information (username and password, not yet encrypted).
🟢 Login to the site.
🔵 Post new questions and answers.
🟠 Manage your questions and answers by deleting them.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

If you found this project useful and would like to get in touch, feel free to contact me on [LinkedIn](https://www.linkedin.com/in/igirb/). Your feedback and suggestions are always welcome!

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[PostgreSQL]:https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[Postgres-url]:https://www.postgresql.org/
[Spring]:https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[SpringBoot-url]:https://spring.io/projects/spring-boot
[NodeJs]:https://img.shields.io/badge/Node.js-43853D?style=for-the-badge&logo=node.js&logoColor=white
[NodeJs-url]:https://nodejs.org/en
[Java]:https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]:https://www.java.com/en/
