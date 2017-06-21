package za.co.reverside.service.calendar.handler;

import com.zenerick.service.batch.JobHandler;
import com.zenerick.service.employee.query.Employee;
import com.zenerick.service.notification.command.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.reverside.service.calendar.service.EmployeeService;
import za.co.reverside.service.calendar.service.NotificationService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Templates;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class BirthdayNotification implements JobHandler<Employee, Notify> {

    @Autowired
    private JAXBContext jaxbContext;

    @Autowired
    private Templates xsltTemplate;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    NotificationService notificationService;

    @Override
    public List<Employee> query(Map<String, String> parameters) throws Exception {
        return employeeService.findByBirthday("");
    }

    @Override
    public Notify prepare(Employee task) throws Exception {
        JAXBSource source = new JAXBSource(jaxbContext, task);
        JAXBResult result = new JAXBResult(jaxbContext);
        xsltTemplate.newTransformer().transform(source, result);
        return (Notify) result.getResult();
    }

    @Override
    public void process(Notify command) throws Exception {
        notificationService.notify(command, String.valueOf(UUID.randomUUID()));
    }

}