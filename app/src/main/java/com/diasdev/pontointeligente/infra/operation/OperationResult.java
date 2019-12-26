package com.diasdev.pontointeligente.infra.operation;

import com.diasdev.pontointeligente.constants.DataBaseConstants;

public class OperationResult<T> {

    public static final int NO_ERROR = -1;
    private int mError = NO_ERROR;
    private String mErrorMessage = "";
    private T anonimousType;

    public int getError() {
        return mError;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setmError(int error, String message){
        this.mError = error;
        this.mErrorMessage = message;
    }

    public T getResult() {
        return anonimousType;
    }

    public void setResult(T anonimousType) {
        this.anonimousType = anonimousType;
    }
}
