package com.example.RCCSv1.service;
import java.util.List;
import com.example.RCCSv1.entity.Complaint;
public interface ComplaintService {

	List<Complaint> getAllComplaints();
	void createComplaint(Complaint complaint);
	Complaint updateComplaint(Complaint complaint);
	Complaint getComplaintById(Integer id);
	void deleteComplaintById(Integer id);
}
