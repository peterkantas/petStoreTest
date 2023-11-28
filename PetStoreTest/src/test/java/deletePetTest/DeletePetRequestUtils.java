package deletePetTest;

import checkPetTest.CheckPetRequestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import common.utils.CommonUtils;
import common.utils.HttpUtils;
import common.utils.Request;
import communication.common.RequestType;
import communication.http.HttpHelper;
import org.junit.Assert;

public class DeletePetRequestUtils {

    Request req = new Request();
    HttpHelper hh = new HttpHelper();
    CheckPetRequestUtils chpru = new CheckPetRequestUtils();

    public void deletePet(RequestType requestType, String id) {
        req.setCommonRequest(String.valueOf(hh.sendJSONRequest(HttpUtils.setURL(requestType, id), null, null, null, requestType)));
    }

    public void assertResponseAfterDeletion() throws JsonProcessingException {
        chpru.checkPet(RequestType.GET, String.valueOf(CommonUtils.ID));
        Assert.assertTrue(checkDeletionSuccess("Pet not found"));
    }

    public boolean checkDeletionSuccess(String messageValue) throws JsonProcessingException {
        JsonNode response = req.getCommonRequestJsonNode();
        String actual = response.get("message").asText();
        return actual.equals(String.valueOf(messageValue));
    }
}
