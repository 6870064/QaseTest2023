package models;

import groovy.transform.BaseScript;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    boolean status;
    Result result;

}
