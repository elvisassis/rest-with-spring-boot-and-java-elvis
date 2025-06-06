package br.com.elvisassis.data.dto;

import br.com.elvisassis.mapper.BookMapper;
import br.com.elvisassis.model.Book;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.util.Date;


@Data
@Relation(collectionRelation = "books")
public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    public Book toEntity(){
        return BookMapper.INSTANCE.bookDTOToBook(this);
    }
}
