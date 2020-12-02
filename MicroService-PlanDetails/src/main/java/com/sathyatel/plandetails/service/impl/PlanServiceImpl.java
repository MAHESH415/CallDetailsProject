package com.sathyatel.plandetails.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyatel.plandetails.dto.PlanDTO;
import com.sathyatel.plandetails.entity.Plan;
import com.sathyatel.plandetails.repository.PlanRepository;
import com.sathyatel.plandetails.service.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private PlanRepository planRepository;

	@Override
	public List<PlanDTO> getAllPlans() {
		List<Plan> planList = planRepository.findAll();
		List<PlanDTO> planDTOList = new ArrayList<>();
		for (Plan plan : planList) {
			PlanDTO planDTO = new PlanDTO();
			BeanUtils.copyProperties(plan, planDTO);
			planDTOList.add(planDTO);
		}
		return planDTOList;
	}

	@Override
	public PlanDTO getSpecificPlan(String planId) {
		PlanDTO planDTO = null;
		Optional<Plan> planEntityOptional = planRepository.findById(planId);
		if (Objects.nonNull(planEntityOptional) && planEntityOptional.isPresent()) {
			planDTO = new PlanDTO();
			BeanUtils.copyProperties(planEntityOptional.get(), planDTO);
			return planDTO;
		}
		return planDTO;
	}
}