package kg.alessand.task.errors;

public enum Errors {
    SUCCESS(0),
    ALREADY(1),
    ERROR(-1),
    NOT_FOUND(-2);

    private Integer code;

    Errors(Integer code){this.code = code;}
    public Integer getCode(){return  code;}
}
