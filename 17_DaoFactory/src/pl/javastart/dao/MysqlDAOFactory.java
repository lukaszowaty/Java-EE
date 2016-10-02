package pl.javastart.dao;

public class MysqlDAOFactory extends DAOFactory {
	 
    @Override
    public BookDAO getBookDAO() {
        return new MysqlBookDAO();
    }
 
    @Override
    public UserDAO getUserDAO() {
        return new MysqlUserDAO();
    }
 
}