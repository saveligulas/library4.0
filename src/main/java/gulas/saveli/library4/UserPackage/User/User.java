package gulas.saveli.library4.UserPackage.User;

import com.example.libraryEntitiesAndDbManager.LibraryContentsPackage.Book.Book;
import com.example.libraryEntitiesAndDbManager.UserPackage.Role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(targetEntity = Book.class, mappedBy = "user",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> books;
}
