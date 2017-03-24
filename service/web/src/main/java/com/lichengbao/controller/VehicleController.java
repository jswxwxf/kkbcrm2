/**
 * 
 */
package com.lichengbao.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lichengbao.domain.common.VehicleModel;
import com.lichengbao.service.VehicleService;

/**
 * @author jwang
 *
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/brands", method = RequestMethod.GET, produces = "application/json")
	public Set<VehicleModel> getBrands() {
		return this.vehicleService.getBrands();
	}
	
}
