package com.green.madang.manager.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderGetRes {
    private int orderId;
    private int custId;
    private String name;
    private int bookId;
    private String bookName;
    private int salePrice;
    private String orderDate;
}
