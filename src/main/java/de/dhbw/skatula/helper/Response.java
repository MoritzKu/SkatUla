/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.helper;

import de.dhbw.skatula.enums.ResponseStatus;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Diese Klasse soll alle Daten sammeln, die bei einer Datenbankabfrage erhoben
 * werden können. 
 *
 * @author Benjamin Kanzler
 */
@XmlRootElement
public class Response<E> {

    private List<E> responseList;

    private E response;

    private String message;

    private ResponseStatus status;

    private String exception;
    
    private StackTraceElement[] stackTrace;

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    public List<E> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<E> responseList) {
        this.responseList = responseList;
    }

    public E getResponse() {
        return response;
    }

    public void setResponse(E response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
