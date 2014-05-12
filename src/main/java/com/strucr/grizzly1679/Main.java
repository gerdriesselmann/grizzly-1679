package com.strucr.grizzly1679;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.ning.http.client.providers.grizzly.GrizzlyAsyncHttpProvider;

import java.util.concurrent.Future;

/**
 * Run a request
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("\n== Usage Error ==\nPlease pass URL to call");
            System.exit(1);
        }
        String url = args[0];

        AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
            .setCompressionEnabled(true)
            .setFollowRedirects(false)
            .setUserAgent("Grizzly 1679 Test Case")
            .setConnectionTimeoutInMs(15000)
            .setRequestTimeoutInMs(15000)
            .setAllowPoolingConnection(false)
            .setUseRawUrl(true)
            .setIOThreadMultiplier(2) // 2 is default
            .build();

        AsyncHttpClient client = new AsyncHttpClient(new GrizzlyAsyncHttpProvider(config), config);

        try {
            Future<Response> f = client.prepareGet(url).execute();
            Response r = f.get();
            System.out.println("\n== OK ==\nGot Respone " + r.getStatusText());
            System.exit(0);
        } catch (Exception e) {
            System.out.println("\n== Bug Hit! ==\nCaught Exception " + e.toString());
            System.exit(2);
        }
    }
}
