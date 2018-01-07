package za.co.mmagon.plugins.softhistorychange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Comment;
import za.co.mmagon.jwebswing.base.html.Div;

class SoftHistoryChangePageConfigurationTest extends BaseTestClass
{
	@Test
	public void testPageConfig()
	{
		Page page = new Page();
		page.getOptions().setDynamicRender(false);
		page.add(new Comment("asdf"));
		page.getBody().add(new Div<>());
		System.out.println(page.toString(0));
		Assertions.assertTrue(page.toString(0).contains("directive('soft-history-change'"));
	}
}
