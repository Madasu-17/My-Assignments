package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupons;
import com.zensar.service.CouponsService;

@RestController
@RequestMapping(value = "/coupons-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponsController {
	@Autowired
	private CouponsService couponsService;

	@GetMapping("/coupons/{couponId}")
	public Coupons getCoupon(@PathVariable("couponId") int couponId) {
		return couponsService.getCoupon(couponId);
	}

	@GetMapping("/coupons")
	public List<Coupons> getAllCoupons() {
		return couponsService.getAllCoupons();
	}

	@PostMapping("/coupons")
	public void insertCoupon(@RequestBody Coupons coupons) {
		couponsService.insertCoupon(coupons);
	}

	@PutMapping("/coupons/{couponId}")
	public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody Coupons coupons) {
		couponsService.updateCoupon(couponId, coupons);
	}

	@DeleteMapping("/coupons/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponsService.deleteCoupon(couponId);
	}

}
