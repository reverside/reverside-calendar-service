package za.co.reverside.service.calendar.temp;

import com.zenerick.service.employee.query.Employee;
import com.zenerick.service.notification.command.Notify;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TempController {

    @RequestMapping(value = "/api/employees/birthday", method = RequestMethod.GET)
    public List<Employee> findByBirthday(@RequestParam("birthday") String birthday){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Manmay");
        employee.setSurname("Mohanty");
        employee.setPhoto("http://example.org");
        employee.setEmail("manmay.mohanty@reverside.co.za");
        employee.setMobile("0846860904");
        employee.setDob("10/10/2014");
        employee.setDoj("10/10/2014");
        return Arrays.asList(employee);
    }

    @RequestMapping(value = "/api/commands/notify", method = RequestMethod.POST)
    public void notify(@RequestBody Notify command, @RequestParam("entity") String entity, @RequestParam("user") String user ){
        System.out.println(command);
    }
}
