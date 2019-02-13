package com.bjlemon;

import com.bjiemon.mp.beans.Employee;
import com.bjiemon.mp.mapper.EmployeeMapper;
import com.bjiemon.mp.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class TestCode {
    static ClassPathXmlApplicationContext ioc = null;

    static {
        ioc = new ClassPathXmlApplicationContext("application.xml");
    }


    @Test
    public void testInsert() {
//        EmployeeMapper employeeMapper = ioc.getBean(EmployeeMapper.class);
//
//        Employee employee = new Employee();
//        employee.setEmpName("admin");
//        employee.setEmpJob("销售");
//
//        employeeMapper.insert(employee);

        EmployeeService employeeService = ioc.getBean(EmployeeService.class);

        Employee employee = new Employee();
        employee.setEmpName("admin");
        employee.setEmpJob("销售");
        employee.setEmpSalary(new BigDecimal("998.00"));
        boolean isOk = employeeService.save(employee);

        System.out.println(isOk);
    }

    @Test
    public void testOptimisticLocker() {
        EmployeeService employeeService = ioc.getBean(EmployeeService.class);

        Employee employee = new Employee();
        employee.setId(4);
        employee.setEmpName("jason");
        employee.setVersion(4);

        boolean isOk = employeeService.updateById(employee);
        System.out.println(isOk);
    }

    @Test
    public void testLogicDelete() {
        EmployeeService employeeService = ioc.getBean(EmployeeService.class);
        Employee employee = new Employee();

        boolean isOk = employeeService.removeById(4);
        System.out.println(isOk);
    }
}
