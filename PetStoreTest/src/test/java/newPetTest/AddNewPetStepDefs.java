package newPetTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import communication.common.RequestType;
import io.cucumber.java.hu.Akkor;


public class AddNewPetStepDefs {
    static JsonNode commonResponse;
    AddNewPetRequestUtils apru = new AddNewPetRequestUtils();

    @Akkor("Hozzáadok a nyilvántartáshoz {string} azonosítóval {string} névvel egy {string}")
    public void addNewPetToStore(String id, String name, String categoryName) throws JsonProcessingException {
        commonResponse = apru.addNewPet(RequestType.POST, id, name, categoryName);
    }

    @Akkor("Ellenőrzöm a választ")
    public void checkResponse() throws JsonProcessingException {
        apru.assertResponse();
    }

    @Akkor("Ellenőrzöm az állat meglétét")
    public void checkPet() {
        apru.checkPet(RequestType.GET, String.valueOf(AddNewPetRequestUtils.ID));
    }
}
