package com.github.yildizmy;

import com.github.yildizmy.model.Employee;
import com.github.yildizmy.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j(topic = "EmployeeApplication")
@SpringBootApplication
@OpenAPIDefinition(info =
    @Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0")
)
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EmployeeApplication.class);
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
    EmployeeRepository repository() {
        EmployeeRepository repository = new EmployeeRepository();
        repository.add(new Employee(1L, 1L, "John Smith", 34, "Analyst"));
        repository.add(new Employee(1L, 1L, "Darren Hamilton", 37, "Manager"));
        repository.add(new Employee(1L, 1L, "Tom Scott", 26, "Developer"));
        repository.add(new Employee(1L, 2L, "Anna London", 39, "Analyst"));
        repository.add(new Employee(1L, 2L, "Patrick Dempsey", 27, "Developer"));
        repository.add(new Employee(2L, 3L, "Kevin Price", 38, "Developer"));
        repository.add(new Employee(2L, 3L, "Ian Scott", 34, "Developer"));
        repository.add(new Employee(2L, 3L, "Andrew Campton", 30, "Manager"));
        repository.add(new Employee(2L, 4L, "Steve Franklin", 25, "Developer"));
        repository.add(new Employee(2L, 4L, "Elisabeth Smith", 30, "Developer"));
        return repository;
    }
}
