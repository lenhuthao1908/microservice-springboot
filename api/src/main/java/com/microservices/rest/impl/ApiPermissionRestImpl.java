package com.microservices.rest.impl;

import com.microservices.common.MessageCommon;
import com.microservices.common.RequestMappingCommon;
import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.CreatePermissionDto;
import com.microservices.dto.request.UpdatePermissionDto;
import com.microservices.rest.IApiPermissionRest;
import com.microservices.service.IPermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiPermissionRestImpl
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping(RequestMappingCommon.URL_V1  + RequestMappingCommon.URL_PERMISSION)
@Slf4j
@Transactional(readOnly = true)
public class ApiPermissionRestImpl implements IApiPermissionRest {

    IPermissionService iPermissionService;

    @Override
    @GetMapping(RequestMappingCommon.URL_LIST)
    public ApiResponse findAllPermission() {
        return ApiResponse.builder()
                .data(iPermissionService.findAllPermission())
                .message(MessageCommon.FIND_ALL_SUCCESS)
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_SAVE)
    public ApiResponse createPermission(@RequestBody CreatePermissionDto createPermissionDto) {
        return ApiResponse.builder()
                .data(iPermissionService.createPermission(createPermissionDto))
                .message(MessageCommon.SAVE_SUCCESS)
                .build();
    }

    @Override
    @PutMapping(RequestMappingCommon.URL_UPDATE + RequestMappingCommon.PATH_ID)
    public ApiResponse updatePermission(@PathVariable("id") Long id, @RequestBody UpdatePermissionDto updatePermissionDto) {
        updatePermissionDto.setId(id);
        return ApiResponse.builder()
                .data(iPermissionService.updatePermission(updatePermissionDto))
                .message(MessageCommon.UPDATE_SUCCESS)
                .build();
    }

    @Override
    @GetMapping(RequestMappingCommon.URL_DETAIL + RequestMappingCommon.PATH_ID)
    public ApiResponse findPermissionById(@PathVariable("id") Long id) {
        return ApiResponse.builder()
                .data(iPermissionService.findPermissionById(id))
                .message(MessageCommon.FIND_BY_ID_SUCCESS)
                .build();
    }

    @Override
    @DeleteMapping(RequestMappingCommon.URL_DELETE + RequestMappingCommon.PATH_ID)
    public ApiResponse deletePermission(@PathVariable("id") Long id) {
        iPermissionService.deletePermission(id);
        return ApiResponse.builder()
                .data(null)
                .message(MessageCommon.DELETED_SUCCESS)
                .build();
    }
}
