package br.com.elvisassis.mapper;

import br.com.elvisassis.data.dto.BookDTO;
import br.com.elvisassis.model.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T16:21:32-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setAuthor( bookDTO.getAuthor() );
        book.setLaunchDate( bookDTO.getLaunchDate() );
        book.setPrice( bookDTO.getPrice() );
        book.setTitle( bookDTO.getTitle() );

        return book;
    }

    @Override
    public BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setAuthor( book.getAuthor() );
        bookDTO.setLaunchDate( book.getLaunchDate() );
        bookDTO.setPrice( book.getPrice() );
        bookDTO.setTitle( book.getTitle() );

        return bookDTO;
    }
}
