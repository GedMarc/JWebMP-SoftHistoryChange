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

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.core.plugins.ComponentInformation;

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
	private final SoftHistoryChangeFeature<?, ?> feature = new SoftHistoryChangeFeature<>();

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
	public void fireEvent(AjaxCall<?> call, AjaxResponse<?> response)
	{
		onClick(call, response);
	}

	@Override
	public void onClick(AjaxCall<?> call, AjaxResponse<?> response)
	{
		onUrlChange(call, response);
		response.getFeatures()
		        .add(getFeature());
	}

	public abstract void onUrlChange(AjaxCall<?> call, AjaxResponse<?> response);

}
