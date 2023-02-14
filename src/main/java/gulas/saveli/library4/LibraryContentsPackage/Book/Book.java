package gulas.saveli.library4.LibraryContentsPackage.Book;

import com.example.libraryEntitiesAndDbManager.LibraryContentsPackage.Author.Author;
import com.example.libraryEntitiesAndDbManager.LibraryContentsPackage.Genre.Genre;
import com.example.libraryEntitiesAndDbManager.LibraryContentsPackage.Publisher.Publisher;
import com.example.libraryEntitiesAndDbManager.UserPackage.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;
}
