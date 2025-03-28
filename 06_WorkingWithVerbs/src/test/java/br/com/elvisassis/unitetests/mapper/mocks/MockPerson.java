package br.com.elvisassis.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.elvisassis.data.dto.PersonDto;
import br.com.elvisassis.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDto mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDto> mockDTOList() {
        List<PersonDto> persons = new ArrayList<>();
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

    public PersonDto mockDTO(Integer number) {
        PersonDto personDto = new PersonDto();
        personDto.setAddress("Address Test" + number);
        personDto.setFirstName("First Name Test" + number);
        personDto.setGender(((number % 2)==0) ? "Male" : "Female");
        personDto.setId(number.longValue());
        personDto.setLastName("Last Name Test" + number);
        return personDto;
    }

}