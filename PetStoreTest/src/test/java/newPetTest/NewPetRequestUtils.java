package newPetTest;

import assertion.json.JsonAssert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import common.utils.HttpUtils;
import common.utils.Request;
import communication.common.RequestType;
import communication.http.HttpHelper;

import static common.utils.CommonUtils.ID;
import static common.utils.FileUtils.readFromInputStream;

public class NewPetRequestUtils {
    private static final String addNewPetHeaderName = "Content-Type";
    private static final String addNewPetHeaderValue = "application/json";

    Request req = new Request();
    HttpHelper hh = new HttpHelper();
    Replacer idd = new Replacer();

    public JsonNode addNewPet(RequestType requestType, String id, String name, String categoryName) {
        setNewPetRequest(id, name, categoryName);
        return hh.sendJSONRequest(HttpUtils.setURL(requestType, id), req.getCommonRequest(), addNewPetHeaderName, addNewPetHeaderValue, requestType);
    }

    private void setNewPetRequest(String id, String name, String categoryName) {
        String requestString = readFromInputStream(NewPetRequestUtils.class.getResourceAsStream("/request_samples/addNewPet.json"));
        requestString = idd.replaceID(id, requestString);
        requestString = idd.replaceName(name, requestString);
        requestString = idd.replaceCategoryName(categoryName, requestString);
        req.setCommonRequest(requestString);
    }

    public void checkPetSuccess() throws JsonProcessingException {
        JsonAssert.jsonAssertWithFile(req.getCommonRequestJsonNode(), "id", "", null, "", String.valueOf(ID));
    }
}
