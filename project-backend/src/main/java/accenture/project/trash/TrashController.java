package accenture.project.trash;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@RestController
@RequestMapping("/trash")
public class TrashController {
	
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping("/{id}")
	public void trashOne(@PathVariable int id) {
		User t0 = userRepository.findById(id).get();
		t0.setDeletionFlag(true);
		userRepository.save(t0);
	}
	
	
	@GetMapping("/show")
	public List<User> showTrash() {
		return userRepository.showAllInTrash();
	}
	
	
	@GetMapping("/restore/{id}")
	public void restoreOne(@PathVariable int id) {
		User t0 = userRepository.findById(id).get();
		t0.setDeletionFlag(false);
		userRepository.save(t0);
	}
	
	
	
}