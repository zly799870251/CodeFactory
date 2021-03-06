<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.sdd.api.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdd.api.dao.${className}Mapper;
import com.sdd.api.mapstruct.${className}MapStruct;
import com.sdd.api.dto.${className}Dto;
import com.sdd.api.pojo.${className};

import com.sdd.common.base.BaseService;
import com.sdd.common.core.ErrorTypeEnum;
import com.sdd.common.core.Result;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * ${className} service
 *
 * @author Becypress
 * @date 2019-01-04
 */
@Service
public class ${className}Service extends BaseService {

	@Autowired
	private ${className}Mapper mapper;
	@Autowired
	private ${className}MapStruct mapStruct;

	/**
	 * Create a record
	 *
	 * @param dto Object to be created
	 * @return Execute operation result
	 */
	public Result create(${className}Dto dto){
        Result result = new Result(ErrorTypeEnum.OK);
        dto.setCreateUser(dto.getUserName());
        dto.setUpdateUser(dto.getUserName());
        if (mapper.insert(dto2Pojo(dto)) <= 0) {
            result.setErrorType(ErrorTypeEnum.DELETE_ERROR);
        }
        return result;
	}

	/**
	 * Create a record based on a set of dto
	 *
	 * @param dtoList List to be created
	 * @return Execute operation result
	 */
    public Result create(List<${className}Dto> dtoList){
        Result result = new Result(ErrorTypeEnum.OK);
        boolean answer = true;
        for (${className}Dto dto : dtoList) {
            answer = answer ? create(dto).getStatus() == 0 : false;
        }
        if (!answer) {
            result.setErrorType(ErrorTypeEnum.DELETE_ERROR);
        }
        return result;
	}

	/**
	 * Query record by page
	 *
	 * @param dto Get query conditions from dto
	 * @return Page object of query record
	 */
	public PageInfo<${className}Dto> queryByPage(${className}Dto dto){
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		PageHelper.orderBy(dto.getOrderby());
		List<${className}> pojoList = mapper.query(dto2Pojo(dto));
        List<${className}Dto> dtoList = pojo2Dtos(pojoList);
        PageInfo<${className}> pojoPageInfo = new PageInfo(pojoList);
        PageInfo<${className}Dto> dtoPageInfo = new PageInfo();
        BeanUtils.copyProperties(pojoPageInfo, dtoPageInfo);
        dtoPageInfo.setList(dtoList);
        return dtoPageInfo;
	}

	/**
	 * Query all record
	 *
	 * @param dto Get query conditions from dto
	 * @return List of query record
	 */
	public List<${className}Dto> query(${className}Dto dto){
		return pojo2Dtos(mapper.query(dto2Pojo(dto)));
	}

	/**
	 * Find unique record by id
	 *
	 * @param id The id of the record to find
	 * @return Queryed record object
	 */
	public ${className}Dto findById(Long id){
		return pojo2Dto(mapper.findById(id));
	}

	/**
	 * Update a record by id
	 *
	 * @param dto Object to be updated
	 * @return Execute operation result
	 */
	public Result update(${className}Dto dto) {
        Result result = new Result(ErrorTypeEnum.OK);
        dto.setUpdateUser(dto.getUserName());
		if (mapper.update(dto2Pojo(dto)) <= 0) {
			result.setErrorType(ErrorTypeEnum.DELETE_ERROR);
		}
		return result;
	}

	/**
	 * Update a set of ids for a record
	 *
	 * @param dtoList List to be updated
	 * @return Execute operation result
	 */
	public Result update(List<${className}Dto> dtoList) {
		Result result = new Result(ErrorTypeEnum.OK);
        boolean answer = true;
        for (${className}Dto dto : dtoList) {
            answer = answer ? update(dto).getStatus() == 0 : false;
        }
        if (!answer) {
            result.setErrorType(ErrorTypeEnum.DELETE_ERROR);
        }
		return result;
	}

	/**
	 * Delete a record by id
	 *
	 * @param id         Front end passed id
	 * @param updateUser Front end passed id
	 * @return Execute operation result
	 */
	public Result delete(Long id, String updateUser) {
		Result result = new Result(ErrorTypeEnum.OK);
		if (mapper.delete(id, updateUser) <= 0) {
			result.setErrorType(ErrorTypeEnum.DELETE_ERROR);
		}
		return result;
	}

	/**
	 * Delete a set of ids for a record
	 *
	 * @param dto Front end passed dto
	 * @return Execute operation result
	 */
	public Result delete(List<Long> idList, String updateUser) {
		Result result = new Result(ErrorTypeEnum.OK);
        boolean answer = true;
        for (Long id : idList) {
            answer = answer ? delete(id, updateUser).getStatus() == 0 : false;
        }
        if (!answer) {
            result.setErrorType(ErrorTypeEnum.DELETE_ERROR);
        }
		return result;
	}

	/**
	 * Pojo to dto conversion method
	 *
	 * @param pojo Pojo to be converted
	 * @return Converted operation result
	 */
	public ${className}Dto pojo2Dto(${className} pojo){
		${className}Dto answer = mapStruct.fromPojo2Dto(pojo);
		// todo write json field converte
		return answer;
	}

	/**
	 * Dto to pojo conversion method
	 *
	 * @param dto Dto to be converted
	 * @return Converted operation result
	 */
	public ${className} dto2Pojo(${className}Dto dto) {
		${className} answer = mapStruct.fromDto2Pojo(dto);
		// todo write json field converte
		return answer;
	}

	/**
	 * Pojo to dto conversion method
	 *
	 * @param pojoList Pojo list to be converted
	 * @return Converted operation result
	 */
	public List<${className}Dto> pojo2Dtos(List<${className}> pojoList){
		List<${className}Dto> answer = new LinkedList<>();
		for (${className} pojo : pojoList){
			answer.add(pojo2Dto(pojo));
		}
		return answer;
	}

	/**
	 * Pojos to dtos conversion method
	 *
	 * @param dtoList Dto list to be converted
	 * @return Converted operation result
	 */
	public List<${className}> dto2Pojos(List<${className}Dto> dtoList){
		List<${className}> answer = new LinkedList<>();
		for (${className}Dto dto : dtoList){
			answer.add(dto2Pojo(dto));
		}
		return answer;
	}
}
