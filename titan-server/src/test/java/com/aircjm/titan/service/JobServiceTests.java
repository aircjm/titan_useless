package com.aircjm.titan.service;

import com.aircjm.titan.model.tool.TaskLog;
import com.aircjm.titan.service.task.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobServiceTests {

    @Autowired
    JobService jobService;

    @Test
    public void getTaskList() {
       jobService.getTaskList();
    }

    @Test
    public void insertTaskLog() {
        TaskLog taskLog = new TaskLog();
        taskLog.setName("测试");
        taskLog.insert();
    }


}
