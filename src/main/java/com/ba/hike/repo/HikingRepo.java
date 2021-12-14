package com.ba.hike.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.hike.domain.Hiking;


	@Repository
	public interface HikingRepo extends JpaRepository<Hiking, Integer> {
		
		List<Hiking> findByMountainNameIgnoreCase(String mountainName);
		
		List<Hiking> findByRegionIgnoreCase(String region);

		List<Hiking> findByCountryIgnoreCase(String country);


}
