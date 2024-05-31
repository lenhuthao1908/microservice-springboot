package com.microserives.rest;

import com.microserives.dto.request.CreateDevInfoDto;
import com.microserives.dto.request.UpdateDevInfoDto;
import com.microserives.dto.response.DevInfoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * DevInfoRest
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
public interface DevInfoRest {
    ResponseEntity<List<DevInfoDto>> getAllDev();
    ResponseEntity<DevInfoDto> createDev(CreateDevInfoDto devInfoDto);
    ResponseEntity<DevInfoDto> updateDev(Long id, UpdateDevInfoDto devInfoDto);
    ResponseEntity<DevInfoDto> getDevById(Long id);
    void deleteById(Long id);
}
