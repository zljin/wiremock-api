package com.zljin.pt.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.zljin.pt.mock.utils.ClasspathFileSourceWithoutLeadingSlash;
import com.zljin.pt.mock.utils.RamdomMatcherExtension;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@SpringBootApplication
public class WiremockApiApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(WiremockApiApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args){
        WireMockServer wireMockServer = new WireMockServer(options().disableRequestJournal().asynchronousResponseEnabled(true).asynchronousResponseThreads(100)
                .fileSource(new ClasspathFileSourceWithoutLeadingSlash()).extensions(RamdomMatcherExtension.class));
        wireMockServer.start();
    }
}