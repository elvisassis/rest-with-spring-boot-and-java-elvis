package br.com.elvisassis.mapper;

import br.com.elvisassis.data.dto.PersonDTO;
import br.com.elvisassis.model.Book;
import br.com.elvisassis.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T16:21:32-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setAddress( person.getAddress() );
        personDTO.setGender( person.getGender() );
        personDTO.setEnabled( person.getEnabled() );
        personDTO.setProfileUrl( person.getProfileUrl() );
        personDTO.setPhotoUrl( person.getPhotoUrl() );
        List<Book> list = person.getBooks();
        if ( list != null ) {
            personDTO.setBooks( new ArrayList<Book>( list ) );
        }

        return personDTO;
    }

    @Override
    public Person personDtoToPerson(PersonDTO personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDto.getId() );
        person.setFirstName( personDto.getFirstName() );
        person.setLastName( personDto.getLastName() );
        person.setAddress( personDto.getAddress() );
        person.setGender( personDto.getGender() );
        person.setEnabled( personDto.getEnabled() );
        person.setProfileUrl( personDto.getProfileUrl() );
        person.setPhotoUrl( personDto.getPhotoUrl() );
        List<Book> list = personDto.getBooks();
        if ( list != null ) {
            person.setBooks( new ArrayList<Book>( list ) );
        }

        return person;
    }
}
