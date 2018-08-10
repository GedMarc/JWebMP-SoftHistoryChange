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

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;

import javax.validation.constraints.NotNull;

/**
 * @author GedMarc
 * @since 15 Feb 2017
 */
@PluginInformation(pluginName = "Soft History Changer",
		pluginUniqueName = "soft-history-changer",
		pluginDescription = "This plugin assists with changing the history url without doing a page refresh. It is especially useful in "
		                    + "that it allows for deep linking very simply.",
		pluginVersion = "0.1",
		pluginDependancyUniqueIDs = "jquery,angular",
		pluginCategories = "browser config, history, url",
		pluginSubtitle = "Instantly allow deep linking with this little gadget!",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange.git",
		pluginSourceUrl = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange.git",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange/wiki",
		pluginOriginalHomepage = "http://www.jwebswing.com",
		pluginDownloadUrl = "",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginLastUpdatedDate = "2017/04/08")
public class SoftHistoryChangePageConfiguration
		implements IPageConfigurator
{
	public SoftHistoryChangePageConfiguration()
	{
		//Nothing Needed
	}

	@NotNull
	@Override
	public Page configure(Page page)
	{
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
		return page;
	}
}
