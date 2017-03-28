package gocd;

import gocd.model.ConnectionDetails;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class GoCdClient {
    private HttpHost targetHost;
    private HttpClientContext context;
    private CloseableHttpClient client;
    private ConnectionDetails connectionDetails;

    public GoCdClient(ConnectionDetails connectionDetails) throws MalformedURLException {
        this.connectionDetails = connectionDetails;
        setup(connectionDetails);
    }

    public Status getStatus(String project) throws IOException {
        String url = String.format("/go/api/pipelines/%s/history/", project);

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = client.execute(targetHost, httpGet, context);
        Map<String, Object> history = JsonUtils.parseJsonToMap(EntityUtils.toString(response.getEntity()));

        List<Map<String, Object>> pipelines = (List<Map<String, Object>>) history.get("pipelines");
        List<Map<String, Object>> stages = (List<Map<String, Object>>) pipelines.get(0).get("stages");
        String result = (String) stages.get(stages.size()-1).get("result");

        return Status.valueOf(result.toUpperCase());
    }

    private void setup(ConnectionDetails connectionDetails) throws MalformedURLException {
        client = HttpClients.createDefault();

        targetHost = getHttpHost();
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
            new AuthScope(targetHost.getHostName(), targetHost.getPort()),
            new UsernamePasswordCredentials(connectionDetails.getUserName(),
                connectionDetails.getPassword()));

        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Add AuthCache to the execution context
        context = HttpClientContext.create();
        context.setCredentialsProvider(credentialsProvider);
        context.setAuthCache(authCache);
    }

    private HttpHost getHttpHost() throws MalformedURLException {
        URL url = new URL(connectionDetails.getHost());
        int port = url.getPort() > 0 ? url.getPort() : url.getDefaultPort();
        return new HttpHost(url.getHost(), port, url.getProtocol());
    }
}
