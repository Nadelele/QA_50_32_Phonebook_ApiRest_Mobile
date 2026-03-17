package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class ErrorMessage {
    private String timestamp;
    private int status;
    private String error;
    //private Map<String, String> message;
    //private String message;
    private Object message;
    private String path;
}
