package org.ankarajug.testinfected;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

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


    public T createServiceClient(String serviceURL) {
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
