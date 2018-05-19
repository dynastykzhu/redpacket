package com.wsloan.redpacket.async;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Created by EdsionGeng on 2018/4/23.
 */
//@ConfigurationProperties(prefix = "spring.task.pool")
@Data
public class TaskThreadPoolConfig {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

}