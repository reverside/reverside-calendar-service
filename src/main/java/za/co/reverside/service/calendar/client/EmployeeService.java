package za.co.reverside.service.calendar.client;

import com.zenerick.service.employee.query.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findByBirthdayIsToday(){
        String sql = "SELECT  * FROM EMPLOYEES WHERE MONTH(TO_DATE(DOB, 'DD/MM')) = MONTH(CURRENT_DATE) AND DAYOFMONTH(TO_DATE(DOB, 'DD/MM')) = DAYOFMONTH(CURRENT_DATE)";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setEmail(resultSet.getString("email"));
                employee.setMobile(resultSet.getString("mobile"));
                employee.setPhoto("");
                employee.setDob(resultSet.getString("dob"));
                employee.setDoj(resultSet.getString("doj"));
                return employee;
            }
        });
    };

}
