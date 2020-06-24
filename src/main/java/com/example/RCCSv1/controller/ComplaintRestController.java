package com.example.RCCSv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RCCSv1.entity.Complaint;
import com.example.RCCSv1.exception.ComplaintNotFoundException;
import com.example.RCCSv1.repository.ComplaintRepository;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintRestController {

	@Autowired
	private ComplaintRepository cmpRepo;

	@GetMapping
	public List<Complaint> getAllComplaints() {
		return this.cmpRepo.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Complaint> deleteComplaint(@PathVariable("id") Integer cmpId) {
		Complaint existingCmp = this.cmpRepo.findById(cmpId).orElseThrow(
				() -> new ComplaintNotFoundException("Complaint with the following id is not found :" + cmpId));
		this.cmpRepo.delete(existingCmp);
		return ResponseEntity.ok().build();
	}
}