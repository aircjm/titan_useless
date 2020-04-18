package com.aircjm.titan.service.task;

import com.aircjm.titan.model.tool.Task;

/**
 * @author haseochen
 */
public interface TaskService {

    /**
     * @param task
     * @return
     */
    Task save(Task task);

    public Task disable(Long id);

    Task enable(Long id);

    void delete(Long id);
}
