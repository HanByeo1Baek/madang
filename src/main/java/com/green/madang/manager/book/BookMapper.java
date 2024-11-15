package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int insBook(BookPostReq i);
    List<BookGetRes> selBookList(BookGetReq s);
    int updBook(BookUpdateReq u);
    int delBook(BookDeleteReq d);
}
