package org.example.sec03;

import org.example.common.Util;

public class FluxNonBlockingStream   {

    public static void main(String[] args) {
        ExternalServiceClient externalServiceClient = new ExternalServiceClient();

        externalServiceClient.getData("/demo02/name/stream").subscribe(Util.subscriber());

        Util.sleep(5000);
    }
}
