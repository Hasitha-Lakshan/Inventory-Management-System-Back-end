package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.model.Shops;
import com.cbl.backend.repository.ShopRepository;
import com.cbl.backend.service.ShopService;

@SpringBootTest
public class ShopServiceTest {

	@Autowired
	private ShopService shopService;
	@MockBean
	private ShopRepository shopRepository;
	
	@Test
	public void getAllShops() {
		
		List<Shops> shops=new ArrayList<Shops>();
		
		Shops shop = new Shops();
		shop.setShopID(11111);
		shop.setShopName("shopName");
		shop.setOwnerFName("ownerFName");
		shop.setOwnerLName("ownerLName");
		shop.setAddress("address");
		shop.setPhoneNumber("phoneNumber");
		
		shops.add(shop);
		when(shopRepository.findAll()).thenReturn(shops);
		assertEquals(1,shopService.getAllShops().size());
		
	}
	
	@Test
	public void getShopTest() {
		
		List<Shops> shops=new ArrayList<Shops>();
		
		Shops shop = new Shops();
		shop.setShopID(11111);
		shop.setShopName("shopName");
		shop.setOwnerFName("ownerFName");
		shop.setOwnerLName("ownerLName");
		shop.setAddress("address");
		shop.setPhoneNumber("phoneNumber");
		
		shops.add(shop);
		String shopName="polgahawela";
		when(shopRepository.findByShopName(shopName)).thenReturn(shops);
		assertEquals(1,shopService.getShop(shopName).size());
	}
	
}
