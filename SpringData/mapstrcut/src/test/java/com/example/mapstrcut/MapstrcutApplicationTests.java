package com.example.mapstrcut;

import com.example.mapstrcut.domain.Person;
import com.example.mapstrcut.domain.User;
import com.example.mapstrcut.dto.PersonDTO;
import com.example.mapstrcut.mapper.PersonConverter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class MapstrcutApplicationTests {

    @Autowired
    private PersonConverter converter;

    @Test
    void testToDto() {
        Person person = new Person(1L, "zhige", "zhige.me@gmail.com", new Date(),true,
                new User(1));
        PersonDTO personDTO = converter.toDto(person);
        System.err.println(personDTO.toString());
    }


    @Test
    void testToEntity() {
        PersonDTO dto = new PersonDTO(1L, "yangjian", 23, "ss", new Date(), "Y","2019-10-10 12:12:12",
                "2019-10-10 12:12:12");
        Person person = converter.toEntity(dto);
        System.err.println(person.toString());
    }

}
