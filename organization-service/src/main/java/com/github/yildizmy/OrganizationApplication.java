package com.github.yildizmy;

import com.github.yildizmy.model.Organization;
import com.github.yildizmy.repository.OrganizationRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j(topic = "OrganizationApplication")
@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
    @Info(title = "Organization API", version = "1.0", description = "Documentation Organization API v1.0")
)
public class OrganizationApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OrganizationApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = (env.getProperty("server.ssl.key-store") != null) ? "https" : "http";
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path", "/");
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n" +
                "-------------------------------------------------------\n" +
                "Application '" + env.getProperty("spring.application.name") + "' is running! Access URLs:\n" +
                "Local:      " + protocol + "://localhost:" + serverPort + contextPath + "\n" +
                "External:   " + protocol + "://" + hostAddress + ":" + serverPort + contextPath + "\n" +
                "Profile(s): " + String.join(",", env.getActiveProfiles()) + "\n" +
                "-------------------------------------------------------");
    }

    @Bean
    OrganizationRepository repository() {
        OrganizationRepository repository = new OrganizationRepository();
        repository.add(new Organization("Microsoft", "Redmond, Washington, USA"));
        repository.add(new Organization("Oracle", "Redwood City, California, USA"));
        return repository;
    }
}
