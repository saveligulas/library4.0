package gulas.saveli.library4.LibraryContentsPackage.Book;

import gulas.saveli.library4.Interfaces.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService implements LibraryService<Book> {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Collection<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));
    }

    @Override
    public Book save(Book Book) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }
}
