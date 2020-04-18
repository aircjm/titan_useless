package com.aircjm.titan.mapper.auth;

import com.aircjm.titan.utils.JsonUtil;
import com.aircjm.titan.vo.response.GroupInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthRoleMapperTest {

    @Resource
    private AuthRoleMapper authRoleMapper;


    @Test
    public void getGroupInfo() throws JsonProcessingException {
        List<GroupInfoResponse> groupInfo = authRoleMapper.getGroupInfo(null, "dice");

        log.info(JsonUtil.objectToJson(groupInfo));

    }
}