<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web;

import com.github.pagehelper.PageInfo;
import com.sdd.api.dto.${className}Dto;
import com.sdd.api.service.${className}Service;
import com.sdd.common.base.BaseController;
import com.sdd.common.core.ApiPageResult;
import com.sdd.common.core.ApiResult;
import com.sdd.common.core.ErrorTypeEnum;
import com.sdd.common.core.Result;
import com.sdd.common.util.PageUtils;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${className} controller
 *
 * @author zhangly
 * @date 2019-01-01
 */
@RestController
@RequestMapping(value = "/${classNameLower}")
public class ${className}Controller extends BaseController{

	@Autowired
	private ${className}Service service;

	/**
	 * Query record list by page
	 *
	 * @param dto Dto from the front end
	 * @return Return to the result object of the web
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiPageResult<${className}Dto> query(@ModelAttribute ${className}Dto dto) {
		ApiPageResult<${className}Dto> result = new ApiPageResult<>(ErrorTypeEnum.OK);
		PageInfo<${className}Dto> page = service.queryByPage(dto);
		PageUtils.toApiPageResult(result, page);
		return result;
	}

	/**
	 * Find single record
	 *
	 * @param id      The id of the record to find
	 * @return Return to the result object of the web
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResult<${className}Dto> findById(@PathVariable("id") Long id){
		ApiResult<${className}Dto> result = new ApiResult<>(ErrorTypeEnum.OK);
		${className}Dto dto = service.findById(id);
		result.setData(dto);
		return result;
	}

	/**
	 * Create a record
	 *
	 * @param dto     Object to be created
	 * @return Return to the result object of the web
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResult<Void> add(@RequestBody ${className}Dto dto) {
		ApiResult<Void> result = new ApiResult<>(ErrorTypeEnum.OK);
		Result serviceResult = service.create(dto);
		result.setResult(serviceResult);
		return result;
	}

	/**
	 * Update a record by id
	 *
	 * @param id      The id of the record to updated
	 * @param dto     Object to be updated
	 * @return Return to the result object of the web
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResult<Void> update(@PathVariable("id") Long id,
											@RequestBody ${className}Dto dto) {
		ApiResult<Void> result = new ApiResult<>(ErrorTypeEnum.OK);
		Result serviceResult = service.update(dto);
		result.setResult(serviceResult);
		return result;
	}

	/**
	 * Delete a set of ids for a record
	 *
	 * @param dto     Front end passed dto
	 * @return Return to the result object of the web
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResult<Void> delete(@RequestBody ${className}Dto dto) {
		ApiResult<Void> result = new ApiResult<>(ErrorTypeEnum.OK);
		Result serviceResult = service.delete(dto.getIdList(), dto.getUserName());
		result.setResult(serviceResult);
		return result;
	}

}
