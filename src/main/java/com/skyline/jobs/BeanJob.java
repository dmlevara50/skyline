package com.skyline.jobs;

import org.quartz.JobDetail;
import org.quartz.Trigger;

public interface BeanJob {
    JobDetail executeJobDetail();
    Trigger executeTrigger();
}
