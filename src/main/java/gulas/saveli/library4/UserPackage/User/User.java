package gulas.saveli.library4.UserPackage.User;

import gulas.saveli.library4.LibraryContentsPackage.Book.Book;
import gulas.saveli.library4.UserPackage.Role.Role;
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
    private String name;
    private String userName;
    private String password;
    private String email;
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(targetEntity = Book.class, mappedBy = "user",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> books;

    public User(String firstName, String lastName, String email, String password, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.userName = firstName.substring(0,1).toLowerCase() + String.valueOf(dob.getYear()) + lastName.substring(0, 1).toLowerCase();
    }
}
