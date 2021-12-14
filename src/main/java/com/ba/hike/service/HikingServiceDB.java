package com.ba.hike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.hike.domain.Hiking;
import com.ba.hike.repo.HikingRepo;



@Service
public class HikingServiceDB implements HikingService {

	private HikingRepo repo;

	@Autowired
	public HikingServiceDB(HikingRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Hiking createHill(Hiking hills) {
		Hiking created = this.repo.save(hills);
		return created;
	}

	@Override
	public List<Hiking> getAllHills() {
		return this.repo.findAll();
	}

	@Override
	public Hiking getHill(Integer id) {
		Optional<Hiking> found = this.repo.findById(id);
		return found.get();
	}


	
	@Override
	public List<Hiking> getByMountainName(String mountainName) {
		return this.repo.findByMountainNameIgnoreCase(mountainName);
	}

	@Override
	public List<Hiking> getByRegion(String region) {
		return this.repo.findByRegionIgnoreCase(region);
	}

	@Override
	public List<Hiking> getByCountry(String country) {
		return this.repo.findByCountryIgnoreCase(country);
	}

	@Override
	public Hiking replaceHill(Integer id, Hiking newHill) {
		Hiking existing = this.repo.findById(id).get();

		existing.setId(newHill.getId());
		existing.setMountainName(newHill.getMountainName());
		existing.setRegion(newHill.getRegion());
		existing.setHeight(newHill.getHeight());
		existing.setCountry(newHill.getCountry());

		Hiking updated = this.repo.save(existing);

		return updated;
	}

	@Override
	public void deleteHill(Integer id) {
		this.repo.deleteById(id);

	}

	

}
