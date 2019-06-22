package servletinit;

import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        Locale locale = Locale.getDefault();
        ServletRegistration.Dynamic registration = event.getServletContext()
                .addServlet("appController", locale.getISO3Country().equals("USA") ?
                        DefaultAppController.class : OffshoreAppController.class);
        registration.addMapping("/app/");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
