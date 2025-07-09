package com.skyline.configure;

import com.skyline.jobs.BeanJob;
import com.skyline.utils.SkylineUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;


@Component
@Qualifier("AutowireCapableBeanJobFactory")
public class AutowireCapableBeanJobFactory extends SpringBeanJobFactory {

    @Bean
    public AutowireCapableBeanJobFactory getAutowiringSpringBeanJobFactory(){
        return new AutowireCapableBeanJobFactory();
    }

    @Bean
    public Scheduler scheduler(Scheduler scheduler) throws SchedulerException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        final List<Class<? extends Class<?>>> result = SkylineUtils.getAllInterfaces(BeanJob.class);
        Iterator<Class<? extends Class<?>>> iterator = result.iterator();
        while (iterator.hasNext()){
            Object bean = iterator.next().getDeclaredConstructor().newInstance();
            BeanJob iBeanJob = (BeanJob) bean;
            JobDetail job = iBeanJob.executeJobDetail();
            Trigger trigger = iBeanJob.executeTrigger();
            scheduler.scheduleJob(job, trigger);
        }
        return scheduler;
    }
}
