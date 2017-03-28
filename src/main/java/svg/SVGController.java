package svg;

import gocd.GoCdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@SpringBootApplication
@Controller
public class SVGController {

    @Autowired GoCdClient goCdClient;

    @RequestMapping(value = "/badge/{pipeline}", produces = "image/svg+xml")
    @ResponseBody
    public byte[] getBadge(@PathVariable(value = "pipeline") String pipeline) throws IOException {
        return SVGService.getBadge(goCdClient.getStatus(pipeline)).getBytes();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SVGController.class).run(args);
    }
}
