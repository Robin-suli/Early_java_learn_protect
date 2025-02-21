package com.exercise.springiocdemo.dao;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookDao {
    public List<BookInfo> mockData(){
        List<BookInfo> bookInfos = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setPublish("出版社"+i);
            bookInfo.setNum(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setStatus(i%5==0?2:1); //1-可借阅   2-不可借阅
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
