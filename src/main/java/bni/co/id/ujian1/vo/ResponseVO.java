package bni.co.id.ujian1.vo;

import lombok.Data;

@Data
public class ResponseVO<T> {
    private String statusCode;
    private String statusMessage;
    private T data;
}
