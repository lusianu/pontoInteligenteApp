package com.diasdev.pontointeligente.entities;

import java.util.AbstractMap;

public class FullParameters {
    public String method;
    public String url;
    public AbstractMap<String, String> headerParameters;
    public AbstractMap<String, String> parameters;

    public FullParameters(String method, String url, AbstractMap<String, String> headerParameters, AbstractMap<String, String> parameters) {
        this.method = method;
        this.url = url;
        this.headerParameters = headerParameters;
        this.parameters = parameters;
    }
}
