package accenture.project.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@RestController
public class RegisterController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	void registerUser(@RequestBody User u) {
		userRepository.save(u);
	}
}
