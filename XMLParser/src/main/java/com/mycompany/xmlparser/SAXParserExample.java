package com.mycompany.xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserExample {

    public static void main(String[] args) {

        try {
            // Create a SAXParserFactory and SAXParser instance
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Define the handler
            DefaultHandler handler = new DefaultHandler() {

                boolean title = false;
                boolean author = false;
                boolean year = false;
                boolean price = false;

                // Start Element Event
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("title")) {
                        title = true;
                    }
                    if (qName.equalsIgnoreCase("author")) {
                        author = true;
                    }
                    if (qName.equalsIgnoreCase("year")) {
                        year = true;
                    }
                    if (qName.equalsIgnoreCase("price")) {
                        price = true;
                    }
                }

                // Characters Event
                public void characters(char ch[], int start, int length) throws SAXException {

                    if (title) {
                        System.out.println("Title: " + new String(ch, start, length));
                        title = false;
                    }

                    if (author) {
                        System.out.println("Author: " + new String(ch, start, length));
                        author = false;
                    }

                    if (year) {
                        System.out.println("Year: " + new String(ch, start, length));
                        year = false;
                    }

                    if (price) {
                        System.out.println("Price: " + new String(ch, start, length));
                        price = false;
                    }
                }
            };

            // Parse the XML document
            saxParser.parse("bookstore.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
