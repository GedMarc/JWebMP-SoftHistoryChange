package com.jwebmp.plugins.softhistorychange.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class SoftHistoryChangeExclusionsModule
		implements IGuiceScanModuleExclusions<SoftHistoryChangeExclusionsModule>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.softhistorychange");
		return strings;
	}
}
