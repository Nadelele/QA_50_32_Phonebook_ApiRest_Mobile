package utils;

import com.google.gson.Gson;
import dto.ErrorMessage;
import dto.ResponseMessage;
import dto.Token;

import java.io.IOException;

public interface BaseApi {
    String BASE_URL = "https://contactapp-telran-backend.herokuapp.com";
    String BASE_HTTP_URL = "http://contactapp-telran-backend.herokuapp.com";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    String LOGIN_URL = "/v1/user/login/usernamepassword";
    String ADD_CONTACT_URL = "/v1/contacts";
    String GET_ALL_CONTACTS_URL = "/v1/contacts";
    String EDIT_CONTACT_URL = "/v1/contacts";
    String DELETE_CONTACT_URL = "/v1/contacts/";

    Gson GSON = new Gson();


}
