package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("manager/customer")
@Tag(name = "고객", description = "고객 정보 API")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "고객 등록", description = "고객 등록 API")
    public MyResponse<Integer> postCustomer(@RequestBody CustomerPostReq i){
        int result = service.postCust(i);
        return new MyResponse<>("등록 완료", result);
    }

    @GetMapping
    @Operation(summary = "고객 검색", description = "고객 검색 API")
    public MyResponse<List<CustomerGetRes>> getCustList(@ParameterObject CustomerGetReq s){
        List<CustomerGetRes> list = service.getCust(s);
        return new MyResponse<>(s.getCustPage() + "검색 완료", list);
    }

    //RequestParam을 이용한 GetMapping
    @GetMapping("/param")
    @Operation(summary = "고객 검색2", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    public MyResponse<List<CustomerGetRes>> getCustList(@RequestParam int page, @RequestParam int size,
                                                        @RequestParam(name = "search_type", required = false) String searchType
                                                        , @RequestParam(name = "search_text", required = false) String searchText){
        CustomerGetReq p = new CustomerGetReq();
        p.setCustPage(page);
        p.setCustSize(size);
        p.setSearchType(searchType);
        p.setSearchText(searchText);

        log.info("get-req : {}", p);
        List<CustomerGetRes> list = service.getCust(p);
        return new MyResponse<>(p.getCustPage() + "검색 완료", list);
    }

    @PutMapping
    @Operation(summary = "고객 수정", description = "고객 수정 API")
    public MyResponse<Integer> putCustomer(@RequestBody CustomerPutReq u){
        int result = service.putCust(u);
        return new MyResponse<>(u.getCustId() + "번 고객 수정 완료", result);
    }

    @DeleteMapping
    @Operation(summary = "고객 삭제", description = "고객 삭제 API")
    public MyResponse<Integer> deleteCustomer(CustomerDeleteReq d){
        int result = service.delCust(d);
        return new MyResponse<>(d.getCustId() + "번 고객 삭제 완료", result);
    }
}
