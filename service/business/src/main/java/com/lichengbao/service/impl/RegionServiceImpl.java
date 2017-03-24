/**
 * 
 */
package com.lichengbao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichengbao.domain.common.Region;
import com.lichengbao.repository.RegionRepository;
import com.lichengbao.service.RegionService;

/**
 * @author jwang
 *
 */
@Service("regionService")
@Transactional
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private RegionRepository regionRepository;

	/* (non-Javadoc)
	 * @see com.lichengbao.service.RegionService#getRegions()
	 */
	@Override
	public List<Region> getRegions() {
		return this.regionRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.service.RegionService#getRegion(java.lang.Integer)
	 */
	@Override
	public Region getRegion(Long id) {
		return this.regionRepository.findOneExist(id);
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.service.RegionService#createRegion(com.lichengbao.domain.Region)
	 */
	@Override
	public Region saveRegion(Region region) {
		return this.regionRepository.save(region);
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.service.RegionService#deleteRegion(java.lang.Integer)
	 */
	@Override
	public void deleteRegion(Long code) {
		this.regionRepository.delete(code);
	}


}
