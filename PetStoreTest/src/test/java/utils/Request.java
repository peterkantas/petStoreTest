package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import communication.http.HttpJsonUtil;

public class Request {
    private String commonRequest;

    public JsonNode getCommonRequestJsonNode() throws JsonProcessingException {
        return HttpJsonUtil.castStringToJsonNode(commonRequest);
    }

    public String getCommonRequest() {
        return commonRequest;
    }

    public void setCommonRequest(String newRequest) {
        this.commonRequest = newRequest;
    }
}
