package org.example.sec03;

import org.example.common.Util;
import reactor.core.Disposable;

public class StockClient {

    private static float balance = 1000;
    private static int quantity = 0;
    public static void main(String[] args) {
        String uri = "/demo02/stock/stream";
        Disposable[] subscriptionHolder = new Disposable[1];

        subscriptionHolder[0] = new ExternalServiceClient().getData(uri)
                .subscribe(s -> handleStockUpdate(Integer.parseInt(s), subscriptionHolder[0]));

        Util.sleep(20000);
    }

    private static void handleStockUpdate(Integer stockPrice, Disposable subscription) {
        System.out.println("Received Stock price as "+ stockPrice);
        if(stockPrice.intValue() < 90 && balance > 0){
            System.out.println("Buying Stock");
            quantity++;
            balance -=stockPrice.intValue();
        } else if (stockPrice.intValue() >100 && quantity > 0) {
            balance = balance + (quantity * stockPrice.intValue());
            quantity = 0;
            System.out.println("Sold all Stock : Profit is " + balance);

            subscription.dispose();

        }

    }
}

