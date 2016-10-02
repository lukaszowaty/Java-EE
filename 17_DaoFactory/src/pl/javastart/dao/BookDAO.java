package pl.javastart.dao;

import pl.javastart.model.Book;

public interface BookDAO {
    public boolean create(Book book);
    public Book read(String isbn);
    public boolean update(Book book);
    public boolean delete(Book book);
}