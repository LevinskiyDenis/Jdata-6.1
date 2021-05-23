package com.example.jdata6_1.repository;

import com.example.jdata6_1.entity.Person;
import com.example.jdata6_1.entity.PersonId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonRepository extends JpaRepository<Person, PersonId> {

    List<Person> findAllByCityEquals(String city);

    List<Person> findAllByAgeIsLessThan(int age, Sort sort);

    Optional<Person> findByNameEqualsAndSurnameEquals(String name, String surname);
}
