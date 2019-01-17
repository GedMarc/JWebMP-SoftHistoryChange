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

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.core.plugins.ComponentInformation;

import javax.validation.constraints.NotNull;

import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Handles all events. Over-ride methods.
 *
 * @author GedMarc
 */
@ComponentInformation(name = "Soft History Changer",
		description = "Instantly enable url changes without changing the form. No hash-bang required.",
		url = "https://github.com/GedMarc/JWebMP-SoftHistoryChange",
		wikiUrl = "https://github.com/GedMarc/JWebMP-SoftHistoryChange/wiki")
public abstract class SoftHistoryChangeAdapter<J extends SoftHistoryChangeAdapter<J>>
		extends ClickAdapter<J>
		implements GlobalEvents
{

	/**
	 * Logger for the Component
	 */
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
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
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


			        @NotNull
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

			        @Override
			        protected void assignFunctionsToComponent()
			        {
				        //Nothing Needed
			        }
		        });
	}

	public abstract void onUrlChange(AjaxCall call, AjaxResponse response);

}
