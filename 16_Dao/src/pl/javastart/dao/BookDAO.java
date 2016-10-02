package pl.javastart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.javastart.model.Book;
import pl.javastart.util.ConnectionProvider;

public class BookDAO {
	
	private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(?,?,?);";
	private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = ?;";
	private final static String UPDATE = "UPDATE book SET isbn=?, title=?, description=? WHERE isbn = ?;";
	private final static String DELETE = "DELETE FROM book WHERE isbn=?;";
	
	public boolean create(Book book) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		boolean result = false;
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(CREATE);
			prepStmt.setString(1, book.getIsbn());
			prepStmt.setString(2, book.getTitle());
			prepStmt.setString(3, book.getDescription());
			int rowsAffected = prepStmt.executeUpdate();
			if (rowsAffected >0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, null, conn);
		}
		return result;
	}
	
	public Book read(String isbn) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		Book resultBook = null;
		try {
			conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ);
            prepStmt.setString(1, isbn);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()) {
            	resultBook = new Book();
            	resultBook.setIsbn(resultSet.getString("isbn"));
            	resultBook.setTitle(resultSet.getString("title"));
            	resultBook.setDescription(resultSet.getString("description"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, resultSet, conn);
		}
		return resultBook;
	}
	
	public boolean update(Book book) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		boolean result = false;
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(UPDATE);
			prepStmt.setString(1, book.getIsbn());
			prepStmt.setString(2, book.getTitle());
			prepStmt.setString(3, book.getDescription());
			prepStmt.setString(4, book.getIsbn());
			int rowsAffected = prepStmt.executeUpdate();
			if(rowsAffected > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, null, conn);
		}
		return result;
	}
	
	public boolean delete(Book book) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		boolean result = false;
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(DELETE);
			prepStmt.setString(1, book.getIsbn());
			int rowsAffected = prepStmt.executeUpdate();
			if(rowsAffected > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		} finally {
			releaseResources(prepStmt, null, conn);
		}
		return result;
	}
	
	private void releaseResources(PreparedStatement prepStmt, ResultSet res, Connection conn) {
		try {
			if (prepStmt != null && !prepStmt.isClosed()) {
				prepStmt.close();
			}
			if (res != null && !res.isClosed()) {
				res.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
