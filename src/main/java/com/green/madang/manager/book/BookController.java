package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/book")
@Tag(name = "도서", description = "도서 API")
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고", description = "도서 입고 처리 API")
    public MyResponse<Integer> postBook(@RequestBody BookPostReq i){
        log.info("info {}", i);
        log.warn("warn");
        log.error("error");

        int result = service.postBook(i);
        return new MyResponse<>("책 등록 완료", result);
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description ="도서 정보 리스트 보기 API")
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq s){
        List<BookGetRes> list = service.getBookList(s);
        return new MyResponse<>(s.getPage() + "페이지 데이터", list);
    }

    @PutMapping
    @Operation(summary = "도서 수정", description = "도서 수정 API")
    public MyResponse<Integer> updateBook(@RequestBody BookUpdateReq u){
        int result = service.putBook(u);
        return new MyResponse<>("책 수정 완료", result);
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제", description = "도서 삭제 API")
    public MyResponse<Integer> deleteBook(BookDeleteReq d){
        int result = service.deleteBook(d);
        return new MyResponse<>("삭제 완료", result);
    }
}
