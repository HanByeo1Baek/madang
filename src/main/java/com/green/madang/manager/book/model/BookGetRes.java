package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetRes {
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;
}
