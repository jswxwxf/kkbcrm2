/**
 * 
 */
package com.lichengbao.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lichengbao.domain.common.Region;


/**
 * @author jwang
 *
 */
@Repository
public interface RegionRepository extends BaseRepository<Region, Long> {
	
	List<Region> findByNameCn(String nameCn);
	
}
