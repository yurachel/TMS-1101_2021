package tasks.lesson_17.by.yurachel.task_1.service;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tasks.lesson_17.by.yurachel.task_1.entity.books.Author;
import tasks.lesson_17.by.yurachel.task_1.entity.books.Book;
import tasks.lesson_17.by.yurachel.task_1.entity.books.Genre;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {


    // Читаем книги из XML файла и записываем их в список.

    public List<Book> writeBooksFromXML() {
        List<Book> bookList = new ArrayList<>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse("resources/lesson_17/task_1/Library.xml");
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();

            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);

                if (book.getNodeName().equalsIgnoreCase("Book")) {

                    Book book1 = new Book();
                    NodeList bookChildNodes = book.getChildNodes();

                    for (int j = 0; j < bookChildNodes.getLength(); j++) {
                        Node bookNode = bookChildNodes.item(j);

                        if (bookNode.getNodeName().equalsIgnoreCase("bookName")) {
                            book1.setBookName(bookNode.getTextContent());
                        }
                        if (bookNode.getNodeName().equalsIgnoreCase("Author")) {
                            List<Author> authorsList = new ArrayList<>();
                            NodeList authors = bookNode.getChildNodes();
                            for (int k = 0; k < authors.getLength(); k++) {
                                Node authorString = authors.item(k);
                                if (authorString.getNodeType() != Node.TEXT_NODE) {
                                    Author author = new Author(authorString.getTextContent());
                                    authorsList.add(author);
                                }
                            }
                            book1.setAuthors(authorsList);
                        }
                        if (bookNode.getNodeName().equalsIgnoreCase("Genre")) {
                            String gen = bookNode.getTextContent();
                            for (Genre genre : Genre.values()) {
                                if (genre.name().equalsIgnoreCase(gen)) {
                                    book1.setGenre(genre);
                                }
                            }
                        }
                        if (bookNode.getNodeName().equalsIgnoreCase("Price")) {
                            book1.setPrice(Integer.parseInt(bookNode.getTextContent()));
                        }

                        if (bookNode.getNodeName().equalsIgnoreCase("numberOfPages")) {
                            book1.setNumberOfPages(Integer.parseInt(bookNode.getTextContent()));
                        }
                        if (bookNode.getNodeName().equalsIgnoreCase("forTakingHome")) {
                            book1.setForTakingHome(Boolean.parseBoolean(bookNode.getTextContent()));
                        }
                    }
                    bookList.add(book1);
                }

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return bookList;
    }
}

