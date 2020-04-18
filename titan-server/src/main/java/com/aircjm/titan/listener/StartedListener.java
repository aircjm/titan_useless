package com.aircjm.titan.listener;

import com.aircjm.titan.config.TitanProperties;
import com.aircjm.titan.service.blog.OptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * The method executed after the application is started.
 *
 * @author haseochen
 */
@Slf4j
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StartedListener implements ApplicationListener<ApplicationStartedEvent> {

    @Resource
    private OptionService optionService;

    @Resource
    private TitanProperties titanProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        this.printStartInfo();
    }

    private void printStartInfo() {
        String baseUrl = optionService.getBaseUrl();

        if (!titanProperties.isDocDisabled()) {
            log.info(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, "Swagger api doc was enabled at ", baseUrl, "/swagger-ui.html"));
        }
        log.info(AnsiOutput.toString(AnsiColor.BRIGHT_YELLOW, "Project has started successfully!"));
    }

}
