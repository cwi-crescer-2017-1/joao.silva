/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.run;

import br.com.crescer.CrudDao;
import br.com.crescer.CrudDaoImpl;
import br.com.crescer.Funcionario;

/**
 *
 * @author jpedr
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        CrudDaoImpl crudDao = new CrudDaoImpl();
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("QUARENTA");
        funcionario.setRg("123456789");
        Funcionario funcionarioRetorno = ((Funcionario) crudDao.save(funcionario)).clone();
        funcionarioRetorno.setNome("QUARENTA_NOVO");
        funcionarioRetorno.setRg("111111111");
        crudDao.merge(funcionarioRetorno);
        crudDao.closeConnections();
    }
}
