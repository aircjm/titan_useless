package com.aircjm.titan.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoResponse {

    private List<Integer> roleIds;
    private String created;
    private String logged;
    private String passwordMd5;
    private Integer id;
    private String screenName;
    private String username;
    private String email;
}
