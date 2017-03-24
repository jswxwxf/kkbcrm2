/**
 * 
 */
package com.lichengbao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lichengbao.domain.common.Region;
import com.lichengbao.service.RegionService;

/**
 * @author jwang
 *
 */
@RestController
@RequestMapping("/regions")
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Region> getRegions() {
		return this.regionService.getRegions();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Region getRegion(@PathVariable Long id) {
		return this.regionService.getRegion(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Region saveRegion(@RequestBody @Valid Region region) {
		return this.regionService.saveRegion(region);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteRegion(@PathVariable Long id) {
		this.regionService.deleteRegion(id);
	}
	
}
