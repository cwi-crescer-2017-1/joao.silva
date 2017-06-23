/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula3tema;

import java.io.File;

/**
 *
 * @author jpedr
 */
/**
 * @author carloshenrique
 */
public interface SQLUtils {

    void runFile(String filename);

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File exportCSV(String query);

}
