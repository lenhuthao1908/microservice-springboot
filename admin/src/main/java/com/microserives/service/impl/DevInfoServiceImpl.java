package com.microserives.service.impl;

import com.microserives.dto.request.CreateDevInfoDto;
import com.microserives.dto.request.UpdateDevInfoDto;
import com.microserives.dto.response.DevInfoDto;
import com.microserives.entity.DevInfoEntity;
import com.microserives.repository.DevInfoRepository;
import com.microserives.service.IDevInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DevInfoServiceImpl
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@Service
@Slf4j
public class DevInfoServiceImpl implements IDevInfoService {
    @Autowired
    private DevInfoRepository devInfoRepository;

    @Override
    public List<DevInfoDto> getAllDev() {
        List<DevInfoEntity> list = devInfoRepository.findAll();
        List<DevInfoDto> result = new ArrayList<>();
        for (DevInfoEntity item : list) {
            DevInfoDto dto = new DevInfoDto();
            dto.setId(item.getId());
            dto.setName(item.getName());
            result.add(dto);
        }
        return result;
    }

    @Override
    public DevInfoDto createDev(CreateDevInfoDto devInfoDto) {
        DevInfoEntity entity = new DevInfoEntity();
        entity.setName(devInfoDto.getName());
        Date nowDate = new Date();
        entity.setCreatedDate(nowDate);
        DevInfoEntity item = devInfoRepository.save(entity);
        DevInfoDto dto = new DevInfoDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        return dto;
    }

    @Override
    public DevInfoDto updateDev(UpdateDevInfoDto devInfoDto) {
        DevInfoEntity entity = devInfoRepository.findById(devInfoDto.getId()).get();
        entity.setName(devInfoDto.getName());
        Date nowDate = new Date();
        entity.setUpdatedDate(nowDate);
        DevInfoEntity item = devInfoRepository.save(entity);
        DevInfoDto dto = new DevInfoDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        return dto;
    }

    @Override
    public DevInfoDto getDevById(Long id) {
        DevInfoEntity entity = devInfoRepository.findById(id).get();
        DevInfoDto dto = new DevInfoDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public void deleteById(Long id) {
        DevInfoEntity entity = devInfoRepository.findById(id).get();
        entity.setDeletedDate(new Date());
        devInfoRepository.save(entity);
    }
}
