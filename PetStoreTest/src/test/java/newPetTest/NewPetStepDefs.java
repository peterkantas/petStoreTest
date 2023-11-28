package newPetTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import common.utils.Request;
import communication.common.RequestType;
import io.cucumber.java.hu.Akkor;


public class NewPetStepDefs {
    static JsonNode commonResponse;
    NewPetRequestUtils apru = new NewPetRequestUtils();
    Request r = new Request();

    @Akkor("Hozzáadok a nyilvántartáshoz {string} azonosítóval {string} névvel egy {string}")
    public void addNewPetToStore(String id, String name, String categoryName) throws JsonProcessingException {
        commonResponse = apru.addNewPet(RequestType.POST, id, name, categoryName);
        r.setCommonRequestType(RequestType.POST);
    }

    @Akkor("Ellenőrzöm, hogy bekerült a nyilvántartásba")
    public void checkPetSuccess() throws JsonProcessingException {
        apru.checkPetSuccess();
    }
}
