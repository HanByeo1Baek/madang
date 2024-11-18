package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int insCust(CustomerPostReq i);
    List<CustomerGetRes> selCust(CustomerGetReq s);
    int updCust(CustomerPutReq u);
    int delCust(CustomerDeleteReq d);
}
