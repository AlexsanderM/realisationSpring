package com.malov.controller;

import com.malov.domain.Service;
import com.malov.domain.User;
import com.malov.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/")
    public String user(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Service> services = serviceRepository.findAll();
        model.put("services" , services);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String service,
            @RequestParam Integer kratnost, Map<String, Object> model) {

        Service serviceDomain = new Service(service, kratnost, user);
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
