package com.aircjm.titan.service.trello.impl;

import com.aircjm.titan.exception.TipException;
import com.aircjm.titan.model.system.SysConfig;
import com.aircjm.titan.service.system.SysConfigService;
import com.aircjm.titan.service.trello.TrelloService;
import com.aircjm.titan.utils.JsonUtil;
import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author aircjm
 */
@Slf4j
@Service
public class TrelloServiceImpl implements TrelloService {

    @Resource
    private Trello trello;

    @Resource
    private SysConfigService sysConfigService;


    @Override
    public void createMyWebHook() {

    }

    @Override
    public Member getMyMemberInfo() {
        SysConfig systemConfig = sysConfigService.getSystemConfigByKey("trello.dev.api.memberId");
        if (Objects.isNull(systemConfig)) {
            throw new TipException("系统配置不能为空，trello.dev.api.memberId");
        }

        Member memberInformation = trello.getMemberInformation(systemConfig.getConfigValue());
        log.info(JsonUtil.objectToJson(memberInformation));
        return memberInformation;
    }
}
