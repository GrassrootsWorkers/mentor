package com.dream.mentor.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/15.
 */
@Component
public class CreateAllIndexTask {
    Logger log = LoggerFactory.getLogger(CreateAllIndexTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    /*@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }*/


    public void testCron(){
        log.info("The time is now 》》》》》》》》》》》》》》》》{}", dateFormat.format(new Date()));
    }
}
