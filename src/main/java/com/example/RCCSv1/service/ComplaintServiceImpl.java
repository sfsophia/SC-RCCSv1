package com.example.RCCSv1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RCCSv1.service.ComplaintService;
import com.example.RCCSv1.entity.Complaint;
import com.example.RCCSv1.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository cmpRepository;

    @Override
    public List<Complaint> getAllComplaints() {
        return cmpRepository.findAll();
    }

    @Override
    public void createComplaint(Complaint complaint) {
        this.cmpRepository.save(complaint);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return cmpRepository.save(complaint);
    }

    @Override
    public Complaint getComplaintById(Integer id) {
        Optional<Complaint> optional = cmpRepository.findById(id);
        Complaint complaint = null;
        if (optional.isPresent()) {
            complaint = optional.get();
        } else {
            throw new RuntimeException(" Complaint is not found. Details : id :: " + id);
        }
        return complaint;
    }

    @Override
    public void deleteComplaintById(Integer id) {
     this.cmpRepository.deleteById(id);
    }

}