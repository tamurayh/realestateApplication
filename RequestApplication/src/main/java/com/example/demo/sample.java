package com.example.demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sample {
	
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://qiita.com/search")
                                 .data("q", "java")
                                 .get();

        Elements elements = document.select(".brand, .page-title, .stats");

        for (Element element : elements) {
            System.out.println(element.text());
        }
        
    }

}
