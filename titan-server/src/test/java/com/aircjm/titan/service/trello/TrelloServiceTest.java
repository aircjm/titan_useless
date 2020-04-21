package com.aircjm.titan.service.trello;

import com.julienvey.trello.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloServiceTest {
    @Resource
    private TrelloService trelloService;


    @Test
    public void getMyMemberInfo() {
        Member myMemberInfo = trelloService.getMyMemberInfo();
    }
}