import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.softhistorychange.SoftHistoryChangePageConfiguration;
import com.jwebmp.plugins.softhistorychange.implementations.SoftHistoryChangeExclusionsModule;

module com.jwebmp.plugins.softhistorychange {

	exports com.jwebmp.plugins.softhistorychange;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.jwebmp.guicedinjection;

	provides IPageConfigurator with SoftHistoryChangePageConfiguration;
	provides IGuiceScanJarExclusions with SoftHistoryChangeExclusionsModule;
	provides IGuiceScanModuleExclusions with SoftHistoryChangeExclusionsModule;

	opens com.jwebmp.plugins.softhistorychange to com.fasterxml.jackson.databind, com.jwebmp.core;
}
