/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Relacionamento;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Relacionamento;
import br.com.crescer.repository.PerfilRepository;
import br.com.crescer.repository.RelacionamentoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author joao.silva
 */
@Service
public class RelacionamentoServiceImpl implements RelacionamentoService {

    @Autowired
    RelacionamentoRepository relacionamentoRepository;

    @Autowired
    PerfilRepository perfilRepository;
    
    @Override
    public List<Relacionamento> findAll() {
        return (List<Relacionamento>) relacionamentoRepository.findAll();
    }

    @Override
    public Page<Relacionamento> findPage(int page, int size) {
        return relacionamentoRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Relacionamento save(Relacionamento relacionamento) {
        Relacionamento existente = relacionamentoRepository.findOneByPerfilSolicitanteAndPerfilSolicitado(relacionamento.getPerfilSolicitante(), relacionamento.getPerfilSolicitado());
        Relacionamento existenteInverso = relacionamentoRepository.findOneByPerfilSolicitanteAndPerfilSolicitado(relacionamento.getPerfilSolicitado(), relacionamento.getPerfilSolicitante());
        if(existente == null && existenteInverso == null){
             relacionamento.setDataSolicitacao(new Date());
             relacionamento.setPendente(Boolean.TRUE);
             relacionamento.setResposta(null);
             relacionamento.setDataResposta(null);
        }else if(existente != null && existente.getResposta() == null){
            existente.setDataResposta(new Date());
            existente.setPendente(Boolean.FALSE);
            existente.setResposta(Boolean.TRUE);
        }else if(existenteInverso != null && existenteInverso.getResposta() == null){ //existenteInverso != null
            existenteInverso.setDataResposta(new Date());
            existenteInverso.setPendente(Boolean.FALSE);
            existenteInverso.setResposta(Boolean.TRUE);
        }else if(existente != null){
            return existente;
        }else if(existenteInverso != null){
            return existenteInverso;
        }
        return relacionamentoRepository.save(relacionamento);
    }

    @Override
    public void delete(Relacionamento relacionamento) {
        relacionamentoRepository.delete(relacionamento);
    }

    @Override
    public Relacionamento findOne(Long id) {
        return relacionamentoRepository.findOne(id);
    }

    @Override
    public Relacionamento responder(Relacionamento relacionamento, Boolean resposta) {
        relacionamento.setDataResposta(new Date());
        relacionamento.setPendente(Boolean.FALSE);
        relacionamento.setResposta(resposta);
        return relacionamentoRepository.save(relacionamento);
    }

    @Override
    public void removerAmigo(Long idPerfilUsuario, Perfil perfilAmigo) {
        Perfil perfilUsuario = perfilRepository.findOne(idPerfilUsuario);
        Relacionamento existente = relacionamentoRepository.findOneByPerfilSolicitanteAndPerfilSolicitado(perfilUsuario, perfilAmigo);
        Relacionamento existenteInverso = relacionamentoRepository.findOneByPerfilSolicitanteAndPerfilSolicitado(perfilAmigo, perfilUsuario);
        if(existente!=null){
            relacionamentoRepository.delete(existente);
        }
        if(existenteInverso!=null){
            relacionamentoRepository.delete(existenteInverso);
        }
    }

    public Relacionamento findOneByPerfil(Long idPerfil1, Long idPerfil2) {
        Perfil perfilUm = perfilRepository.findOne(idPerfil1);
        Perfil perfilDois = perfilRepository.findOne(idPerfil2);
        Relacionamento retorno_um = relacionamentoRepository.findOneByPerfilSolicitanteAndPerfilSolicitado(perfilUm, perfilDois);
        if(retorno_um != null){
            return retorno_um;
        }else{
            Relacionamento retorno_dois = relacionamentoRepository.findOneByPerfilSolicitanteAndPerfilSolicitado(perfilDois,perfilUm);
            if(retorno_dois != null){
                 return retorno_dois;
            }else{
                return null;
            }
        }
    }
}
