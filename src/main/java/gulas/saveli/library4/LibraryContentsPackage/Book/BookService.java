package gulas.saveli.library4.LibraryContentsPackage.Book;

import com.example.libraryEntitiesAndDbManager.Interfaces.LibraryService;

import java.util.Collection;
import java.util.Optional;

public class BookService implements LibraryService<Book> {
    @Override
    public Collection<Book> getAll() {
        return null;
    }

    @Override
    public Optional<Book> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public String saveOrUpdate(Book o) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }
}
