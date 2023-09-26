# SearchEngine
The Simple `Search Engine` project provides a basic web search functionality along with a history tracking feature. Users can:

- Perform keyword searches on a database of web pages.
- View search results, including titles and links.
- Access their search history.

## Technologies Used

- `Java`
- `JSP` (JavaServer Pages)
- `MySQL`
- `CSS`
- `Maven`
- `Servlet API`
- `JDBC`

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Develpment Kit (JDK).
- Apache Tomcat server.
- Maven build tool.
- MySQL databse.
- IDE (Eclipse, IntelliJ, etc.).

## Project Components

The project consists of several components:

1. `**index.jsp**` : The homepage with a search input field and a "History" button.
2. `**search.jsp**` : Displays search results and connects to the database.
3. `**history.jsp**` : Displays the search history retrieved from the database.
4. `**style.css**` : Provides styling for the web pages.
5. `**search.java**` : Java servlet for handling user searches.
6. `**history.java**` : Java servlet for managing search history.
7. `**SearchResult.java**` : Java class representing search results.
8. `**HistoryResult.java**` : Java class representing search history entries.
9. `**DatabaseConnection.java**` : Java class for establishing a MySQL database connection.
10. `**pom.xml**` : Maven configuration file.

## Setup

1. Clone the repository: https://github.com/Mausam1815/SearchEngine.git
2. Create `MySQL` database.
3. Update the database connection detaisl in the `DatabaseConnection.java` file.
4. Open the project in your preffered `IDE`.
5. Build the project using `Maven`.
6. Deploy the project on your `Apache Tomcat server`.

## Usage
1. Access the search engine web application at `http://localhost:8080/SearchEngine`.
2. Enter a keyword in the search bar and click the `Search` button.
3. View the search results.
4. Click on the links to visit the corresponding web pages.
5. Access the search history, click on `History` button.

## Features
- Keyword-based search functionality.
- Database for storing web page content and search history.
- Web crawler for indexing web pages.
- View search history.
- Responsive web design.

## Contributing
Contirbutions are welcome! If you have any suggestions or would like to contribute to this project, please open an issue or create a pull request.

## Here are some ScreenShots..
![Screenshot 2023-09-20 151655](https://github.com/Mausam1815/SearchEngine/assets/128462297/96a72cd4-ab2b-488a-8bad-19024c3c4102)

![Screenshot 2023-09-20 151715](https://github.com/Mausam1815/SearchEngine/assets/128462297/f7338a22-c782-4387-97ef-7025f9c8fac6)

![Screenshot 2023-09-20 151744](https://github.com/Mausam1815/SearchEngine/assets/128462297/884ed014-ee09-442b-9aea-4c23181e87b4)

![Screenshot 2023-09-20 151758](https://github.com/Mausam1815/SearchEngine/assets/128462297/cb634f87-545a-46f4-977d-3dcef0c632c7)
