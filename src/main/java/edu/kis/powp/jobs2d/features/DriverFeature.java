package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.SelectDriverMenuOptionListener;
import edu.kis.powp.jobs2d.observer.DriverChangeObserver;

public class DriverFeature {

	private static DriverManager driverManager = new DriverManager();
	private static Application app;

	public static DriverManager getDriverManager() {
		return driverManager;
	}

	/**
	 * Setup jobs2d drivers Plugin and add to application.
	 * 
	 * @param application Application context.
	 */
	public static void setupDriverPlugin(Application application) {
		app = application;
		app.addComponentMenu(DriverFeature.class, "Drivers");
	}

	/**
	 * Add observer to driverManager's observable.
	 *
	 * @param driverChangeObserver Observer to be added.
	 */
	public static void addDriverChangeObserver(DriverChangeObserver driverChangeObserver){
		driverManager.getPublisher().addSubscriber(driverChangeObserver);
	}

	/**
	 * Add driver to context, create button in driver menu.
	 * 
	 * @param name   Button name.
	 * @param driver Job2dDriver object.
	 */
	public static void addDriver(String name, Job2dDriver driver) {
		SelectDriverMenuOptionListener listener = new SelectDriverMenuOptionListener(driver, driverManager);
		app.addComponentMenuElement(DriverFeature.class, name, listener);
	}
}
