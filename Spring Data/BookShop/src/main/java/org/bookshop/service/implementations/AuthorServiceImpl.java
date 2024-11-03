package org.bookshop.service.implementations;

import org.bookshop.data.entities.Author;
import org.bookshop.data.repositories.AuthorRepository;
import org.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_PATH = "C:\\Users\\Ali\\IdeaProjects\\BookShop\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_PATH))
                .stream()
                .filter(line -> !line.isEmpty())
                .forEach(line -> {
                    String[] split = line.split("\\s+");
                    Author author = new Author(split[0], split[1]);
                    authorRepository.saveAndFlush(author);
                });
        System.out.printf("Count of imported authors - %d\n ", this.authorRepository.count());
    }

    @Override
    public boolean areAuthorsImported() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void printBookBefore1990() {

        this.authorRepository.findAll()
                .stream()
                .filter(author -> author.getBooks()
                        .stream()
                        .anyMatch(b -> b.getReleaseDate().isBefore(LocalDate.of(1990,1,1))))
                .forEach(author -> System.out.printf("%s %s - %d\n", author.getFirstName(),
                        author.getLastName(), author.getBooks().size()));


    }

    @Override
    public void printAllAuthorsWithDescCount() {
        this.authorRepository.findAll()
                .stream()
                .sorted((a,b) -> b.getBooks().size() > a.getBooks().size() ? 1 : -1)
                .forEach(author -> System.out.printf("%s %s - %d\n", author.getFirstName(),
                        author.getLastName(), author.getBooks().size()));
    }
}
