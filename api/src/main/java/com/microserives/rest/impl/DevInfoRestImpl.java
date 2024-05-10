package com.microserives.rest.impl;

import com.microserives.dto.CreateDevInfoDto;
import com.microserives.dto.UpdateDevInfoDto;
import com.microserives.entity.DevInfoEntity;
import com.microserives.rest.DevInfoRest;
import com.microserives.service.IDevInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DevInfoRestImpl
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@RestController
@RequestMapping("api/dev")
public class DevInfoRestImpl implements DevInfoRest {

    @Autowired
    private IDevInfoService iDevInfoService;

    @Override
    @GetMapping("")
    public ResponseEntity<List<DevInfoEntity>> getAllDev() {
        return new ResponseEntity<>(this.iDevInfoService.getAllDev(), HttpStatus.OK);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<DevInfoEntity> createDev(@RequestBody CreateDevInfoDto devInfoDto) {
        return new ResponseEntity<>(this.iDevInfoService.createDev(devInfoDto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DevInfoEntity> updateDev(@PathVariable(name = "id") Long id, @RequestBody UpdateDevInfoDto devInfoDto) {
        devInfoDto.setId(id);
        return new ResponseEntity<>(this.iDevInfoService.updateDev(devInfoDto), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DevInfoEntity> getDevById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(this.iDevInfoService.getDevById(id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        this.iDevInfoService.deleteById(id);
    }
}
