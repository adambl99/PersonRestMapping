package adam.service;

import adam.model.Greeting;
import org.springframework.stereotype.Service;
import adam.repository.GreetingRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class GreetingService implements IGreeting {
    private GreetingRepository repo;

    public GreetingService(GreetingRepository repo){
        this.repo = repo;
        System.out.println();
    }
    @Override
    public Set<Greeting> findall() {
        Set<Greeting> set = new HashSet<>();
        repo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Greeting save(Greeting object) {
        return null;
    }
    @Override
    public void delete(Greeting object) {
    }
    @Override
    public void deleteById(Long aLong) {
    }
    @Override
    public Optional<Greeting> findbyId(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Set<Greeting> findAll() {
        Set<Greeting> set = new HashSet<>();
        repo.findAll().forEach(set::add);
        return set;
    }
}
