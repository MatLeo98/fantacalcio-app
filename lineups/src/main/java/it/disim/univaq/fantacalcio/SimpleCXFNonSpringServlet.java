package it.disim.univaq.fantacalcio;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import it.disim.univaq.fantacalcio.endpoints.LineupsImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet{
    private static final long serialVersionUID = 5976105248644843342L;

    @Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/lineups", new LineupsImpl());
    }

}

