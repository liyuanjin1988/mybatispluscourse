package com.bjiemon.mp.mapper;

import com.bjiemon.mp.beans.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jason
 * @since 2019-01-20
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    public boolean deleteByName(String name) throws Exception;
}
