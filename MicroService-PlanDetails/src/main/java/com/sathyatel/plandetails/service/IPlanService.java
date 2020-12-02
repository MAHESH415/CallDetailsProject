package com.sathyatel.plandetails.service;

import java.util.List;

import com.sathyatel.plandetails.dto.PlanDTO;

public interface IPlanService {

	List<PlanDTO> getAllPlans();

	PlanDTO getSpecificPlan(String planId);
}
