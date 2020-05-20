package royalstacks.app.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import royalstacks.app.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
