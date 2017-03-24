/**
 * 
 */
package com.lichengbao.service;

import java.util.List;

import com.lichengbao.domain.common.Region;


/**
 * @author jwang
 *
 */
public interface RegionService {

	List<Region> getRegions();
	
	Region getRegion(Long id);
	
	Region saveRegion(Region region);
	
	void deleteRegion(Long id);
	
}
