package com.microserives.rest;

import com.microserives.dto.CreateDevInfoDto;
import com.microserives.dto.UpdateDevInfoDto;
import com.microserives.entity.DevInfoEntity;
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
    ResponseEntity<List<DevInfoEntity>> getAllDev();
    ResponseEntity<DevInfoEntity> createDev(CreateDevInfoDto devInfoDto);
    ResponseEntity<DevInfoEntity> updateDev(Long id, UpdateDevInfoDto devInfoDto);
    ResponseEntity<DevInfoEntity> getDevById(Long id);
    void deleteById(Long id);
}
