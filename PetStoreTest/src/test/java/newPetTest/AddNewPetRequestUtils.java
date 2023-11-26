package newPetTest;

import assertion.json.JsonAssert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import communication.common.RequestType;
import communication.http.HttpHelper;
import utils.HttpUtils;
import utils.Request;

import java.util.Random;

import static utils.FileUtils.readFromInputStream;

public class AddNewPetRequestUtils {
    private static final String addNewPetHeaderName = "Content-Type";
    private static final String addNewPetHeaderValue = "application/json";
    public static int ID;
    Request s = new Request();

    public JsonNode addNewPet(RequestType requestType, String id, String name, String categoryName) {
        setCommonRequest(id, name, categoryName);
        return HttpHelper.sendPOSTJSONRequest(HttpUtils.setURL(requestType, id), s.getCommonRequest(), addNewPetHeaderName, addNewPetHeaderValue, requestType);
    }

    private void randomIDgenerator() {
        Random rand = new Random();
        ID = rand.nextInt(1000);
    }

    private void setCommonRequest(String id, String name, String categoryName) {
        String requestString = readFromInputStream(AddNewPetRequestUtils.class.getResourceAsStream("/request_samples/addNewPet.json"));
        if (id != null) {
            if (id.equals("randomID")) {
                randomIDgenerator();
                id = String.valueOf(ID);
            }
            requestString = requestString.replaceAll("##ID##", id);
        } else {
            throwNPE("id");
        }
        if (name != null) {
            requestString = requestString.replaceAll("##NAME##", name);
        } else {
            throwNPE("name");
        }
        if (categoryName != null) {
            if (categoryName.equals("kutyát")) {
                categoryName = "dog";
            } else if (categoryName.equals("cicát")) {
                categoryName = "cat";
            }
            requestString = requestString.replaceAll("##CATEGORYNAME##", categoryName);
        } else {
            throwNPE("categoryName");
        }
        s.setCommonRequest(requestString);
    }

    private void throwNPE(String type) {
        switch (type) {
            case "name" -> throw new NullPointerException("Nincs név, így nem tudok hozzáadni állatot");
            case "id" -> throw new NullPointerException("Nincs ID, így nem tudok hozzáadni állatot");
            case "categoryName" ->
                    throw new NullPointerException("Nincs kategória név, így nem tudok hozzáadni állatot");
        }
    }

    public void assertResponse() throws JsonProcessingException {
        JsonAssert.jsonAssertWithFile(s.getCommonRequestJsonNode(), "id", "", null, "", String.valueOf(ID));
    }
}
