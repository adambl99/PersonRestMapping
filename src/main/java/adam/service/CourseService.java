package adam.service;

import adam.model.Course;
import adam.model.Person;
import adam.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService implements ICourse{

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    @Override
    public Set<Course> findall() {
        Set<Course> set = new HashSet<>();
        courseRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Override
    public void delete(Course object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Course> findbyId(Long aLong) {
        return courseRepository.findById(aLong);
    }

}
