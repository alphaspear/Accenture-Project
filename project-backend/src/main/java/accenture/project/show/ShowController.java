package accenture.project.show;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.project.errors.UserNotFoundException;
import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@RestController
@RequestMapping("/show")
public class ShowController {
	
	@Autowired
	private UserRepository userRepository;	
	@GetMapping("")
	public List<User> showAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User showOne(@PathVariable int id) {
		if(!userRepository.existsById(id))
			throw new UserNotFoundException("USER NOT FOUND");  
		return userRepository.findById(id).get();
		
	}
}
