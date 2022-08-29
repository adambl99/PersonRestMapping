package adam.service;

import adam.model.Greeting;

import java.util.Set;

public interface IGreeting extends CrudService<Greeting, Long> {
    Set<Greeting> findAll();
}
