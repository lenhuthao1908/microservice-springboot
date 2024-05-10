package com.microserives.service;

import com.microserives.dto.CreateDevInfoDto;
import com.microserives.dto.UpdateDevInfoDto;
import com.microserives.entity.DevInfoEntity;

import java.util.List;

/**
 * IDevInfoService
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
public interface IDevInfoService {
    List<DevInfoEntity> getAllDev();
    DevInfoEntity createDev(CreateDevInfoDto devInfoDto);
    DevInfoEntity updateDev(UpdateDevInfoDto devInfoDto);
    DevInfoEntity getDevById(Long id);
    void deleteById(Long id);
}
