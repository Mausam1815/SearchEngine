# Web Crawler Description

## Overview

The Web Crawler is an essential component of the Simple Search Engine project. Its primary purpose is to explore the web, visit web pages, and collect text and links from those pages. This collected data is then indexed and stored in a MySQL database, making it accessible for users to search within the Simple Search Engine. The Web Crawler is implemented in Java and utilizes the JSoup library for web scraping.

## Components

### 1. **Crawler.java**

The `Crawler` class is responsible for crawling web pages. It uses a recursive approach to traverse web pages and collects their text and links. Here are some key functions:

- It maintains a `HashSet` to keep track of visited URLs to avoid revisiting the same page.
- The `getPageTextAndLink` method takes a URL and a depth parameter to control the crawl depth.
- It connects to a web page using JSoup, retrieves its content, and extracts relevant information.
- It recursively crawls linked pages found on the current page. 
- Crawling depth is limited to prevent excessive crawling.

### 2. **DatabaseConnection.java**

The `DatabaseConnection` class handles the connection to the MySQL database. It provides methods to establish a database connection and retrieve the connection instance. Key functions include:

- It ensures that only one database connection is created and reused.
- Database credentials are stored in this class.
- It loads the MySQL JDBC driver and establishes a connection to the specified database.

### 3. **Indexer.java**

The `Indexer` class is responsible for indexing the content of web pages and storing it in the MySQL database. Key functions include:

- It receives a `Document` object (representing a web page) and its URL.
- It extracts the page's title, URL link, and text content.
- It prepares and executes a SQL statement to insert this data into the 'pages' table in the database.

## How It Works

1. The Web Crawler starts from a specified seed URL (in this case, "https://www.javatpoint.com/") and initiates the crawling process.

2. It recursively visits web pages, collects text and links, and stores them in the database.

3. The `Indexer` class is used to process each visited web page. It extracts the relevant information and inserts it into the 'pages' table in the MySQL database.

4. The indexed data is then accessible for users through the Simple Search Engine, allowing them to perform keyword searches.

## Conclusion

The Web Crawler is a critical component of the Simple Search Engine project, enabling the collection and indexing of web page content for user searches. It demonstrates web scraping techniques, database integration, and recursive crawling methods. With further enhancements, it can be adapted for various web crawling applications.
