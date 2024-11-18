package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;

    public int postCust(CustomerPostReq i){
        return mapper.insCust(i);
    }

    public List<CustomerGetRes> getCust(CustomerGetReq s){
        s.setCustStartIdx((s.getCustPage()-1)*s.getCustSize());
        return mapper.selCust(s);
    }

    public int putCust(CustomerPutReq u){
        return mapper.updCust(u);
    }

    public int delCust(CustomerDeleteReq d){
        return mapper.delCust(d);
    }
}
