/*
 * The MIT License
 *
 * Copyright 2017 GedMarc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package za.co.mmagon.plugins.softhistorychange;

import java.util.logging.Logger;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.logger.LogFactory;

/**
 *
 * @author GedMarc
 * @since 15 Feb 2017
 *
 */
@PluginInformation(pluginName = "Soft History Changer",
                   pluginUniqueName = "soft-history-changer",
                   pluginDescription = "This plugin assists with changing the history url without doing a page refresh. It is especially useful in that it allows for deep linking very simply.",
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
                   pluginLastUpdatedDate = "2017/04/08"
)
public class SoftHistoryChangePageConfiguration extends PageConfigurator
{

    private static final long serialVersionUID = 1L;
    private static final Logger log = LogFactory.getInstance().getLogger("SoftHistoryPageConfiguration");
    public static final String SoftHistoryEnabled = "softhistoryenabled-enabled";

    public SoftHistoryChangePageConfiguration()
    {

    }

    @Override
    public Page configure(Page page)
    {
        if (!page.isConfigured())
        {
            JQueryPageConfigurator.setRequired(page.getBody(), true);
            AngularPageConfigurator.setRequired(page.getBody(), true);

            //page.getAngular().getAngularDirectives().add(new SoftHistoryChangeDirective());
        }
        return page;
    }

    /**
     * Sets the component as font awesome required to build
     *
     * @param component
     * @param required
     */
    public static void setRequired(Component component, boolean required)
    {
        component.getProperties().put(SoftHistoryEnabled, required);
    }
}
