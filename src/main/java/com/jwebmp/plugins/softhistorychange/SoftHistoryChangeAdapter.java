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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.logger.LogFactory;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.core.plugins.ComponentInformation;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.guicedee.guicedinjection.interfaces.ObjectBinderKeys.*;

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
		implements GlobalEvents<J>
{
	private final SoftHistoryChangeFeature<?, ?> feature = new SoftHistoryChangeFeature<>();
	
	private static final Logger log = LogFactory.getLog(SoftHistoryChangeAdapter.class);
	
	/**
	 * Performs a click
	 *
	 * @param component The component this click is going to be acting on
	 */
	public SoftHistoryChangeAdapter(IComponentHierarchyBase<?, ?> component)
	{
		super(component);
		setComponent(component);
		getFeatures().add(feature);
	}
	
	public SoftHistoryChangeFeature<?, ?> getFeature()
	{
		return feature;
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
	public void init()
	{
		@SuppressWarnings("Convert2Diamond")
		TypeReference<Map<String, String>> tr = new TypeReference<Map<String, String>>() {};
		
		try
		{
			getComponent().asAttributeBase()
			              .addAttribute("queryparameters", GuiceContext.get(DefaultObjectMapper).writerFor(tr).writeValueAsString(getFeature().getQueryParameters()));
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		super.init();
	}
	
	@Override
	public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
	{
		if (!Strings.isNullOrEmpty(call.getAttribute("queryparameters")))
		{
			@SuppressWarnings("Convert2Diamond")
			TypeReference<Map<String, String>> tr = new TypeReference<Map<String, String>>() {};
			try
			{
				Map<String, String> qs = GuiceContext.get(DefaultObjectMapper)
				                                     .readerFor(tr)
				                                     .readValue(call.getAttribute("queryparameters").replaceAll("'","\""));
				getFeature().setQueryParameters(qs);
			}
			catch (JsonProcessingException e)
			{
				log.log(Level.WARNING, "Cannot read query parameters map", e);
			}
		}
		onClick(call, response);
	}
	
	@Override
	public void onClick(AjaxCall<?> call, AjaxResponse<?> response)
	{
		onUrlChange(call, response);
		response.getFeatures()
		        .add(getFeature());
	}
	
	@SuppressWarnings("unchecked")
	public J addQueryParameter(String key, String value)
	{
		getFeature().getQueryParameters()
		            .put(key, value);
		return (J) this;
	}
	
	public abstract void onUrlChange(AjaxCall<?> call, AjaxResponse<?> response);
	
}
