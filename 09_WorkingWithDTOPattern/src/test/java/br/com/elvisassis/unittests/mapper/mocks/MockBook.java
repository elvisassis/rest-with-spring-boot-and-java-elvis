package br.com.elvisassis.unittests.mapper.mocks;

import br.com.elvisassis.controllers.BookController;
import br.com.elvisassis.data.dto.BookDTO;
import br.com.elvisassis.model.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(number.doubleValue());
        book.setId(number.longValue());
        book.setTitle("Some Title" + number);
        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor("Some Author" + number);
        bookDTO.setLaunchDate(new Date());
        bookDTO.setPrice(number.doubleValue());
        bookDTO.setId(number.longValue());
        bookDTO.setTitle("Some Title" + number);
        addHateoasLinks(bookDTO);
        return bookDTO;
    }

    private void addHateoasLinks(BookDTO bookDTO) {
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel().withType("GET"));
        bookDTO.add(linkTo(methodOn(BookController.class).findAll(1, 10, "asc")).withRel("findAll").withType("GET"));
        bookDTO.add(linkTo(methodOn(BookController.class).create(bookDTO)).withRel("create").withType("POST"));
        bookDTO.add(linkTo(methodOn(BookController.class).update(bookDTO)).withRel("update").withType("PUT"));
        bookDTO.add(linkTo(methodOn(BookController.class).delete(bookDTO.getId())).withRel("delete").withType("DELETE"));
    }

}