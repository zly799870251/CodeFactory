<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.sdd.api.dao;

import java.util.Collection;
import com.sdd.api.pojo.${className};

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * ${className} mapper
 *
 * @author Becypress
 * @date 2019-01-04
 */
public interface ${className}Mapper {

    /**
     * Create a record
     *
     * @param record Record to be created
     * @return Execute operation result
     */
    int insert(${className} record);

    /**
     * Query record by page
     *
     * @param params Query condition map
     * @return Page object of query record
     */
    List<${className}> queryByPage(HashMap<String, Object> params);

    /**
     * Find unique record by id
     *
     * @param id The id of the record to find
     * @return Queryed record object
     */
    ${className} findById(Long id);

    /**
     * Update a record by id
     *
     * @param record Record to be updated
     * @return Execute operation result
     */
    int update(${className} record);

    /**
     * Delete a record by id
     *
     * @param id The id of the record to delete
     * @param updateUser Operator username
     * @return Execute operation result
     */
    int delete(@Param("id") Long id, @Param("updateUser") String updateUser);

    /**
     * Insert a set of list for a record
     *
     * @param records The record list of the record to insert
     * @return Execute operation result
     */
    int insertBatch(@Param("records") Collection<${className}> records);

    /**
     * Delete a set of ids for a record
     *
     * @param ids The id list of the record to delete
     * @param updateUser Operator username
     * @return Execute operation result
     */
    int deleteBatch(@Param("ids") Collection<Long> ids, @Param("updateUser") String updateUser);

}
