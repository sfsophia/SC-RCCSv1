package com.example.RCCSv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.RCCSv1.entity.Complaint;
import com.example.RCCSv1.repository.ComplaintRepository;
import com.example.RCCSv1.service.ComplaintService;
import com.example.RCCSv1.service.ComplaintServiceImpl;

@Controller
public class ComplaintController {
    @Autowired
    ComplaintRepository cmpRepo;
    @Autowired
    ComplaintService cmpService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("complaints", cmpRepo.findAll());
        return "index";
    }

    @GetMapping("/showNewComplaintForm")
    public String showNewComplaintForm(Model model) {
        Complaint complaint = new Complaint();
        model.addAttribute("complaint", complaint);
        return "newcomplaint";
    }

    @PostMapping("/createComplaint")
    public String createComplaint(@ModelAttribute("complaint") Complaint complaint) {
        complaint.setStatus("New");
       // complaint.setAction("-");
        cmpService.createComplaint(complaint);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
        Complaint complaint = cmpService.getComplaintById(id);
        model.addAttribute("complaint", complaint);
        return "updatecomplaint";
    }

    @GetMapping("/viewComplaint/{id}")
    public String viewComplaint(@PathVariable(value = "id") Integer id, Model model) {
        Complaint complaint = cmpService.getComplaintById(id);
        model.addAttribute("complaint", complaint);
        return "viewcomplaint";
    }

    @PostMapping("/updateComplaint")
    public String updateComplaint(Complaint complaint) {
        cmpService.updateComplaint(complaint);
        return "redirect:/";
    }

    
    @GetMapping("/deleteComplaint/{id}")
    public String deleteComplaint(@PathVariable(value = "id") Integer id) {
        this.cmpService.deleteComplaintById(id);
        return "redirect:/";
    }
}