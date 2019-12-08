public class StandardResponse {
    private ResponseStatus status;
    private String message;
    private User user;

    StandardResponse(ResponseStatus responseStatus) {
        this.status = responseStatus;
    }

    StandardResponse(ResponseStatus responseStatus, String message) {
        this.status = responseStatus;
        this.message = message;
    }

    public StandardResponse(ResponseStatus responseStatus, User responseData) {
        this.status = responseStatus;
        this.user = responseData;
    }
}
