package newPetTest;

import communication.common.RequestType;
import communication.http.HttpHelper;
import org.w3c.dom.Document;
import utils.HttpUtils;

import java.util.UUID;

import static utils.FileUtils.readFromInputStream;

public class AddNewPetRequestUtils {
    private static final String[] addNewPetheaders = {"Content-Type", "application/json"};
    private static String commonRequest;
    public static String ID;

    public Document addNewPet(RequestType requestType, String id, String name, String categoryName) {
        setcommonRequest(id, name, categoryName);
        return HttpHelper.sendPOSTRequest(HttpUtils.setURL(requestType,id), addNewPetheaders, commonRequest);
    }

    private void setcommonRequest(String id, String name, String categoryName) {
        String requestString = readFromInputStream(AddNewPetRequestUtils.class.getResourceAsStream("/addNewPet.json"));
        if (id != null) {
            if (id.equals("randomID")) {
                id = UUID.randomUUID().toString();
                ID = id;
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
            requestString = requestString.replaceAll("##CATEGORYNAME##", categoryName);
        } else {
            throwNPE("categoryName");
        }
        commonRequest = requestString;
    }

    private void throwNPE(String type) {
        switch (type) {
            case "name" -> throw new NullPointerException("Nincs név, így nem tudok hozzáadni állatot");
            case "id" -> throw new NullPointerException("Nincs ID, így nem tudok hozzáadni állatot");
            case "categoryName" -> throw new NullPointerException("Nincs kategória név, így nem tudok hozzáadni állatot");
        }
    }
}
