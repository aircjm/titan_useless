package com.aircjm.titan.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildrenBeanX {

    @JsonProperty("classes_id")
    private Integer classesId;
    @JsonProperty("style")
    private String style;
    @JsonProperty("classes_url")
    private String classesUrl;
    @JsonProperty("is_display")
    private Integer isDisplay;
    @JsonProperty("classes_name")
    private String classesName;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("group_id")
    private Integer groupId;
    @JsonProperty("children")
    private List<ChildrenBean> children;
}
