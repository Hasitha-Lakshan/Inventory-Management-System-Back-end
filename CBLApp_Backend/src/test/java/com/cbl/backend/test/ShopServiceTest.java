package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.dto.ShopDetailsResponse;
import com.cbl.backend.model.Shops;
import com.cbl.backend.repository.ShopRepository;
import com.cbl.backend.service.ShopService;

@SpringBootTest
public class ShopServiceTest {

	@Autowired
	ShopService shopService;
	
	@MockBean
	private ShopRepository shopRepository;
	
	@Test
	public void getAllShopsTest() {
		
		Shops shop = new Shops();
		ShopDetailsResponse shopResponse = new ShopDetailsResponse();
		
		shopResponse.setShopID(1234);
		shopResponse.setShopName("test_shopName");
		shopResponse.setOwnerFName("test_ownerFName");
		shopResponse.setOwnerLName("test_ownerLName");
		shopResponse.setAddress("test_address");
		shopResponse.setPhoneNumber("test_phoneNumber");
		
		
		when(shopRepository.save(shop)).thenReturn(shop);
		assertEquals(true, shopService.getAllShops());
	}
}