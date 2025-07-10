package com.skyline.jobs;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;


@Qualifier("ProcesosJob")
public class ProcesosJob implements BeanJob, Job {

    private final AtomicInteger counter = new AtomicInteger(1);
    private final String ID_JOB_DETAIL = "SKLINE_PROCESOS_JOB_DETAIL_ID";
    private final String ID_JOB_TRIGGER = "SKLINE_PROCESOS_JOB_TRIGGER_ID";
    private final String GROUP = "SKLINE_PROCESOS_JOB_GROUP";

    public ProcesosJob (){}

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
        return JobBuilder.newJob(ProcesosJob.class).withIdentity(jobKey).storeDurably(false).build();
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