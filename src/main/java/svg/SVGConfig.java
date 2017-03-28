package svg;

import gocd.GoCdClient;
import gocd.model.ConnectionDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class SVGConfig {

    @Bean
    public ConnectionDetails connectionDetails(@Value("${host}") String host,
                                               @Value("${userName}") String userName,
                                               @Value("${password}") String password) {
        return new ConnectionDetails(host, userName, password);
    }

    @Bean
    public GoCdClient goCdClient(ConnectionDetails connectionDetails) throws MalformedURLException {
        return new GoCdClient(connectionDetails);
    }
}
