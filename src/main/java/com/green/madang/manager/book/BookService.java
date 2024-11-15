package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int postBook(BookPostReq i){
        return mapper.insBook(i);
    }

    public List<BookGetRes> getBookList(BookGetReq s){
        // sIdx값 세팅
        s.setStartIdx((s.getPage() - 1)*s.getSize());
        return mapper.selBookList(s);
    }

    public int putBook(BookUpdateReq u){
        return mapper.updBook(u);
    }

    public int deleteBook(BookDeleteReq d){
        return mapper.delBook(d);
    }
}
