package accenture.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import accenture.project.repository.UserRepository;
import accenture.project.user.User;

@SpringBootTest
class AccentureProjectApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void testRegister() {
		User testUser = new User();
		testUser.setAddress("Vandalur Chennai");
		testUser.setDateOfBirth(LocalDate.parse("2001-03-12"));
		testUser.setDateOfJoining(LocalDate.parse("2011-03-12"));
		testUser.setFirstName("Meenakashi");
		testUser.setLastName("Sundaram");
		testUser.setPincode(144448);
		userRepository.save(testUser);
		int id = testUser.getId();
		assertNotNull(userRepository.findById(id));
	}
	
	@Test
	void testShow() {
		User testUser = new User();
		testUser.setAddress("Chennai");
		testUser.setDateOfBirth(LocalDate.parse("2011-03-12"));
		testUser.setDateOfJoining(LocalDate.parse("2014-03-12"));
		testUser.setFirstName("Himanshu");
		testUser.setLastName("Singh");
		testUser.setPincode(144448);
		userRepository.save(testUser);
		int id = testUser.getId();
		assertNotNull(testUser.equals(userRepository.findById(id).get() ));
	}
	
	@Test
	void testUpdate() {
		User testUser = new User();
		testUser.setAddress("Pune");
		testUser.setDateOfBirth(LocalDate.parse("2016-05-23"));
		testUser.setDateOfJoining(LocalDate.parse("2022-05-15"));
		testUser.setFirstName("Aditya");
		testUser.setLastName("Loul");
		testUser.setPincode(248005);
		userRepository.save(testUser);
		
		int id = testUser.getId();
		
		User UpdatedTestUser = userRepository.findById(id).get();
		UpdatedTestUser.setLastName("Koul");
		userRepository.save(UpdatedTestUser);
		assertNotNull(testUser.equals(userRepository.findById(id).get() ));
	}
	
	@Test
	void testDelete() {
		User testUser = new User();
		testUser.setAddress("Banglore");
		testUser.setDateOfBirth(LocalDate.parse("1999-05-23"));
		testUser.setDateOfJoining(LocalDate.parse("2022-07-24"));
		testUser.setFirstName("Rohit");
		testUser.setLastName("Rawat");
		testUser.setPincode(675733);
		userRepository.save(testUser);
		
		int id = testUser.getId();
		userRepository.deleteById(id);
		
		assertNotNull(!userRepository.existsById(id));
	}
	
	@Test
	void testTrash() {
		
		User testUser = new User();
		testUser.setAddress("Banglore");
		testUser.setDateOfBirth(LocalDate.parse("1999-05-23"));
		testUser.setDateOfJoining(LocalDate.parse("2022-07-24"));
		testUser.setFirstName("Rohit");
		testUser.setLastName("Rawat");
		testUser.setPincode(675733);
		userRepository.save(testUser);
		
		int id = testUser.getId();
		
		User TrashedUser = userRepository.findById(id).get();
		TrashedUser.setDeletionFlag(true);
		userRepository.save(TrashedUser);
		
		assertNotNull(!userRepository.existsById(id));
		
	}

}
