package org.ankarajug.testinfected;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.lang.reflect.ParameterizedType;

/**
 * User: mertcaliskan
 * Date: 2/18/13
 */
public abstract class BaseWebServiceIntegrationTestCase<T> extends BaseIntegrationTestCase {

    private static final Integer TEST_SERVER_PORT = 9090;
    private static final String TEST_JETTY_URL = "http://localhost:" + TEST_SERVER_PORT;
    private static final String TEST_JETTY_WS_URL = TEST_JETTY_URL + "/services";

    private static final String WSDL_SUFFIX = "?WSDL";
    private static final int READ_TIME_OUT_1MIN = 6000;

    private static Server server;

    @BeforeClass
    public static void setUpClass() throws Exception {
        server = new Server(TEST_SERVER_PORT);
        WebAppContext appContext = new WebAppContext();
        appContext.setContextPath("/");

        File rd = new File(".");
        String canonicalPath = rd.getCanonicalPath();
        String path = "/src/main/webapp";
        if (canonicalPath.endsWith("demo") == false) {
            path = "/demo" + path;
        }
        File warPath = new File(canonicalPath, path);

        appContext.setWar(warPath.getAbsolutePath());

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{appContext, new DefaultHandler()});

        server.setHandler(handlers);
        server.start();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }

    protected T createServiceClient(String serviceURL) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<?> interfaceClass = (Class<?>) genericSuperclass.getActualTypeArguments()[0];

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress(TEST_JETTY_WS_URL + serviceURL + WSDL_SUFFIX);
        factory.setServiceClass(interfaceClass);
        T client = (T) factory.create();

        Client endpointClient = factory.getClientFactoryBean().create();
        HTTPConduit http = (HTTPConduit) endpointClient.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(READ_TIME_OUT_1MIN);
        httpClientPolicy.setAllowChunking(false);
        http.setClient(httpClientPolicy);

        return client;
    }
}