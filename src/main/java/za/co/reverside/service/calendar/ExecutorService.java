package za.co.reverside.service.calendar;

import com.zenerick.service.batch.Executor;
import com.zenerick.service.batch.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.reverside.service.calendar.handler.BirthdayNotification;

@Service
public class ExecutorService extends Executor {

    @Autowired
    private BirthdayNotification birthdayNotification;

    @Override
    protected JobHandler<?, ?> handler(Class<?> type) {
        System.out.println("Finding Executor");
        if(type.equals(BirthdayNotification.class)){
            return birthdayNotification;
        }
        throw new RuntimeException("Executor Not Found");
    }
}
