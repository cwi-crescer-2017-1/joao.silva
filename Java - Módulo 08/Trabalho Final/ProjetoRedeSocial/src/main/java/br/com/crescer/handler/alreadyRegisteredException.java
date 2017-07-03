/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.handler;

/**
 *
 * @author jpedr
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@ResponseBody
public class alreadyRegisteredException extends RuntimeException{
    public alreadyRegisteredException(String message){
        super(message);
    }
}
