package codefactory;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class CodeGenerator {

	public static void main(String[] args) throws Exception {
        //模板路径
		String templatePath = "/Users/zhangly/Downloads/Projects/codeFactory/src/main/resources/template";
		
		GeneratorFacade g = new GeneratorFacade();
		g.getGenerator().addTemplateRootDir(templatePath);
		
		// 删除生成器的输出目录//
		 g.deleteOutRootDir();

		// 通过数据库表生成文件
		g.generateByTable("conf_customer_list");
		g.generateByTable("conf_dual_use_list");
		g.generateByTable("conf_third_party_websites");
		g.generateByTable("conf_measurement_units");
		// g.generateByTable("sdd_invoice");
		// g.generateByTable("sdd_packing_list");
//		g.generateByTable("sdd_cover_letter");
//		g.generateByTable("sdd_lc_issuance");
//		g.generateByTable("sdd_airway_bill");
//		g.generateByTable("sdd_airway_bill_detail");
//		g.generateByTable("sdd_transport_docs");
//		g.generateByTable("sdd_transport_docs_detail");
//		g.generateByTable("sdd_others");

		// 自动搜索数据库中的所有表并生成文件,template为模板的根目录
		// g.generateByAllTable();
		
		// 按table名字删除文件
		// g.deleteByTable("table_name", "template");

	}

}
