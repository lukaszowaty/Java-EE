package pl.javastart.dao;

public abstract class DAOFactory {
	public static final int MYSQL_DAO = 1;
    
    public abstract BookDAO getBookDAO();
    public abstract UserDAO getUserDAO();
     
    private static DAOFactory instance;
     
    public static DAOFactory getDAOFactory(int factoryType) {
        if(instance == null) {
            if(factoryType == MYSQL_DAO) {
                instance = new MysqlDAOFactory();
            }
//          else if(factoryType == GRAPH_DAO) {
//              return new GraphDAOFactory();
//          }
        }
        return instance;
    }
     
}
