package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.dto.LorryInfoUpdateRequest;
import com.cbl.backend.dto.LorryRequest;
import com.cbl.backend.dto.SetAccountStatusRequest1;
import com.cbl.backend.model.Lorry;
import com.cbl.backend.repository.LorryRepository;
import com.cbl.backend.service.LorryService;



@SpringBootTest
public class LorryServiceTest {
	
	@Autowired
	LorryService lorryService;
	
	@MockBean
	private LorryRepository lorryRepository;
	
	@Test
    public void addlorryTest() {
		
		Lorry lorry = new Lorry();
		LorryRequest rq = new LorryRequest();
		
		rq.setFirstName("test_firstName");
		rq.setLastName("test_lastName");
		rq.setPhonenumber(778869697);
	
		when(lorryRepository.save(lorry)).thenReturn(lorry);
		assertEquals(true, lorryService.add(rq));
	}
	
	@Test
	public void getAllLorries() {
		
		List<Lorry> lorries=new ArrayList<Lorry>();
		Lorry lorry = new Lorry();
		
		lorry.setFirstName("firstName");
		lorry.setLastName("lastName");
		lorry.setPhonenumber(778869699);
		lorries.add(lorry);
		when(lorryRepository.findAll()).thenReturn(lorries);
		assertEquals(1,lorryService.getAllLorries().size());
		
	}

	
	@Test
	public void updateLorryInfotest() {
		LorryInfoUpdateRequest rq=new LorryInfoUpdateRequest();
		rq.setFirstName("firstName");
		rq.setLastName("lastName");
		rq.setPhonenumber(779625905);
		
		
		Lorry lorry=new Lorry();
		lorry.setFirstName("firstNamenew");
		lorry.setLastName("lastNamenew");
		lorry.setPhonenumber(779625900);
		
		when(lorryRepository.findByLorryID(rq.getLorryID())).thenReturn(lorry);
		assertEquals(true,lorryService.updateLorryInfo(rq));
	}
	
	@Test
	public void setAccountStatusTest() {
		SetAccountStatusRequest1 rq=new SetAccountStatusRequest1();
		rq.setLorryID(1);
		rq.setAccountStatus(true);

		Lorry lorry = new Lorry();
		lorry.setFirstName("firstName");
		lorry.setLastName("lastName");
		lorry.setPhonenumber(779625905);
		lorry.setAccountStatus(false);
		
		
		when(lorryRepository.findByLorryID(rq.getLorryID())).thenReturn(lorry);
		assertEquals(true,lorryService.setAccountStatus(rq));
		System.out.println(lorry.isAccountStatus());
		
		
	}
}

