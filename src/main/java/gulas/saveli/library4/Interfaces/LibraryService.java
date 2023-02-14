package gulas.saveli.library4.Interfaces;

import java.util.Collection;
import java.util.Optional;

public interface LibraryService<Object> {
    public Collection<Object> getAll();
    public Object getById(Long id);
    public Object save(Object o);
    public String deleteById(Long id);
}
