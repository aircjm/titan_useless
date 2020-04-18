package com.aircjm.titan.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildrenBean {

    @JsonProperty("classes_id")
    private Integer classesId;
    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("outer_url")
    private String outerUrl;
    @JsonProperty("style")
    private Object style;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("item_id")
    private Integer itemId;
    @JsonProperty("item_code")
    private String itemCode;
}
