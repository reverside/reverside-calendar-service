package za.co.reverside.service.calendar.service;

import com.zenerick.service.notification.command.Notify;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="notification", url = "http://localhost:${server.port}")
public interface NotificationService {

    @RequestMapping(value = "/api/commands/notify", method = RequestMethod.POST)
    public void notify(@RequestBody Notify command, @RequestParam("entity") String entity, @RequestParam("user") String user );

}