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
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Service> services = serviceRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            services = serviceRepository.findByService(filter);
        } else {
            services = serviceRepository.findAll();
        }

        model.addAttribute("services", services);
        model.addAttribute("filter" , filter);

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
}
