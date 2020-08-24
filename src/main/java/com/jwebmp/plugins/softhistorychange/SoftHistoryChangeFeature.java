package com.jwebmp.plugins.softhistorychange;

import com.jwebmp.core.Feature;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.jwebmp.core.utilities.StaticStrings.*;

public class SoftHistoryChangeFeature<O extends JavaScriptPart<O>, J extends SoftHistoryChangeFeature<O, J>>
		extends Feature<J, O, J>
{
	private String queryParameters;
	private String documentTitle;
	private String dataObject;

	public SoftHistoryChangeFeature()
	{
		super("SoftHistoryChangeFeature");
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

	@Override
	protected void assignFunctionsToComponent()
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
		addQuery(sb.toString());
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
	@SuppressWarnings("unchecked")
	@NotNull
	public J setQueryParameters(String queryParameters)
	{
		this.queryParameters = queryParameters;
		return (J) this;
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
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDocumentTitle(String documentTitle)
	{
		this.documentTitle = documentTitle;
		return (J) this;
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
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDataObject(String dataObject)
	{
		this.dataObject = dataObject;
		return (J) this;
	}

}
