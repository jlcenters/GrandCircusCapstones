package co.grandcircus.Capstone7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
 
import java.io.IOException;
import java.nio.charset.Charset;
 
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass());
 
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }
 
    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        if (log.isErrorEnabled()) {
            log.error("===========================request begin================================================");
            log.error("URI         : {}", request.getURI());
            log.error("Method      : {}", request.getMethod());
            log.error("Headers     : {}", request.getHeaders());
            log.error("Request body: {}", new String(body, "UTF-8"));
            log.error("==========================request end================================================");
        }
    }
 
    private void logResponse(ClientHttpResponse response) throws IOException {
        if (log.isErrorEnabled()) {
            log.error("============================response begin==========================================");
            log.error("Status code  : {}", response.getStatusCode());
            log.error("Status text  : {}", response.getStatusText());
            log.error("Headers      : {}", response.getHeaders());
//            log.error("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            log.error("=======================response end=================================================");
        }
    }
}