package test7;

import java.util.List;

/**
 * @Author: xcx
 * @Date: 2019/1/12 22:35
 * @Version 1.0
 */
public interface BookDao {
    boolean addBook(Book book);
    int updateBook(Book book);
    boolean deleteBook(String no);
    List<Book> selectAllBook();
}
