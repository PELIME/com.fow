package test7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xcx
 * @Date: 2019/1/12 22:42
 * @Version 1.0
 */
public class BookDaoImpl implements BookDao {
    private Connection con;
    private final static String ADD_SQL="INSERT INTO tb_book (no,name,price,author,press) values (?,?,?,?,?)";
    private final static String UPDATA_SQL="UPDATE tb_book SET name=?,price=?,author=?,press=? WHERE no=?";
    private final static String DELETE_SQL="DELETE FROM tb_book WHERE no=?";
    private final static String QUERY_SQL="SELECT * FORM tb_book";
    public BookDaoImpl()
    {
        con=jdbcUtil.getConnection();
    }

    @Override
    public boolean addBook(Book book) {
        try {
            PreparedStatement statement = con.prepareStatement(ADD_SQL);
            statement.setString(1,book.getNo());
            statement.setString(2,book.getName());
            statement.setBigDecimal(3,book.getPrice());
            statement.setString(4,book.getAuthor());
            statement.setString(5,book.getPress());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int updateBook(Book book) {
        try {
            PreparedStatement statement = con.prepareStatement(UPDATA_SQL);
            statement.setString(1,book.getName());
            statement.setBigDecimal(2,book.getPrice());
            statement.setString(3,book.getAuthor());
            statement.setString(4,book.getPress());
            statement.setString(5,book.getNo());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean deleteBook(String no) {
        try {
            PreparedStatement statement = con.prepareStatement(DELETE_SQL);
            statement.setString(1,no);
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> selectAllBook() {
        try {
            Statement statement = con.createStatement();
            List<Book> books=new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(QUERY_SQL);
            while (resultSet.next())
            {
                Book tmp=new Book();
                tmp.setNo(resultSet.getString("no"));
                tmp.setName(resultSet.getString("name"));
                tmp.setPrice(resultSet.getBigDecimal("price"));
                tmp.setAuthor(resultSet.getString("author"));
                tmp.setPress(resultSet.getString("press"));
                books.add(tmp);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
