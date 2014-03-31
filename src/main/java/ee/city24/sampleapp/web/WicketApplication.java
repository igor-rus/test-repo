package ee.city24.sampleapp.web;

import ee.city24.sampleapp.web.pages.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.stereotype.Component;

@Component("wicketApplication")
public class WicketApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        // !!! - do not forget to call init on parent
        super.init();
        // initialize Spring
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));


    }
}
