package accenture.project.show;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@RestController
@RequestMapping("/show/search")
public class SearchController {
	@Autowired
	private UserRepository userRepository;	
//	@GetMapping("/")
//	public List<User> showAll() {
//		List<User> full_list = userRepository.findAll();
//		List<User> searchResults =new ArrayList<>();
//		for (User user : full_list) {
//            if(user.getFirstName().equals("alphaspear"))
//            	searchResults.add(user);
//        }
//		return searchResults;
//		
//	}

	@GetMapping("/fname")
	public List<User> showAllByFname(@RequestParam("search") String searchString) {
	    List<User> fullList = userRepository.findAll();
	    List<User> searchResults = new ArrayList<>();
	    for (User user : fullList) {
	        if (user.getFirstName().equals(searchString)) {
	            searchResults.add(user);
	        }
	    }
	    return searchResults;
	}
	
	@GetMapping("/lname")
	public List<User> showAllByLname(@RequestParam("search") String searchString) {
	    List<User> fullList = userRepository.findAll();
	    List<User> searchResults = new ArrayList<>();
	    for (User user : fullList) {
	        if (user.getLastName().equals(searchString)) {
	            searchResults.add(user);
	        }
	    }
	    return searchResults;
	}
	
	@GetMapping("/pincode")
	public List<User> showAllByPinCode(@RequestParam("search") String searchpin) {
	    List<User> fullList = userRepository.findAll();
	    List<User> searchResults = new ArrayList<>();
	    for (User user : fullList) {
	        if (user.getPincode()==Integer.parseInt(searchpin)) {
	            searchResults.add(user);
	        }
	    }
	    return searchResults;
	}
}


