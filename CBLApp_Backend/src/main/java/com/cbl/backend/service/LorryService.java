package com.cbl.backend.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.LorryInfoUpdateRequest;
import com.cbl.backend.dto.LorryRequest;
import com.cbl.backend.dto.LorryResponse;
import com.cbl.backend.dto.SetAccountStatusRequest1;
import com.cbl.backend.model.Lorry;
import com.cbl.backend.repository.LorryRepository;


@Service
public class LorryService {
	
	@Autowired
	private LorryRepository lorryRepository;
	
	public boolean add(LorryRequest lorryRequest) {

		Lorry lorry = new Lorry();
		
	        lorry.setFirstName(lorryRequest.getFirstName());
			lorry.setLastName(lorryRequest.getLastName());
			lorry.setPhonenumber(lorryRequest.getPhonenumber());
			
	
			lorryRepository.save(lorry);
			
			return true;
		}
	
	

public List<LorryResponse> getAllLorries() {
		
		List<Lorry> lorries = lorryRepository.findAll();
		
		return lorries.stream().map(this::mapFromLorryToDto).collect(Collectors.toList());
	}

	private LorryResponse mapFromLorryToDto(Lorry lorry) {
		
		LorryResponse lorryResponse = new LorryResponse();

		lorryResponse.setLorryID(lorry.getLorryID());
		lorryResponse.setFirstName(lorry.getFirstName());
		lorryResponse.setLastName(lorry.getLastName());
		lorryResponse.setPhonenumber(lorry.getPhonenumber());
		
		
		return lorryResponse;
	}
	
	
public boolean updateLorryInfo(LorryInfoUpdateRequest rq) {
		
		Lorry lorry = lorryRepository.findByLorryID(rq.getLorryID()).orElse(null);
		
		if(lorry!=null) {
			
			/* Updatable attributes */
			lorry.setFirstName(rq.getFirstName());
			lorry.setLastName(rq.getLastName());
			lorry.setPhonenumber(rq.getPhonenumber());
			
			/* Non updatable attributes */
            lorry.setLorryID(rq.getLorryID());
			
			
			lorryRepository.save(lorry);
			return true;
			
		}else {
			return false;
		}
			
	}


public boolean setAccountStatus(SetAccountStatusRequest1 rq) {
	
	Lorry lorry = lorryRepository.findByLorryID(rq.getLorryID()).orElse(null);
	
	if(lorry!=null) {
		
		lorry.setAccountStatus(rq.isAccountStatus());			
		lorryRepository.save(lorry);
		return true;
	}else {
		return false;
	}
	
		
}
	
	
	}



