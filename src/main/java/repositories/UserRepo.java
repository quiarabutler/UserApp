package repositories;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // repos are always interfaces
public interface UserRepo extends JpaRepository<User, Long>  { // extends jpaRepo it provides built-in CRUD operations


}
