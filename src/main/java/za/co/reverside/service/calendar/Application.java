package za.co.reverside.service.calendar;


import com.zenerick.service.batch.Executor;
import com.zenerick.service.batch.IExecutor;
import com.zenerick.service.batch.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import za.co.reverside.service.calendar.executor.BirthdayNotification;

@Service
public class Application extends Executor{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @ComponentScan("za.co.reverside.service.calendar")
    public static class executors{}

    @EnableFeignClients("za.co.reverside.service.calendar")
    public  static class clients{}

    @Autowired
    private BirthdayNotification birthdayNotification;

    @Override
    protected IExecutor<?, ?> executor(Class<?> type) {
        if(type.equals(BirthdayNotification.class)){
            return birthdayNotification;
        }
        throw new RuntimeException("Executor Not Found");
    }

}
