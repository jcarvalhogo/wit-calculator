package br.com.jcarvalho.witcalculator.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class LoggerRequestProcess implements Filter {
    public static final Logger LOGGER = Logger.getLogger(LoggerRequestProcess.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        LOGGER.info("Controler de Acesso - Recurso: " + req.getRequestURI() + " - Protocolo: " + req.getProtocol() + " - IP: [" + req.getRemoteAddr() + "] - RemotePort: [" + req.getRemotePort() + "]");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
