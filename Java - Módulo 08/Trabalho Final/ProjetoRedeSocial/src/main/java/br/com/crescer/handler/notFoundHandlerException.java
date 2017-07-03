/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jpedr
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notFoundHandlerException extends RuntimeException{
    public notFoundHandlerException(String message){
        super(message);
    }
}
