package za.co.reverside.service.calendar;


import com.zenerick.service.batch.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Service
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    @ComponentScan(basePackages = "za.co.reverside.service")
    public static class executors{}

    @Configuration
    @EnableFeignClients("za.co.reverside.service")
    public static class clients{}

}
