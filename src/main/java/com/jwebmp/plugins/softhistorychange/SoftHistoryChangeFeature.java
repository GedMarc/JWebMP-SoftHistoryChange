package com.jwebmp.plugins.softhistorychange;

import com.jwebmp.core.Feature;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.guicedee.guicedinjection.json.StaticStrings.*;

public class SoftHistoryChangeFeature<O extends JavaScriptPart<O>, J extends SoftHistoryChangeFeature<O, J>>
		extends Feature<J, O, J>
{
	private Map<String, String> queryParameters = new LinkedHashMap<>();
	
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
		  .append(renderQueryParameters())
		  .append(STRING_SINGLE_QUOTES);
		
		sb.append(");");
		addQuery(sb.toString());
	}
	
	public StringBuilder renderQueryParameters()
	{
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : queryParameters.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			if (sb.length() != 0)
			{
				sb.append("&");
			}
			sb.append(key)
			  .append(STRING_EQUALS)
			  .append(value);
		}
		return sb;
	}
	
	/**
	 * Gets the query string associated
	 *
	 * @return
	 */
	public Map<String, String> getQueryParameters()
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
	public J setQueryParameters(Map<String, String> queryParameters)
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
	
	@Override
	public @NotNull Integer getSortOrder()
	{
		return Integer.MAX_VALUE - 5;
	}
}
