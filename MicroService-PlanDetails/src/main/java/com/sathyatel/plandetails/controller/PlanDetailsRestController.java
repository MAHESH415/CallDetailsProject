package com.sathyatel.plandetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatel.plandetails.dto.PlanDTO;
import com.sathyatel.plandetails.service.IPlanService;

@RestController
public class PlanDetailsRestController {

	@Autowired
	private IPlanService iPlanService;

	@GetMapping("/allPlans")
	public List<PlanDTO> getAllPlanDetails() {
		return iPlanService.getAllPlans();
	}

	@GetMapping("/{planId}")
	public PlanDTO getPlanById(@PathVariable String planId) {
		return iPlanService.getSpecificPlan (planId);
	}
}
