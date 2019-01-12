package test7;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: xcx
 * @Date: 2019/1/12 22:30
 * @Version 1.0
 */
public class Book implements Serializable {
    private String no;
    private String name;
    private BigDecimal price;
    private String author;
    private String press;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
