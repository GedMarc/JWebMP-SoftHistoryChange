import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.softhistorychange.SoftHistoryChangePageConfiguration;

module com.jwebmp.plugins.softhistorychange {

	exports com.jwebmp.plugins.softhistorychange;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;

	provides IPageConfigurator with SoftHistoryChangePageConfiguration;
	opens com.jwebmp.plugins.softhistorychange to com.fasterxml.jackson.databind,com.jwebmp.core;
}
