package com.jwebmp.plugins.softhistorychange.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class SoftHistoryModuleInclusion implements IGuiceScanModuleInclusions<SoftHistoryModuleInclusion>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> set = new HashSet<>();
		set.add("com.jwebmp.plugins.jqueryui");
		return set;
	}
}
