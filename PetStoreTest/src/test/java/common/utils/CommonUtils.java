package common.utils;

import assertion.json.JsonAssert;
import com.fasterxml.jackson.core.JsonProcessingException;
import communication.common.RequestType;
import deletePetTest.DeletePetRequestUtils;
import org.junit.Assert;

import java.util.Random;

public class CommonUtils {
    public static Integer ID;
    Request req = new Request();
    DeletePetRequestUtils dpru = new DeletePetRequestUtils();

    public void randomIDGenerator() {
        Random rand = new Random();
        ID = rand.nextInt(1,1000);
    }

    public void throwNPE(String type) {
        switch (type) {
            case "name" -> throw new NullPointerException("No name, so I can't add an animal");
            case "id" -> throw new NullPointerException("No ID, so I can't add an animal");
            case "categoryName" ->
                    throw new NullPointerException("No Category Name, so I can't add an animal");
            case "check" -> throw new NullPointerException("No ID so there is nothing to check");
        }
    }

    public void assertResponse() throws JsonProcessingException {
        if (req.getCommonRequestType() == RequestType.DELETE) {
            Assert.assertTrue(dpru.checkDeletionSuccess(String.valueOf(ID)));
        } else {
            JsonAssert.jsonAssertWithFile(req.getCommonRequestJsonNode(), "id", "", null, "", String.valueOf(ID));
        }
    }
}
