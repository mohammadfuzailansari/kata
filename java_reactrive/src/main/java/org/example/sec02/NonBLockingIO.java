package org.example.sec02;

import org.example.common.ExternalServiceClient;
import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonBLockingIO {

    public static final Logger logger = LoggerFactory.getLogger(NonBLockingIO.class);

    public static void main(String[] args) {
        ExternalServiceClient externalServiceClient = new ExternalServiceClient();
        logger.info("Start");
        for (int i = 1; i < 100; i++) {

            //blockingMethod(externalServiceClient, i);

            externalServiceClient.getProductName(i).subscribe(Util.subscriber());
        }

        Util.sleep(4000);
        //Util.sleep(10000);
    }

    private static void blockingMethod(ExternalServiceClient externalServiceClient, int i) {
        String block = externalServiceClient.getProductName(i).block();
        logger.info(block);
    }
}
