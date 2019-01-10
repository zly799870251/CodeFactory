<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package com.sdd.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sdd.common.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ${className} Dto
 *
 * @author Becypress
 * @date 2019-01-04
 */

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
public class ${className}Dto extends BaseDto {

    <#list table.columns as column>
    <#if column.sqlName != 'create_time' && column.sqlName != 'update_time' && column.sqlName != 'create_user' && column.sqlName != 'update_user' && column.sqlName != 'is_deleted'>
    <#if column.simpleJavaType == 'Date'>
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    </#if>
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#if>
    </#list>

}