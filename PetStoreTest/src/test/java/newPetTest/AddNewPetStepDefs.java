package newPetTest;

import communication.common.RequestType;
import io.cucumber.java.hu.Akkor;
import org.w3c.dom.Document;

public class AddNewPetStepDefs {
    static Document commonResponse;
    AddNewPetRequestUtils apru = new AddNewPetRequestUtils();

    @Akkor("Hozzáadok a nyilvántartáshoz {string} azonosítóval {string} névvel egy {string}")
    public void addNewPetToStore(String id, String name, String categoryName) {
        commonResponse = apru.addNewPet(RequestType.POST, id, name, categoryName);
    }
}
