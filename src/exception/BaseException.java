package exception;

public class BaseException extends RuntimeException {
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getCauseInfo() {
        return causeInfo;
    }

    public void setCauseInfo(Object causeInfo) {
        this.causeInfo = causeInfo;
    }

    private String errorCode;
    private String errorMsg;
    private Object causeInfo;

    public BaseException(){}

    public BaseException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorCode, String errorMsg, Object cause) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.causeInfo = cause;
    }

}
