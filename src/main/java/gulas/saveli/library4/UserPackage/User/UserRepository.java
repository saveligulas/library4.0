package gulas.saveli.library4.UserPackage.User;

import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.username = ?1", nativeQuery = true)
    Optional<User> getUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> getUserByEmail(String email);

    @Query(value = "SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName AND u.dob BETWEEN :startDate AND :endDate", nativeQuery = true)
    Optional<User> getUserByNameAndDob(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    User findByEmail(String email);
}
