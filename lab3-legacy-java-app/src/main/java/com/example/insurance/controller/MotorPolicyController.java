package com.example.insurance.controller;

import com.example.insurance.dao.MotorPolicyDAO;
import com.example.insurance.model.MotorPolicy;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/policies")
public class MotorPolicyController {

    private final MotorPolicyDAO motorPolicyDAO;

    public MotorPolicyController(MotorPolicyDAO motorPolicyDAO) {
        this.motorPolicyDAO = motorPolicyDAO;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String listPolicies(Model model) {
        model.addAttribute("policies", motorPolicyDAO.findAll());
        return "policy/list";
    }

    @GetMapping("/new")
    public String newPolicyForm(Model model) {
        model.addAttribute("policy", new MotorPolicy());
        return "policy/form";
    }

    @PostMapping
    public String savePolicy(@ModelAttribute MotorPolicy policy) {
        if (policy.getId() == null) {
            motorPolicyDAO.save(policy);
        } else {
            motorPolicyDAO.update(policy);
        }
        return "redirect:/policies";
    }

    @GetMapping("/{id}/edit")
    public String editPolicy(@PathVariable Long id, Model model) {
        model.addAttribute("policy", motorPolicyDAO.findById(id));
        return "policy/form";
    }

    @GetMapping("/{id}/delete")
    public String deletePolicy(@PathVariable Long id) {
        motorPolicyDAO.delete(id);
        return "redirect:/policies";
    }
}