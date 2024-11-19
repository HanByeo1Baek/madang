package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

/*
    우리가 만드는 API는 응답 때 JSON형태로 응답한다.
    응답시 객체에 있는 특정 멤버필드의 값을 제외하고 싶을 때
    @JsonIgnore를 멤버필드에 붙이면 제외시킬 수 있다.
    (응답 때 JsonIgnore를 쓰는 경우는 거의 없다.)

    Swagger 문서상에 응답 Schema에서 안 보이기도 한다.
 */
@Getter
@Setter
@ToString
public class CustomerGetReq {
    //@Schema, JsonIgnore 애노테이션은 Swagger용 애노테이션
    @Schema(description = "page값", example = "1"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private int custPage;
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private int custSize;
    // @JsonIgnore 와 @Schema(hidden = true)는 Swagger 문서상에 Parameters 부분에서 보이지 않게 하는 역할
    @JsonIgnore
    //@Schema(hidden = true) <- 이거 써도 JsonIgnore랑 같은 효과임 안보임
    private int custStartIdx; // (page - 1) * size
    @Schema(name = "search_type", description = "검색타입 : {name, address, phone}중 한 값을 보낸다."
            , example = "name")
    private String searchType;
    @Schema(name = "search_text", description = "검색 내용", example = "ani")
    private String searchText;

    public CustomerGetReq(int page, int size, @BindParam("search_type") String searchType, @BindParam("search_text") String searchText) {
        this.custPage = page;
        this.custSize = size;
        this.searchType = searchType;
        this.searchText = searchText;
        this.custStartIdx = (page - 1) * size;
    }
}
