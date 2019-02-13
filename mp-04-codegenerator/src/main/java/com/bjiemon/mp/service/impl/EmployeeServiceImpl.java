package com.bjiemon.mp.service.impl;

import com.bjiemon.mp.beans.Employee;
import com.bjiemon.mp.mapper.EmployeeMapper;
import com.bjiemon.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jason
 * @since 2019-01-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
