package newPetTest;

import common.utils.CommonUtils;

import static common.utils.CommonUtils.ID;

public class Replacer {
    CommonUtils cu = new CommonUtils();

    String replaceID(String id, String requestString) {
        if (id != null) {
            if (id.equals("randomID")) {
                cu.randomIDGenerator();
            }
        } else {
            cu.throwNPE("id");
        }
        return requestString.replaceAll("##ID##", String.valueOf(ID));
    }

    String replaceName(String name, String requestString) {
        if (name != null) {
            requestString = requestString.replaceAll("##NAME##", name);
        } else {
            cu.throwNPE("name");
        }
        return requestString;
    }

    String replaceCategoryName(String categoryName, String requestString) {
        if (categoryName != null) {
            if (categoryName.equals("kutyát")) {
                categoryName = "dog";
            } else if (categoryName.equals("cicát")) {
                categoryName = "cat";
            }
            requestString = requestString.replaceAll("##CATEGORYNAME##", categoryName);
        } else {
            cu.throwNPE("categoryName");
        }
        return requestString;
    }
}
