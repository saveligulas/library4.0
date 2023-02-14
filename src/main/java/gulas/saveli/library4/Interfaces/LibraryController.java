package gulas.saveli.library4.Interfaces;

import java.util.Collection;

public interface LibraryController<Object> {
    public Collection<Object> getAll();
    public Object getById(Long id);
    public void registerNewObject(Object object);
    public void deleteById(Long id);
}
