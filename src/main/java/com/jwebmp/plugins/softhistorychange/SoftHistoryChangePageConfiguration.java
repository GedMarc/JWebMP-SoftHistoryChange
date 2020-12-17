/*
 * Copyright (C) 2017 GedMarc
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
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;

import jakarta.validation.constraints.NotNull;

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
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-SoftHistoryChange.git",
		pluginSourceUrl = "https://github.com/GedMarc/JWebMP-SoftHistoryChange.git",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-SoftHistoryChange/wiki",
		pluginOriginalHomepage = "http://www.jwebmp.com",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.javascript/jwebmp-soft-history-change",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginLastUpdatedDate = "2017/04/08",
		pluginGroupId = "com.jwebmp.plugins.javascript",
		pluginArtifactId = "jwebmp-soft-history-change",
		pluginModuleName = "com.jwebmp.plugins.softhistorychange",
		pluginStatus = PluginStatus.Released
)
public class SoftHistoryChangePageConfiguration
		implements IPageConfigurator<SoftHistoryChangePageConfiguration>
{
	/**
	 * If this configurator is enabled
	 */
	private static boolean enabled = true;

	public SoftHistoryChangePageConfiguration()
	{
		//Nothing Needed
	}

	/**
	 * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
	 */
	public static boolean isEnabled()
	{
		return SoftHistoryChangePageConfiguration.enabled;
	}

	/**
	 * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
	 * <p>
	 * If this configurator is enabled
	 *
	 * @param mustEnable
	 * 		the enabled of this AngularAnimatedChangePageConfigurator object.
	 */
	public static void setEnabled(boolean mustEnable)
	{
		SoftHistoryChangePageConfiguration.enabled = mustEnable;
	}

	@NotNull
	@Override
	 public Page<?> configure(Page<?> page)
	{
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);
		return page;
	}

	@Override
	public boolean enabled()
	{
		return SoftHistoryChangePageConfiguration.enabled;
	}
}
