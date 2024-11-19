package com.green.madang.manager.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderGetReq {
    private int orderPage;
    private int orderSize;
    @JsonIgnore
    private int orderStartIdx;
}
