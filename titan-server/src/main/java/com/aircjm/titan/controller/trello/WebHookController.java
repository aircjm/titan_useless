package com.aircjm.titan.controller.trello;

import com.aircjm.titan.service.trello.TrelloService;
import com.aircjm.titan.utils.JsonUtil;
import com.aircjm.titan.vo.RestResponse;
import com.aircjm.titan.vo.request.TrelloWebHookReqeust;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author aircjm
 */
@RequestMapping(value = "/api/trello/webhook/")
@RestController
@Slf4j
public class WebHookController {

    @Resource
    private TrelloService trelloService;


    @PostMapping(value = "/memberWebHook")
    public RestResponse postMemberWebHook(@RequestBody TrelloWebHookReqeust reqeust) {
        log.info(JsonUtil.objectToJson(reqeust));
        return RestResponse.ok();
    }

    @GetMapping(value = "/memberWebHook")
    public RestResponse getMemberWebHook() {
        log.info("验证webhook成功");
        return RestResponse.ok();
    }


    @GetMapping(value = "/createMyWebHook")
    public RestResponse createMyWebHook() {

        trelloService.createMyWebHook();
        return RestResponse.ok();
    }


}
