package cn.edu.xmu.shiro.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author issyu 30320182200070
 * @date 2021/1/23 21:24
 */
public class MybatisplusGeneratorConfig {

    public static void main(String []args){

        AutoGenerator autoGenerator =
                new AutoGenerator();

        GlobalConfig globalConfig =
                new GlobalConfig();

        //String projectPath = System.getProperty("demo.super");
        //配置输出路径
        globalConfig.setOutputDir("C://Users/Administrator/Desktop/issyu-holiday/shiro/src/main/java");
        globalConfig.setAuthor("summer");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        //globalConfig.setServiceName("%sService");
        globalConfig.setBaseResultMap(true);
        autoGenerator.setGlobalConfig(globalConfig);

        //配置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mall?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("issyu153");
        autoGenerator.setDataSource(dsc);

        //配置包
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("shiro");
        pc.setParent("cn.edu.xmu");
        autoGenerator.setPackageInfo(pc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperControllerClass("cn.edu.xmu.superdemo.controller.BaseController");
        strategy.setSuperEntityClass("cn.edu.xmu.shiro.entity.BaseEntity");
        // strategy.setTablePrefix("t_");
        // 表名前缀
        strategy.setEntityLombokModel(true);
        //使用lombok
        //strategy.setInclude("user");
        // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
        autoGenerator.setStrategy(strategy);

        autoGenerator.execute();
    }
}
