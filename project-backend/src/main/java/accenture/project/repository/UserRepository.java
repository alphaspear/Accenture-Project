package accenture.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accenture.project.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
