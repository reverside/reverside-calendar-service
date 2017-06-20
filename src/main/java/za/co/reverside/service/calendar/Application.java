package za.co.reverside.service.calendar;


import com.zenerick.service.batch.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@Service
@EnableFeignClients("za.co.reverside.service.calendar")
@ComponentScan({"za.co.reverside.service.calendar", "com.zenerick.service.batch"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
