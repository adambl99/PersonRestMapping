package adam.controller;

import adam.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import adam.service.GreetingService;
import java.util.Set;

@RestController // returns JSON instead of entire webpage (using @Controller)
public class GreetingController {
    private GreetingService gService;

    public GreetingController(GreetingService gService) {
        this.gService = gService;
    }

    @GetMapping("/greetings")
    public ResponseEntity<Set<Greeting>> getGreeting(){ // returns data as JSON
        gService.save(new Greeting());
        return new ResponseEntity<>(gService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addGreeting")
    public ResponseEntity<Set<Greeting>> addGreeting(Greeting greeting){ // returns data as JSON
        System.out.println("received addGreeting " + greeting.getGreeting1());
        gService.save(greeting);
        return new ResponseEntity<>(gService.findAll(), HttpStatus.OK);
    }

}