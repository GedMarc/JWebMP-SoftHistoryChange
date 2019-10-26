package com.jwebmp.plugins.softhistorychange.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class SoftHistoryChangeExclusionsModule
		implements IGuiceScanModuleExclusions<SoftHistoryChangeExclusionsModule>,
				           IGuiceScanJarExclusions<SoftHistoryChangeExclusionsModule>
{

	@Override
	public @NotNull Set<String> excludeJars()
	{
		Set<String> strings = new HashSet<>();
		strings.add("jwebmp-soft-history-change-*");
		return strings;
	}

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.softhistorychange");
		return strings;
	}
}
