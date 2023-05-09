package accenture.project.repository;

import org.springframework.data.domain.Sort;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import accenture.project.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findAll(Sort sort);
	List<User> findByFirstName(String firstName);
	
	@Query(value = "SELECT * FROM Accenture.users where deletion_flag=false", nativeQuery = true)
	List<User> findAll();
	
	@Query(value = "SELECT * FROM Accenture.users where deletion_flag=1", nativeQuery = true)
	List<User> showAllInTrash();
	
}