<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package com.sdd.api.mapstruct;

import com.sdd.api.dto.${className}Dto;
import com.sdd.api.pojo.${className};

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * ${className} map struct
 *
 * @author Becypress
 * @date 2019-01-04
 */

@Mapper(componentModel = "spring")
public interface ${className}MapStruct {

    @Mappings({
        @Mapping(target = "token", ignore = true),
        @Mapping(target = "userId", ignore = true),
        @Mapping(target = "userName", ignore = true),
        @Mapping(target = "sysType", ignore = true),
        @Mapping(target = "pageNum", ignore = true),
        @Mapping(target = "pageSize", ignore = true),
        @Mapping(target = "offset", ignore = true),
        @Mapping(target = "orderby", ignore = true),
        <#list table.columns as column>
        <#if column.sqlTypeName == 'text'>
        @Mapping(target = "${column.columnNameLower}", ignore = true),
        </#if>
        </#list>
        @Mapping(target = "idList", ignore = true)
    })
    ${className}Dto fromPojo2Dto(${className} pojo);

    @Mappings({
        <#list table.columns as column>
        <#if column.sqlTypeName == 'text'>
        @Mapping(target = "${column.columnNameLower}", ignore = true),
        </#if>
        </#list>
    })
    ${className} fromDto2Pojo(${className}Dto dto);

    List<${className}Dto> fromPojos2Dtos(List<${className}> pojoList);

    List<${className}> fromDtos2Pojos(List<${className}Dto> dtoList);

}
