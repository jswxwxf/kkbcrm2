/**
 * 
 */
package com.lichengbao.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.lichengbao.domain.common.VehicleModel;

/**
 * @author jwang
 *
 */
@Repository
public interface VehicleModelRepository extends BaseRepository<VehicleModel, Long>, VehicleModelRepositoryEx {
	
	Set<VehicleModel> findByPid(Long pid);
	
//	@Query("SELECT v.id, v.nameCn, v.nameEn, v.py FROM VehicleModel v WHERE v.parent is null")
//	Set<VehicleModel> getBrands();
	
}
