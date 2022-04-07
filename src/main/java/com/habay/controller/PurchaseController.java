package com.habay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habay.request.PurchaseServiceRequest;
import com.habay.security.UserPrincipal;

@RestController
@RequestMapping("gateway/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseServiceRequest purchaseServiceRequest;
	
	@PostMapping
	public ResponseEntity<?> savePurchase(@RequestBody Object purchase){
		return new ResponseEntity<>
		(purchaseServiceRequest.savePurchase(purchase),HttpStatus.CREATED);
	}
	

	
	@GetMapping
	public ResponseEntity<?> getAllPurchasesOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
		return ResponseEntity.ok( purchaseServiceRequest.getAllPurchasesOfUser(userPrincipal.getId()));
		
	}

}
