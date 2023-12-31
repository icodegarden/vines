package io.github.icodegarden.vines.data.biz.exception;

import com.fasterxml.jackson.annotation.JsonValue;
/**
 * 
 * @author Fangfang.Xu
 *
 */
public enum VinesErrorCode {

    GENERAL(2),
    AUTHENTICATION(10),
    JWT_TOKEN_EXPIRED(11),
    CREDENTIALS_EXPIRED(15),
    PERMISSION_DENIED(20),
    INVALID_ARGUMENTS(30),
    BAD_REQUEST_PARAMS(31),
    ITEM_NOT_FOUND(32),
    TOO_MANY_REQUESTS(33),
    TOO_MANY_UPDATES(34),
    SUBSCRIPTION_VIOLATION(40);

    private int errorCode;

    VinesErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }

}
