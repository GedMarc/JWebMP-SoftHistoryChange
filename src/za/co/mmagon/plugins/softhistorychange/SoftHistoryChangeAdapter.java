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
package za.co.mmagon.plugins.softhistorychange;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "Soft History Changer",
		description = "Instantly enable url changes without changing the form. No hash-bang required.",
		url = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange",
		wikiUrl = "https://github.com/GedMarc/JWebSwing-SoftHistoryChange/wiki")
public abstract class SoftHistoryChangeAdapter<J extends SoftHistoryChangeAdapter<J>>
		extends ClickAdapter
		implements GlobalEvents
{

	/**
	 * Logger for the Component
	 */
	private static final long serialVersionUID = 1L;

	private String queryParameters;
	private String documentTitle;
	private String dataObject;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 * @param queryParameterString
	 */
	public SoftHistoryChangeAdapter(ComponentHierarchyBase component, String queryParameterString)
	{
		super(component);
		setComponent(component);
		queryParameters = queryParameterString;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
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
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		onClick(call, response);
	}

	@Override
	public void onClick(AjaxCall call, AjaxResponse response)
	{
		onUrlChange(call, response);

		response.getFeatures()
		        .add(new Feature("change history url")
		        {
			        private static final long serialVersionUID = 1L;

			        @Override
			        protected void assignFunctionsToComponent()
			        {
				        //Nothing Needed
			        }

			        @Override
			        public StringBuilder renderJavascript()
			        {
				        StringBuilder sb = new StringBuilder("window.history.pushState(");
				        if (dataObject != null && !dataObject.isEmpty())
				        {
					        sb.append(dataObject);
				        }
				        else
				        {
					        sb.append("null");
				        }
				        sb.append(STRING_COMMNA);
				        if (documentTitle != null && !documentTitle.isEmpty())
				        {
					        sb.append(STRING_SINGLE_QUOTES)
					          .append(documentTitle)
					          .append(STRING_SINGLE_QUOTES);
				        }
				        else
				        {
					        sb.append("null");
				        }
				        sb.append(STRING_COMMNA);
				        sb.append(STRING_SINGLE_QUOTES)
				          .append(CHAR_QUESTIONMARK)
				          .append(queryParameters)
				          .append(STRING_SINGLE_QUOTES);

				        sb.append(");");
				        return sb;
			        }
		        });
	}

	public abstract void onUrlChange(AjaxCall call, AjaxResponse response);


}
