package accenture.project.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@RestController
@RequestMapping("/edit")
public class EditController {
	@Autowired
	private UserRepository userRepository;
	
	@PutMapping("/{id}")
	public void updateFullTopic(@PathVariable int id, @RequestBody User t1)
	{
		User t0 = userRepository.findById(id).get();
		
		if(!(t1.getFirstName()==null))
			t0.setFirstName(t1.getFirstName());
		
		if(!(t1.getLastName()==null))
			t0.setLastName(t1.getLastName());
		
		if(!(t1.getAddress()==null))
			t0.setAddress(t1.getAddress());
		
		if(!(t1.getPincode()==0))
			t0.setPincode(t1.getPincode());
		
		if(!(t1.getDateOfBirth()==null))
			t0.setDateOfBirth(t1.getDateOfBirth());
		
		if(!(t1.getDateOfJoining()==null))
			t0.setDateOfJoining(t1.getDateOfJoining());
		
		userRepository.save(t0);
	}
}
