package accenture.project.repository;

import org.springframework.data.domain.Sort;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import accenture.project.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findAll(Sort sort);
	List<User> findByFirstName(String firstName);
}