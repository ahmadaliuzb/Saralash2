package com.saralash2.demo.service;

import com.saralash2.demo.dto.ApiResponse;
import com.saralash2.demo.dto.RegionDto;
import com.saralash2.demo.entity.Region;
import com.saralash2.demo.repository.RegionRepository;
import com.saralash2.demo.service.impl.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 06/07/2023 - 11:02 PM
 * Created by Akhmadali
 */

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;


    @Override
    public ApiResponse create(RegionDto regionDto) {

        Region region=new Region();
        region.setName(regionDto.getName());

        regionRepository.save(region);

        return new ApiResponse("Successfully created",true);
    }

    @Override
    public ApiResponse readAll() {

        return new ApiResponse(regionRepository.findAll(),true);
    }

    @Override
    public ApiResponse readById(Integer id) {

        Optional<Region> optionalRegion = regionRepository.findById(id);

        return optionalRegion.map(region -> new ApiResponse(region,true)).orElseGet(() -> new ApiResponse("Region not found",false));
    }

    @Override
    public ApiResponse update(Integer id, RegionDto regionDto) {

        Optional<Region> optionalRegion = regionRepository.findById(id);

        if(!optionalRegion.isPresent()){
            return new ApiResponse("Region not found",false);
        }

        Region region=optionalRegion.get();
        region.setName(regionDto.getName());

        regionRepository.save(region);

        return new ApiResponse("Successfully updated",true);

    }

    @Override
    public ApiResponse delete(Integer id) {

        Optional<Region> optionalRegion = regionRepository.findById(id);

        if(!optionalRegion.isPresent()){
            return new ApiResponse("Region not found",false);
        }

        regionRepository.deleteById(id);

        return new ApiResponse("Successfully deleted",true);
    }
}
