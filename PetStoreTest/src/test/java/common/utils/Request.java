package common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import communication.common.RequestType;
import communication.http.HttpJsonUtil;

public class Request {
    private static RequestType commonRequestType;
    private static String commonRequest;

    public JsonNode getCommonRequestJsonNode() throws JsonProcessingException {
        HttpJsonUtil hju = new HttpJsonUtil();
        return hju.castStringToJsonNode(commonRequest);
    }

    public String getCommonRequest() {
        return commonRequest;
    }

    public void setCommonRequest(String newRequest) {
        commonRequest = newRequest;
    }

    public RequestType getCommonRequestType() {
        return commonRequestType;
    }

    public void setCommonRequestType(RequestType newRequestType) {
        commonRequestType = newRequestType;
    }
}
