package mx.edu.mx.examenu2.utils;

public class Response<T>{
    Integer status;
    Boolean error;
    String message;
    T data;

    public Integer getStatus() {
        return status;
    }

    public Response(Integer status, Boolean error, String message, T data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
