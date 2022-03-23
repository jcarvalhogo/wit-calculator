package br.com.jcarvalho.witlogger.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    public static final String QUEUE = "WitQueue";
    public static final String EXCHANGE = "WitexChange";
    public static final String ROUTING_KEY = "WitRoutingKey";
}
