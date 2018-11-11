package com.witcher.kicker.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WorkerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerManager.class);

    @Scheduled(cron = "${worker.manager.kupipotter.cron}")
    public void kickKupipotter() {
        LOGGER.info("[worker] Start operation for Kupipotter.");
    }

    @Scheduled(cron = "${worker.manager.potterland.cron}")
    public void kickPoterland() {
        LOGGER.info("[worker] Start operation for Potterland.");
    }

    @Scheduled(cron = "${worker.manager.rosman.cron}")
    public void kickRosman() {
        LOGGER.info("[worker] Start operation for Rosman.");
    }

    @Scheduled(cron = "${worker.manager.rosmean.cron}")
    public void kickRosmean() {
        LOGGER.info("[worker] Start operation for Rosmean.");
    }

    @Scheduled(cron = "${worker.manager.zigzag.cron}")
    public void kickZigzag() {
        LOGGER.info("[worker] Start operation for Zigzag.");
    }
}
