package accenture.project.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.project.repository.UserRepository;

@RestController
@RequestMapping("/delete")
public class DeleteController {
	
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable int id) {
		if(userRepository.existsById(id))
			userRepository.deleteById(id);
		return;
	}
	
	@DeleteMapping("/all")
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	
	
}
