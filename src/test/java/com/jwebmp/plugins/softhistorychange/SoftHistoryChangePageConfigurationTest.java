/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.softhistorychange;

import com.jwebmp.core.FileTemplates;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularFeature;
import com.jwebmp.core.base.html.Div;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SoftHistoryChangePageConfigurationTest

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
