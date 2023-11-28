package checkPetTest;

import common.utils.HttpUtils;
import common.utils.Request;
import communication.common.RequestType;
import communication.http.HttpHelper;

public class CheckPetRequestUtils {
    Request req = new Request();
    HttpHelper hh = new HttpHelper();

    public void checkPet(RequestType requestType, String id) {
        req.setCommonRequest(String.valueOf(hh.sendJSONRequest(HttpUtils.setURL(requestType, id), null, null, null, requestType)));
    }
}
