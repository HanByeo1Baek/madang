package com.green.madang.manager.order;

import com.green.madang.manager.order.model.OrderGetRes;
import com.green.madang.manager.order.model.OrderGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderGetRes> selOrderList(OrderGetReq s);
}
