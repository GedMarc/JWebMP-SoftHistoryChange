import com.jwebmp.plugins.softhistorychange.implementations.SoftHistoryModuleInclusion;

module com.jwebmp.plugins.softhistorychange {

	exports com.jwebmp.plugins.softhistorychange;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;

	requires jakarta.validation;
	requires java.logging;
	requires com.guicedee.guicedinjection;
	requires com.jwebmp.core.angular;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.softhistorychange.SoftHistoryChangePageConfiguration;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.softhistorychange.implementations.SoftHistoryChangeExclusionsModule;
	provides com.jwebmp.core.base.angular.services.IAngularDirective with com.jwebmp.plugins.softhistorychange.SoftHistoryChangeDirective;
	provides  com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with SoftHistoryModuleInclusion;

	opens com.jwebmp.plugins.softhistorychange to com.fasterxml.jackson.databind, com.jwebmp.core;
}
