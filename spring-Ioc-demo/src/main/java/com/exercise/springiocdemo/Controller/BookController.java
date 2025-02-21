package com.exercise.springiocdemo.Controller;

import com.exercise.springiocdemo.dao.BookInfo;
import com.exercise.springiocdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Component: 表示把对象交给spring管理
 * @Autowired: 表示从sprin取对象，并给对象赋值
 */
@RequestMapping("book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;//通过注入的方式

    //理应从数据库中查询图书信息, 但是还未学习数据库相关操作, 暂且mock数据
    @RequestMapping("getList")
    public List<BookInfo> getList(){
        List<BookInfo> book = bookService.getBookList();
        return book;
    }

}
