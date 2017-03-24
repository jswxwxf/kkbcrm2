/**
 * 
 */
package com.lichengbao.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichengbao.domain.common.VehicleModel;
import com.lichengbao.repository.VehicleModelRepository;
import com.lichengbao.service.VehicleService;

/**
 * @author jwang
 *
 */
@Service("vehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	/* (non-Javadoc)
	 * @see com.lichengbao.service.VehicleService#getBrands()
	 */
	@Override
	public Set<VehicleModel> getBrands() {
		Set<VehicleModel> brands = this.vehicleModelRepository.getBrands();
		return brands;
	}
	
}
