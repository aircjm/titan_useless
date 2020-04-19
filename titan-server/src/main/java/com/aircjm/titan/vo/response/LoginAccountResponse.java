package com.aircjm.titan.vo.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginAccountResponse {

    /**
     * status : ok
     * type : account
     * currentAuthority : admin
     */

    private String status;
    private String type;
    private String currentAuthority;


    public static LoginAccountResponse ok() {

        return LoginAccountResponse.builder().status("ok").currentAuthority("admin").type("account").build();

    }


}
