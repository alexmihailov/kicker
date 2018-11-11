package com.witcher.kicker.worker;

import com.witcher.kicker.email.service.MailService;
import com.witcher.kicker.domain.kupipotter.exception.KupipotterException;
import com.witcher.kicker.domain.kupipotter.service.KupipotterService;
import com.witcher.kicker.domain.potterland.exception.PotterlandException;
import com.witcher.kicker.domain.potterland.service.PotterlandService;
import com.witcher.kicker.domain.rosman.exception.RosmanException;
import com.witcher.kicker.domain.rosman.service.RosmanService;
import com.witcher.kicker.domain.rosmean.exception.RosmeanException;
import com.witcher.kicker.domain.rosmean.service.RosmeanService;
import com.witcher.kicker.domain.zigzag.exception.ZigzagException;
import com.witcher.kicker.domain.zigzag.service.ZigzagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import static com.witcher.kicker.worker.TypeKick.*;

@Component
public class WorkerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerManager.class);

    @Autowired
    private KupipotterService kupipotterService;

    @Autowired
    private PotterlandService potterlandService;

    @Autowired
    private RosmanService rosmanService;

    @Autowired
    private RosmeanService rosmeanService;

    @Autowired
    private ZigzagService zigzagService;

    @Autowired
    private MailService mailService;

    @Scheduled(cron = "${worker.manager.kupipotter.cron}")
    public void kickKupipotter() {
        LOGGER.info("[worker] Start operation for Kupipotter.");
        runKick(KUPIPOTTER);
    }

    @Scheduled(cron = "${worker.manager.potterland.cron}")
    public void kickPoterland() {
        LOGGER.info("[worker] Start operation for Potterland.");
        runKick(POTTERLAND);
    }

    @Scheduled(cron = "${worker.manager.rosman.cron}")
    public void kickRosman() {
        LOGGER.info("[worker] Start operation for Rosman.");
        runKick(ROSMAN);
    }

    @Scheduled(cron = "${worker.manager.rosmean.cron}")
    public void kickRosmean() {
        LOGGER.info("[worker] Start operation for Rosmean.");
        runKick(ROSMEAN);
    }

    @Scheduled(cron = "${worker.manager.zigzag.cron}")
    public void kickZigzag() {
        LOGGER.info("[worker] Start operation for Zigzag.");
        runKick(ZIGZAG);
    }

    private void runKick(TypeKick kick) {
        try {
            switch (kick) {
                case KUPIPOTTER:
                    kupipotterService.sendKupipotterRequest();
                    break;
                case POTTERLAND:
                    potterlandService.sendPotterlandRequest();
                    break;
                case ROSMAN:
                    rosmanService.sendRosmanRequest();
                    break;
                case ROSMEAN:
                    rosmeanService.sendRosmeanRequest();
                    break;
                case ZIGZAG:
                    zigzagService.sendZigzagRequest();
                    break;
            }
        } catch (KupipotterException | ZigzagException | RosmanException
                | PotterlandException | RosmeanException | RestClientException e) {
            LOGGER.error(e.getMessage());
            mailService.sendEmail("Request execution failed", e.getMessage());
        }
    }
}
