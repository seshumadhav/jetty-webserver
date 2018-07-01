package com.smc.webserver;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author seshu
 */
public class JettyIntegrationTest {
    private static JettyServer jettyServer;

    @BeforeClass
    public static void setup() throws Exception {
        jettyServer = new JettyServer();
        jettyServer.start();
    }

    @AfterClass
    public static void cleanup() throws Exception {
        jettyServer.stop();
    }

    @Test
    public void givenServer_whenSendRequestToBlockingServlet_thenReturnStatusOK() throws Exception {
        // given
        String url = "http://localhost:8090/status";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        // then
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);

    }
}
