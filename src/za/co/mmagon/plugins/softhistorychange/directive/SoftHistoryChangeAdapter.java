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
package za.co.mmagon.plugins.softhistorychange.directive;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.logger.LogFactory;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "Soft History Changer", description = "Instantly enable url changes without changing the form. No hash-bang required.",
                      url = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange", wikiUrl = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange/wiki")
public abstract class SoftHistoryChangeAdapter extends ClickAdapter
        implements GlobalEvents
{

    /**
     * Logger for the Component
     */
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("SoftHistoryChangeAdapter");
    private static final long serialVersionUID = 1L;

    private String queryParameters;
    private String documentTitle;
    private String dataObject;

    /**
     * Performs a click
     *
     * @param component            The component this click is going to be acting on
     * @param queryParameterString
     */
    public SoftHistoryChangeAdapter(Component component, String queryParameterString)
    {
        super(component);
        setComponent(component);
        queryParameters = queryParameterString;
    }

    /**
     * Gets the query string associated
     *
     * @return
     */
    public String getQueryParameters()
    {
        return queryParameters;
    }

    /**
     * Sets the query string associated
     *
     * @param queryParameters
     */
    public void setQueryParameters(String queryParameters)
    {
        this.queryParameters = queryParameters;
    }

    /**
     * Sets the document title
     *
     * @return
     */
    public String getDocumentTitle()
    {
        return documentTitle;
    }

    /**
     * Sets the document title
     *
     * @param documentTitle
     */
    public void setDocumentTitle(String documentTitle)
    {
        this.documentTitle = documentTitle;
    }

    /**
     * Gets the data object
     *
     * @return
     */
    public String getDataObject()
    {
        return dataObject;
    }

    /**
     * Sets the data object
     *
     * @param dataObject
     */
    public void setDataObject(String dataObject)
    {
        this.dataObject = dataObject;
    }

    @Override
    public void onClick(AjaxCall call, AjaxResponse response)
    {
        response.getFeatures().add(new Feature("change history url")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public StringBuilder renderJavascript()
            {
                return new StringBuilder().append("window.history.pushState("
                        + (dataObject == null ? "null" : "'" + dataObject + "'") + ", "
                        + (documentTitle == null ? "null" : "'" + documentTitle + "'") + ", '?" + queryParameters + "');");
            }
        });
        onUrlChange(call, response);
    }

    public abstract void onUrlChange(AjaxCall call, AjaxResponse response);

    @Override
    public void fireEvent(AjaxCall call, AjaxResponse response)
    {
        onClick(call, response);
    }

}
