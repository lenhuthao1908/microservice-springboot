package com.microservices.rest.impl;

import com.microservices.common.MessageCommon;
import com.microservices.common.RequestMappingCommon;
import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.CreateRoleDto;
import com.microservices.dto.request.UpdateRoleDto;
import com.microservices.rest.IApiRoleRest;
import com.microservices.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiRoleRestImpl
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping(RequestMappingCommon.URL_V1  + RequestMappingCommon.URL_ROLE)
@Slf4j
public class ApiRoleRestImpl implements IApiRoleRest {

    IRoleService iRoleService;
    @Override
    @GetMapping(RequestMappingCommon.URL_LIST)
    public ApiResponse findAllRole() {
        return ApiResponse.builder()
                .data(iRoleService.findAllRole())
                .message(MessageCommon.FIND_ALL_SUCCESS)
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_SAVE)
    public ApiResponse createRole(@RequestBody CreateRoleDto createRoleDto) {
        return ApiResponse.builder()
                .data(iRoleService.createRole(createRoleDto))
                .message(MessageCommon.SAVE_SUCCESS)
                .build();
    }

    @Override
    @PutMapping(RequestMappingCommon.URL_UPDATE + RequestMappingCommon.PATH_ID)
    public ApiResponse updateRole(@PathVariable("id") Long id, @RequestBody UpdateRoleDto updateRoleDto) {
        updateRoleDto.setId(id);
        return ApiResponse.builder()
                .data(iRoleService.updateRole(updateRoleDto))
                .message(MessageCommon.UPDATE_SUCCESS)
                .build();
    }

    @Override
    @GetMapping(RequestMappingCommon.URL_DETAIL + RequestMappingCommon.PATH_ID)
    public ApiResponse findRoleById(@PathVariable("id") Long id) {
        return ApiResponse.builder()
                .data(iRoleService.findRoleById(id))
                .message(MessageCommon.FIND_BY_ID_SUCCESS)
                .build();
    }

    @Override
    @DeleteMapping(RequestMappingCommon.URL_DELETE + RequestMappingCommon.PATH_ID)
    public ApiResponse deleteRole(@PathVariable("id") Long id) {
        iRoleService.deleteRole(id);
        return ApiResponse.builder()
                .data(null)
                .message(MessageCommon.DELETED_SUCCESS)
                .build();
    }
}
