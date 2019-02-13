package com.bjlemon;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestGenerator {
    @Test
    public void testGodeGenerator() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 作者
        gc.setAuthor("jason");
        // 开启活动记录
        gc.setActiveRecord(true);
        // 通用字段
        gc.setBaseColumnList(true);
        // 基本的映射
        gc.setBaseResultMap(true);
        // 主键自增长
        gc.setIdType(IdType.AUTO);

        // 设置服务名字
        gc.setServiceName("%sService");
        // 服务实现的名字
        gc.setServiceImplName("%sServiceImpl");
        // 设置覆盖现有文件
        gc.setFileOverride(true);
        // 设置输出目录
        gc.setOutputDir("D:\\codePrograms\\mybatispluscourse\\mp-04-codegenerator\\src\\main\\java");

        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis-plus?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("");

        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pcg = new PackageConfig();
        pcg.setParent("com.bjiemon.mp");
        pcg.setEntity("beans");
        pcg.setMapper("mapper");
        pcg.setController("controller");
        pcg.setService("service");
        pcg.setXml("mapper");

        mpg.setPackageInfo(pcg);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();

        // 下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 使用lombok
        strategyConfig.setEntityLombokModel(true);
        // restful风格api
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setInclude("sys_employee");
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix("sys_");

        mpg.setStrategy(strategyConfig);

        mpg.execute();


    }
}
