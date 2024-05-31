package com.microserives.service;

import com.microserives.dto.request.CreateDevInfoDto;
import com.microserives.dto.request.UpdateDevInfoDto;
import com.microserives.dto.response.DevInfoDto;

import java.util.List;

/**
 * IDevInfoService
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
public interface IDevInfoService {
    List<DevInfoDto> getAllDev();
    DevInfoDto createDev(CreateDevInfoDto devInfoDto);
    DevInfoDto updateDev(UpdateDevInfoDto devInfoDto);
    DevInfoDto getDevById(Long id);
    void deleteById(Long id);
}
