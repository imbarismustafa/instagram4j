package com.github.instagram4j.Instagram4J.requests.igtv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.instagram4j.Instagram4J.IGClient;
import com.github.instagram4j.Instagram4J.models.IGPayload;
import com.github.instagram4j.Instagram4J.requests.IGPostRequest;
import com.github.instagram4j.Instagram4J.responses.igtv.IGIgtvSearchResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IGIgtvSearchRequest extends IGPostRequest<IGIgtvSearchResponse> {
    private String _query;
    
    @Override
    protected IGPayload getPayload(IGClient client) {
        return new IGIgtvSearchPayload();
    }

    @Override
    public String path() {
        return String.format("igtv/%s/", _query != null ? "search" : "suggested_searches");
    }

    @Override
    public Class<IGIgtvSearchResponse> getResponseType() {
        return IGIgtvSearchResponse.class;
    }
    
    @Data
    @JsonInclude(Include.NON_NULL)
    public class IGIgtvSearchPayload extends IGPayload {
        private String query = _query;
    }

}
