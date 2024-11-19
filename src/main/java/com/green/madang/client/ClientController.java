package com.green.madang.client;

import com.green.madang.client.model.OrderGetReq;
import com.green.madang.client.model.OrderGetRes;
import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
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
@RequestMapping("clinet")
@Tag(name = "주문", description = "도서 주문")
public class ClientController {
    private final ClientService service;

    //@RestController 말고 @Controller를 사용하면 @ResponseBody를 사용해야 JSON으로 응답할 수 있다.
    @PostMapping("order")
    @Operation(summary = "책 주문")
    public MyResponse<Integer> postOrders(@RequestBody OrderPostReq i){
        int result = service.postOrder(i);
        return new MyResponse<>("주문 완료", result);
    }

    //본인이 주문한 책 리스트
    @GetMapping("order")
    @Operation(summary = "책 주문 리스트")
    public MyResponse<List<OrderGetRes>> getOrder(@ParameterObject @ModelAttribute OrderGetReq s){
        List<OrderGetRes> list = service.getOrders(s);
        return new MyResponse<>(list.size() +
                " rows", list);
    }
}
