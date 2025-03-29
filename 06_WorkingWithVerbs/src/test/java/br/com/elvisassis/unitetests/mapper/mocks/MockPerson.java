package br.com.elvisassis.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.elvisassis.data.dto.v1.PersonDTO;
import br.com.elvisassis.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO personDto = new PersonDTO();
        personDto.setAddress("Address Test" + number);
        personDto.setFirstName("First Name Test" + number);
        personDto.setGender(((number % 2)==0) ? "Male" : "Female");
        personDto.setId(number.longValue());
        personDto.setLastName("Last Name Test" + number);
        return personDto;
    }

}