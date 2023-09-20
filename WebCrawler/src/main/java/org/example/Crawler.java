package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

public class Crawler {
    HashSet<String> urlSet;
    int maxDepth = 2;
    Crawler() {
        urlSet = new HashSet<>();
    }
//    Method to recursively crawl a web page and collect text and links.
    public void getPageTextAndLink(String url, int depth) {
//        Check if the URL has already been visited or if depth exceeds the maximum depth.
        if(urlSet.contains(url) || depth >= maxDepth) {
            return;
        }
//        Add the URl to the set of the visited URLs.
        if(urlSet.add(url)) {
            System.out.println(url);
        }
        depth++;

        try {
//            Connect to the web page and retrieves its content.
            Document document = Jsoup.connect(url).timeout(5000).get();
//            Creates an Indexer to process and index the web page content.
            Indexer indexer = new Indexer(document, url);
            System.out.println(document.title());

//            Extract all available links on the page.
            Elements availableLinkOnPage = document.select("a[href]");

//            Recursively crawl each linked page.
            for(Element currLink : availableLinkOnPage) {
                getPageTextAndLink(currLink.attr("abs:href"), depth);
            }
        }catch (IOException  | IllegalArgumentException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        Create an instance of the Crawler and start crawling from a specified URL.
        Crawler crawler = new Crawler();
        crawler.getPageTextAndLink("https://www.javatpoint.com/", 0);
    }
}