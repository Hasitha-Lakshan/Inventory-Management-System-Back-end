package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cbl.backend.dto.SetAccountStatusRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;
import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.Admin;
import com.cbl.backend.model.Analyzer;
import com.cbl.backend.model.CashCollector;
import com.cbl.backend.model.InventoryManager;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.AdminRepository;
import com.cbl.backend.repository.AnalyzerRepository;
import com.cbl.backend.repository.CashCollectorRepository;
import com.cbl.backend.repository.InventoryManagerRepository;
import com.cbl.backend.repository.PhoneNumberRepository;
import com.cbl.backend.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AnalyzerRepository analyzerRepository;
	@Autowired
	private CashCollectorRepository cashCollectorRepository;
	@Autowired
	private InventoryManagerRepository inventoryManagerRepository;
	@Autowired
	private PhoneNumberRepository phonenumberRepository;

	public List<UserDetailsResponse> getAllUsers() {

		List<User> users = userRepository.findAll();

		return users.stream().map(this::mapFromUserToDto).collect(Collectors.toList());
	}

	private UserDetailsResponse mapFromUserToDto(User user) {

		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();

		userDetailsResponse.setUserID(user.getUserID());
		userDetailsResponse.setFirstName(user.getFirstName());
		userDetailsResponse.setLastName(user.getLastName());
		userDetailsResponse.setRole(user.getRole());
		userDetailsResponse.setUsername(user.getUsername());
		userDetailsResponse.setAccountStatus(user.isAccountStatus());
		userDetailsResponse.setAddressLine1(user.getAddressLine1());
		userDetailsResponse.setAddressLine2(user.getAddressLine2());
		userDetailsResponse.setAddressLine3(user.getAddressLine3());
		userDetailsResponse.setPhoneNumbers(user.getPhoneNumbers());

		return userDetailsResponse;
	}

	public boolean updateUserInfo(UserInfoUpdateRequest rq) {

		User user = userRepository.findByusername(rq.getUsername());
		
		if (user != null) {

			// UPDATE ROLE TABLES /////////////////////////////////////////////////////
			if (!user.getRole().equals(rq.getRole())) {

				if (rq.getRole().equals("ADMIN")) {
					Admin admin = new Admin();
					admin.setUser(user);
					adminRepository.save(admin);
					

				} else if (rq.getRole().equals("ANALYZER")) {

					Analyzer analyzer = new Analyzer();
					analyzer.setUser(user);
					analyzerRepository.save(analyzer);

				} else if (rq.getRole().equals("INVENTORY_MANAGER")) {

					InventoryManager inventoryManager = new InventoryManager();
					inventoryManager.setUser(user);
					inventoryManagerRepository.save(inventoryManager);

				} else if (rq.getRole().equals("CASH_COLLECTOR")) {

					CashCollector cashCollector = new CashCollector();
					cashCollector.setUser(user);
					cashCollectorRepository.save(cashCollector);
				}

				// DELETE EXSISTING ROLE ID ////////////////////////////////////////////////
				if (user.getRole().equals("ADMIN")) {

					Admin admin = adminRepository.findByuser(user);
					admin.setUser(null);
					adminRepository.save(admin);
				}

				else if (user.getRole().equals("ANALYZER")) {

					Analyzer analyzer = analyzerRepository.findByuser(user);
					analyzer.setUser(null);
					analyzerRepository.save(analyzer);
				}

				else if (user.getRole().equals("INVENTORY_MANAGER")) {

					InventoryManager inventoryManager = inventoryManagerRepository.findByuser(user);
					inventoryManager.setUser(null);
					inventoryManagerRepository.save(inventoryManager);
				}

				else if (user.getRole().equals("CASH_COLLECTOR")) {

					CashCollector cashCollector = cashCollectorRepository.findByuser(user);
					cashCollector.setUser(null);
					cashCollectorRepository.save(cashCollector);
				}
			}
			

			user.setFirstName(rq.getFirstName());
			user.setLastName(rq.getLastName());
			user.setAddressLine1(rq.getAddressLine1());
			user.setAddressLine2(rq.getAddressLine2());
			user.setAddressLine3(rq.getAddressLine3());

			
					
			List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();
			
			for (PhoneNumber phonenumber : rq.getPhoneNumbers()) {

				PhoneNumber phoneNumber = new PhoneNumber();

				phoneNumber.setPhoneType(phonenumber.getPhoneType());
				phoneNumber.setPhoneNumber(phonenumber.getPhoneNumber());
				phoneNumber.setUser(user);
				phoneList.add(phoneNumber);
			}
			
			user.setPhoneNumbers(phoneList);
			
			userRepository.save(user);
			return true;

		} else {
			return false;
		}

	}

	
	

	public boolean setAccountStatus(SetAccountStatusRequest rq) {

		User user = userRepository.findByusername(rq.getUsername());

		if (user != null) {

			user.setAccountStatus(rq.isAccountStatus());
			userRepository.save(user);
			return true;
		} else {
			return false;
		}

	}

	public boolean deleteUser(String username) {

		User user = userRepository.findByusername(username);

		if (user != null) {

			Admin admin = adminRepository.findByuser(user);
			Analyzer analyzer = analyzerRepository.findByuser(user);
			CashCollector cashcollector = cashCollectorRepository.findByuser(user);
			InventoryManager inventoryManager = inventoryManagerRepository.findByuser(user);

			if (admin != null) {

				admin.setAdminID(admin.getAdminID());
				admin.setUser(null);
				adminRepository.save(admin);
				userRepository.deleteById(user.getUserID());

			}

			if (analyzer != null) {

				analyzer.setAnalyzerID(analyzer.getAnalyzerID());
				analyzer.setUser(null);
				analyzerRepository.save(analyzer);
				userRepository.deleteById(user.getUserID());

			}

			if (cashcollector != null) {

				cashcollector.setCashCollectorID(cashcollector.getCashCollectorID());
				cashcollector.setUser(null);
				cashCollectorRepository.save(cashcollector);
				userRepository.deleteById(user.getUserID());

			}

			if (inventoryManager != null) {

				inventoryManager.setInventoryManagerID(inventoryManager.getInventoryManagerID());
				inventoryManager.setUser(null);
				inventoryManagerRepository.save(inventoryManager);
				userRepository.deleteById(user.getUserID());

			}

			phonenumberRepository.deleteByuser(user);

			return true;

		} else {
			return false;
		}
	}

}