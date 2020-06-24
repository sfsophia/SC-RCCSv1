package com.example.RCCSv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RCCSv1.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>
{

}