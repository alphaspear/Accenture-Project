package accenture.project.show;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@RestController
@RequestMapping("/show/sort")
public class SortController {
	@Autowired
	private UserRepository userRepository;	

	@GetMapping("/dob")
    public List<User> getUsersSortedByDateOfBirth() {
        Sort sort = Sort.by(Direction.DESC, "DateOfBirth");
        return userRepository.findAll(sort);
    }
	
//	@GetMapping("/doj")
//    public List<User> getUsersSortedByDateOfJoining() {
//        Sort sort = Sort.by(Direction.DESC, "DateOfJoining");
//        return userRepository.findAll(sort);
//    }
	
	@GetMapping("/doj")
	public List<User> getUsersSortedByDateOfJoining(@RequestParam(name = "sort", defaultValue = "desc") String sort) {
	    Direction direction = Direction.DESC;
	    if (sort.equalsIgnoreCase("asc")) {
	        direction = Direction.ASC;
	    }
	    Sort sortByDateOfJoining = Sort.by(direction, "DateOfJoining");
	    return userRepository.findAll(sortByDateOfJoining);
	}

}