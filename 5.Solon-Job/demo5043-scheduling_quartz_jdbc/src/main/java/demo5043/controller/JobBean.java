package demo5043.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author noear 2021/12/28 created
 */
@Slf4j
@Component
public class JobBean {
    @Scheduled(fixedRate = 1000 * 3)
    public void job11(){
        log.warn(new Date() + ": 1000*3");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "+00")
    public void job12(){
        log.warn(new Date() + ": 0/10 * * * * ? *");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "CET")
    public void job13(){
        log.warn(new Date() + ": 0/10 * * * * ? *");
    }

    @Scheduled(cron = "0/10 * * * * ? *", zone = "Asia/Shanghai")
    public void job14(){
        log.warn(new Date() + ": 0/10 * * * * ? *");
    }
}
