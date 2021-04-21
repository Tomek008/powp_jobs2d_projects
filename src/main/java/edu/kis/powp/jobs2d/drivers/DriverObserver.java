package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Publisher;
import edu.kis.powp.observer.Subscriber;

public class DriverObserver implements Subscriber {

    private Application app;

    public DriverObserver(Application app){
        this.app = app;
    }

    @Override
    public void update() {
        app.updateInfo(DriverFeature.getDriverManager().getCurrentDriver().toString());
    }


}
