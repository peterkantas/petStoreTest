package utils;

import communication.common.RequestType;

public class HttpUtils {
    public static String setURL(RequestType type, String id) {
        return switch (type) {
            case POST -> "https://petstore.swagger.io/v2/pet";
            case GET, DELETE -> "https://petstore.swagger.io/v2/pet/" + id;
            case PUT, PATCH -> "nem volt scope";
        };
    }
}
