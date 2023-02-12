package com.jay.shop.product.catalog.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Exception and error code in-case of exception to user
 *
 * @author jay
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMessage;
    private List<ErrorInfo> details;

    public ServiceException() {
        this.errorCode = "CANNOT_PROCESS";
    }

    public ServiceException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<ErrorInfo> getDetails() {
        return details;
    }

    public void setDetails(List<ErrorInfo> details) {
        this.details = details;
    }

    public ServiceException addDetail(String subCode, String detailMessage) {
        if (null == getDetails()) {
            setDetails(new ArrayList<>());
        }
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setSubCode(subCode);
        errorInfo.setDetailMessage(detailMessage);
        getDetails().add(errorInfo);
        return this;
    }

    public class ErrorInfo {
        private static final long serialVersionUID = 2L;
        private String subCode;

        private String detailMessage;

        public String getSubCode() {
            return subCode;
        }

        public void setSubCode(String subCode) {
            this.subCode = subCode;
        }

        public String getDetailMessage() {
            return detailMessage;
        }

        public void setDetailMessage(String detailMessage) {
            this.detailMessage = detailMessage;
        }
    }
}