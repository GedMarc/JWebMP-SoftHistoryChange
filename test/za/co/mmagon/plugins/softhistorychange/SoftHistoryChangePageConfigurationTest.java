package za.co.mmagon.plugins.softhistorychange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.AngularFeature;
import za.co.mmagon.jwebswing.base.html.Div;

class SoftHistoryChangePageConfigurationTest
		extends BaseTestClass
{
	@Test
	public void testPageConfig()
	{
		Page page = new Page();
		page.getOptions()
		    .setDynamicRender(false);
		page.getBody()
		    .add(new Div<>());
		System.out.println(page.toString(0));
		Assertions.assertTrue(page.toString(0)
		                          .contains("directive('soft-history-change'"));
	}

	@Test
	public void testDirective()
	{
		StringBuilder sb = new StringBuilder();
		AngularFeature af = new AngularFeature(new Page());
		af.configureTemplateVariables();
		sb.append(FileTemplates.renderTemplateScripts("jwangular"));
		System.out.println(sb);
	}

}
