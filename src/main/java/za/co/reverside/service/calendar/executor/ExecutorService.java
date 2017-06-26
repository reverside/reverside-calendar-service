package za.co.reverside.service.calendar.executor;

import com.zenerick.service.batch.Executor;
import com.zenerick.service.batch.IExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutorService extends Executor {

    @Autowired
    private BirthdayExecutor birthdayExecutor;

    @Override
    protected IExecutor<?, ?> executor(Class<?> type) {
        System.out.println("Finding Executor");
        if(type.equals(BirthdayExecutor.class)){
            return birthdayExecutor;
        }
        throw new RuntimeException("Executor Not Found");
    }
}
