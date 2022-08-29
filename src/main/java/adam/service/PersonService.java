package adam.service;

import adam.model.Person;
import adam.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService implements IPerson {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository pRepo) {
        personRepository = pRepo;
    }

    @Override
    public Set<Person> findall() {
        Set<Person> set = new HashSet<>();
        personRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Person save(Person object) {
        return personRepository.save(object);
    }

    @Override
    public void delete(Person object) {
        personRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
      personRepository.deleteById(aLong);
    }

    @Override
    public Optional<Person> findbyId(Long aLong) {
        return personRepository.findById(aLong);
    }
}
