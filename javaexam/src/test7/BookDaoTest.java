package test7;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: xcx
 * @Date: 2019/1/12 23:24
 * @Version 1.0
 */
public class BookDaoTest {
    public static void main(String[] args) {
        Book book=new Book();
        book.setNo("11111111");
        book.setName("高级MYSQL");
        book.setPrice(new BigDecimal(110.00));
        book.setAuthor("认不到");
        book.setPress("不清楚");
        BookDao bookDao=new BookDaoImpl();
        bookDao.addBook(book);
        book.setNo("22222222");
        book.setName("mysql从删库到跑路");
        book.setPrice(new BigDecimal(-20.00));
        bookDao.addBook(book);
        List<Book> books1=bookDao.selectAllBook();
        for(Book b:books1)
        {
            System.out.println(b.getNo()+"\t"+b.getName()+"\t"+b.getPrice()+"\t"+b.getAuthor()+"\t"+b.getPress());
        }
        book.setPrice(new BigDecimal(50));
        bookDao.updateBook(book);
        List<Book> books2=bookDao.selectAllBook();
        for(Book b:books2)
        {
            System.out.println(b.getNo()+"\t"+b.getName()+"\t"+b.getPrice()+"\t"+b.getAuthor()+"\t"+b.getPress());
        }
        bookDao.deleteBook("11111111");
        bookDao.deleteBook("22222222");
        List<Book> books3=bookDao.selectAllBook();
        for(Book b:books3)
        {
            System.out.println(b.getNo()+"\t"+b.getName()+"\t"+b.getPrice()+"\t"+b.getAuthor()+"\t"+b.getPress());
        }
    }
}
