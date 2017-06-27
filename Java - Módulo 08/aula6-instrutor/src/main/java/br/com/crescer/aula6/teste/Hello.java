package br.com.crescer.aula6.teste;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Hello {

    private String helloWorld = "aula6-instrutor!";
    
    public Hello(){
        System.out.println("Entrei no construtor");
    }
    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

}