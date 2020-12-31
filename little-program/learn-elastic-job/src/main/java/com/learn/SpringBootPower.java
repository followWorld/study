package com.learn;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

@ImportResource(value = "elastic-job.xml")
@SpringBootApplication(scanBasePackages = { "com.learn" })
public class SpringBootPower {
    private static final Logger log = LoggerFactory.getLogger(SpringBootPower.class);

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext application = SpringApplication.run(SpringBootPower.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("-------application DONE----------\n");
        log.info("\n----------------------------------------------------------\n\t"
                + "Application Base-Boot is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
                + "/\n\t" + "External: \thttp://" + ip + ":" + port + path + "/\n"
                + "----------------------------------------------------------");

    }

}
