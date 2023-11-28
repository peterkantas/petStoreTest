package deletePetTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.utils.CommonUtils;
import common.utils.Request;
import communication.common.RequestType;
import io.cucumber.java.hu.Akkor;


public class DeletePetStepDefs {
    DeletePetRequestUtils apru = new DeletePetRequestUtils();
    Request r = new Request();

    @Akkor("Ellenőrzöm a törlés utáni választ")
    public void assertResponseAfterDeletion() throws JsonProcessingException {
        apru.assertResponseAfterDeletion();
    }

    @Akkor("Kitörlöm az általam felvitt állatot")
    public void deletePet() {
        apru.deletePet(RequestType.DELETE, String.valueOf(CommonUtils.ID));
        r.setCommonRequestType(RequestType.DELETE);
    }
}
