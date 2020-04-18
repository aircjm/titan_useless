package com.aircjm.titan.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupInfoResponse {


    @JsonProperty("project_type")
    private String projectType;
    @JsonProperty("group_url")
    private String groupUrl;
    @JsonProperty("is_display")
    private Integer isDisplay;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("style")
    private String style;
    @JsonProperty("group_id")
    private Integer groupId;
    @JsonProperty("children")
    private List<ChildrenBeanX> childrenBeanXList;

}
