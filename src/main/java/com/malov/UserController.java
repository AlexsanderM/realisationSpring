package com.malov;

import com.malov.domain.Service;
import com.malov.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/user")
    public String user(@RequestParam(name = "name", required = false, defaultValue = "New User") String name,
                       Map<String, Object> model) {
        model.put("name" , name);
        return "user";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Service> services = serviceRepository.findAll();
        model.put("services" , services);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String service, @RequestParam Integer kratnost, Map<String, Object> model) {
        Service serviceDomain = new Service(service, kratnost);

        serviceRepository.save(serviceDomain);

        Iterable<Service> services = serviceRepository.findAll();
        model.put("services" , services);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        List<Service> services = serviceRepository.findByService(filter);
        model.put("services", services);

        return "main";
    }
}
