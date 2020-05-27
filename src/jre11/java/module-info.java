module com.jwebmp.plugins.softhistorychange {

	exports com.jwebmp.plugins.softhistorychange;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;

	requires java.validation;
	requires java.logging;
	requires com.guicedee.guicedinjection;
	requires com.jwebmp.core.angularjs;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.softhistorychange.SoftHistoryChangePageConfiguration;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.softhistorychange.implementations.SoftHistoryChangeExclusionsModule;
	provides com.jwebmp.core.base.angular.services.IAngularDirective with com.jwebmp.plugins.softhistorychange.SoftHistoryChangeDirective;

	opens com.jwebmp.plugins.softhistorychange to com.fasterxml.jackson.databind, com.jwebmp.core;
}
