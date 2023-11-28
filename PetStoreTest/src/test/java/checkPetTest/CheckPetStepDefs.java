package checkPetTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.utils.CommonUtils;
import common.utils.Request;
import communication.common.RequestType;
import io.cucumber.java.hu.Akkor;
import newPetTest.NewPetRequestUtils;


public class CheckPetStepDefs {
    NewPetRequestUtils apru = new NewPetRequestUtils();
    CheckPetRequestUtils chpru = new CheckPetRequestUtils();
    Request r = new Request();

    @Akkor("Ellenőrzöm az állat meglétét")
    public void checkPet() throws JsonProcessingException {
        chpru.checkPet(RequestType.GET, String.valueOf(CommonUtils.ID));
        r.setCommonRequestType(RequestType.GET);
        apru.checkPetSuccess();
    }
}
