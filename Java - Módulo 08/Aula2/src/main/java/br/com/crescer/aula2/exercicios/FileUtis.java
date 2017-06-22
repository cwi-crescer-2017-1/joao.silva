/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.exercicios;

/**
 * @author carloshenrique
 */
public interface FileUtis {

    boolean mk(String string);

    boolean rm(String string);

    String ls(String string);

    boolean mv(String in, String out);
}
    