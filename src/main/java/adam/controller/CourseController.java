package adam.controller;

import adam.model.Course;
import adam.model.Person;
import adam.service.CourseService;
import adam.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class CourseController {

    private CourseService cService;
    private PersonService pService;

    public CourseController(CourseService cService) {
        this.cService = cService;
    }
    public void PersonController(PersonService pService){
        this.pService = pService;
    }

    @GetMapping("/courses")
    public ResponseEntity<Set<Course>> getAllCourse() {
        return new ResponseEntity<>(cService.findall(), HttpStatus.OK);
    }

    @PostMapping("/addcourse")
    public ResponseEntity<Set<Course>> addCourse(Course name) {
        cService.save(name);
        return new ResponseEntity<>(cService.findall(), HttpStatus.OK);
    }

//FÅ TIL AT FUNGERE
    @GetMapping("addtocourse")
    public ResponseEntity<Set<Course>> addToCourse(Long person_id, Long course_id) {
        Optional<Person> person = pService.findbyId(person_id);
        Optional<Course> course = cService.findbyId(course_id);
        if (person.isPresent()){

            return new ResponseEntity<>(cService.findall(), HttpStatus.OK);
        } else return new ResponseEntity<>(cService.findall(), HttpStatus.BAD_REQUEST);
    }
}
