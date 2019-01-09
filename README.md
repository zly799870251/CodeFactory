 **codeFactory** 

介绍:
  1.codeFactory: Java代码生成,依赖rapid-generator.4.0.6.jar, 支持自定义模板生成代码, 弱业务下完全解放体力劳动.集成分页插件.
  2.ssm模板实现:pojo,dao,daoimpl,service,serviceimpl,controller,各mapper.xml 代码自动生成,
  3.配置文件自动生(含:spring,springMVC,mybatis,web.xml); 代码完美运行.

使用:
 1.配置generator.xml(key):basepackage,namespace,outRoot,jdbc_username,jdbc_password,jdbc_url(默认MySQL库)
 2.CodeGenerator类g.generateByTable("tb_admin","tb_city");方法传参(table表名),支持批量传参和单表操作
 3.main方法运行CodeGenerator类,在配置的outRoot输出路径找到生成代码,复制到对应项目包下.页面${page.list}获取绑定值, (page是controller绑定的参      数, 分页插件写法)

 
**注：**如果数据库字段类型为decimal但**无小数位**（如decimal(10,0) ），rapid-framework在生成javabean时该字段会使用Long而非BigDecimal