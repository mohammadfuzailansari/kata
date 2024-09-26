package org.example.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public abstract class AbstractHttpClient {

    public static final String BASE_URL = "http://localhost:7070";

    protected final HttpClient httpClient;

    public AbstractHttpClient() {

        LoopResources mfa = LoopResources.create("mfa", 1, true);
        this.httpClient = HttpClient.create().runOn(mfa).baseUrl(BASE_URL);;
        //this.httpClient = HttpClient.create().baseUrl(BASE_URL);

    }
}
