package com.habay.request;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "course-service" // name of course service application
,path= "/api/purchase", // prepath for service service
//,url ="${purchase.service.url}",commented out cos weare using eureka discovery
configuration = FeignConfiguration.class)
public interface PurchaseServiceRequest {
@PostMapping
	Object savePurchase(@RequestBody Object requestBody);
@GetMapping("{userId}")
List<Object> getAllPurchasesOfUser(@PathVariable("userId")Long userId);
}
