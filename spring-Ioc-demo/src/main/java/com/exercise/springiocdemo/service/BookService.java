package com.exercise.springiocdemo.service;

import com.exercise.springiocdemo.dao.BookDao;
import com.exercise.springiocdemo.dao.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class BookService {
    @Autowired
    private BookDao bookDao;//通过注入的方式

    public List<BookInfo> getBookList(){
        //理应从数据库中查询图书信息, 但是还未学习数据库相关操作, 暂且mock数据
        List<BookInfo> book = bookDao.mockData();

        for (BookInfo books: book){
            if (books.getStatus()==1){
                books.setStatusCN("可借阅");
            }else {
                books.setStatusCN("不可借阅");
            }
        }
        return book;
    }
}
