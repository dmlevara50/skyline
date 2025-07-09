package com.skyline.jobs;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Qualifier("ElasticSearchJob")
public class ElasticSearchJob implements BeanJob, Job {

    private final AtomicInteger counter = new AtomicInteger(1);
    private final String ID_JOB_DETAIL = "SKLINE_ELASTICSEARCH_JOB_DETAIL_ID";
    private final String ID_JOB_TRIGGER = "SKLINE_ELASTICSEARCH_JOB_TRIGGER_ID";
    private final String GROUP = "SKLINE_ELASTICSEARCH_JOB_GROUP";

    @Autowired
    Scheduler scheduler;

    public ElasticSearchJob(){}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        String name = Thread.currentThread().getName();
        System.out.println("Execute quartz " + jobExecutionContext.getJobDetail().getJobClass() + ", threadName = \"" + name +
                "\", the " + counter.getAndIncrement() + "th execution, time = \"" +
                now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\"");
    }

    @Override
    public JobDetail executeJobDetail() {
        JobKey jobKey = new JobKey(ID_JOB_DETAIL, GROUP);
        return JobBuilder.newJob(ElasticSearchJob.class).withIdentity(jobKey).build();
    }

    @Override
    public Trigger executeTrigger() {
        return TriggerBuilder
                .newTrigger()
                .withIdentity(ID_JOB_TRIGGER, GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
    }

}

