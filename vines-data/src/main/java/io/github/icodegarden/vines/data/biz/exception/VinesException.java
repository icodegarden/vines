package io.github.icodegarden.vines.data.biz.exception;
/**
 * 
 * @author Fangfang.Xu
 *
 */
public class VinesException extends Exception {

    private static final long serialVersionUID = 1L;

    private VinesErrorCode errorCode;

    public VinesException() {
        super();
    }

    public VinesException(VinesErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public VinesException(String message, VinesErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public VinesException(String message, Throwable cause, VinesErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public VinesException(Throwable cause, VinesErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public VinesErrorCode getErrorCode() {
        return errorCode;
    }

}
