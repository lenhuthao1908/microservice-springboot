package com.microserives.service.impl;

import com.microserives.dto.CreateDevInfoDto;
import com.microserives.dto.UpdateDevInfoDto;
import com.microserives.entity.DevInfoEntity;
import com.microserives.repository.DevInfoRepository;
import com.microserives.service.IDevInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<DevInfoEntity> getAllDev() {
        return devInfoRepository.findAll();
    }

    @Override
    public DevInfoEntity createDev(CreateDevInfoDto devInfoDto) {
        DevInfoEntity entity = new DevInfoEntity();
        entity.setName(devInfoDto.getName());
        Date nowDate = new Date();
        entity.setCreatedDate(nowDate);
        return devInfoRepository.save(entity);
    }

    @Override
    public DevInfoEntity updateDev(UpdateDevInfoDto devInfoDto) {
        DevInfoEntity entity = devInfoRepository.findById(devInfoDto.getId()).get();
        entity.setName(devInfoDto.getName());
        Date nowDate = new Date();
        entity.setUpdatedDate(nowDate);
        return devInfoRepository.save(entity);
    }

    @Override
    public DevInfoEntity getDevById(Long id) {
        return devInfoRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        devInfoRepository.deleteById(id);
    }
}
