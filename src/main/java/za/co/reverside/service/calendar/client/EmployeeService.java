package za.co.reverside.service.calendar.client;

import com.zenerick.service.employee.query.Employee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="employee", url = "http://localhost:${server.port}")
public interface EmployeeService {

    @RequestMapping(value = "/api/employees/birthday", method = RequestMethod.GET)
    public List<Employee> findByBirthday(@RequestParam("birthday") String birthday);

}
