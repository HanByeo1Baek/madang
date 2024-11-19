package com.green.madang.manager.order;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.order.model.OrderGetReq;
import com.green.madang.manager.order.model.OrderGetRes;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/order")
@Tag(name = "ㅁ")
public class OrderController {
    private final OrderService service;

    @GetMapping
    public MyResponse<List<OrderGetRes>> getOrder(@ParameterObject OrderGetReq s){
        List<OrderGetRes> list = service.getOrderList(s);
        return new MyResponse<>(list.size() + " rows", list);
    }
}
