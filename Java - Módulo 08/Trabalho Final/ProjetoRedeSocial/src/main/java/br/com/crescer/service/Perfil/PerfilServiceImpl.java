/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Perfil;

import br.com.crescer.entity.Perfil;
import br.com.crescer.repository.PerfilRepository;
import br.com.crescer.repository.UsuarioRepository;
import java.util.ArrayList;
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
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Perfil> findAll() {
        return (List<Perfil>) perfilRepository.findAll();
    }

    @Override
    public List<Perfil> findByNameWithFriendship(Long idPerfil, String nome) {
        List<Perfil> pessoasPesquisadas = perfilRepository.findByNomeStartsWith(nome);
        return adicionaNovoAtributosInformativos(pessoasPesquisadas, idPerfil);
    }

    @Override
    public List<Perfil> fiendPeopleWithRelation(Long idPerfil) {
        List<Perfil> pessoasGerais = adicionaNovoAtributosInformativos((List<Perfil>) perfilRepository.findAll(), idPerfil);
        List<Perfil> resultado = new ArrayList<>();
        pessoasGerais.stream()
                .filter((p) -> (p.getIsRequested() || p.getIsFriend() || p.getPendingRequest()))
                .forEachOrdered(resultado::add);
        return resultado;
    }

    private List<Perfil> adicionaNovoAtributosInformativos(List<Perfil> pessoasPesquisadas, Long idPerfil) {
        List<Perfil> amigos = perfilRepository.Perfil_fiendFriends(idPerfil);
        List<Perfil> amigosSolicitados = perfilRepository.Perfil_fiendPendingFriends(idPerfil);
        List<Perfil> pessoasSolicitantes = perfilRepository.Perfil_fiendRequestedFriendship(idPerfil);
        for (int i = 0; i < pessoasPesquisadas.size(); i++) {
            Perfil pessoaPesquisada = pessoasPesquisadas.get(i);
            for (int x = 0; x < amigos.size(); x++) {
                Perfil amigo = amigos.get(x);
                if (pessoaPesquisada.getId().longValue() == amigo.getId().longValue()) {
                    pessoaPesquisada.setIsFriend(true);
                    break; //Descobriu que o perfil é amigo, configura e passa para a próxima pessoa
                } else {
                    pessoaPesquisada.setIsFriend(false);
                }
            }
            for (int y = 0; y < amigosSolicitados.size(); y++) {
                Perfil solicitado = amigosSolicitados.get(y);
                if (pessoaPesquisada.getId().longValue() == solicitado.getId().longValue()) {
                    pessoaPesquisada.setPendingRequest(true);
                    break; //Descobriu que a solicitação de amizade esta pendente, configura o retorno e passa para a próxima pessoa
                } else {
                    pessoaPesquisada.setPendingRequest(false);
                }
            }
            for (int z = 0; z < pessoasSolicitantes.size(); z++) {
                Perfil solicitante = pessoasSolicitantes.get(z);
                if (pessoaPesquisada.getId().longValue() == solicitante.getId().longValue()) {
                    pessoaPesquisada.setIsRequested(true);
                    break; //Descobriu que o perfil enviou uma solicitação de amizade ao perfil corrente, configurou a resposta com a informação e passou para o próximo perfil
                } else {
                    pessoaPesquisada.setIsRequested(false);
                }
            }
        }
        return pessoasPesquisadas;
    }

    @Override
    public Page<Perfil> findPage(int page, int size) {
        return perfilRepository.findAll(new PageRequest(page, size));
    }

    public List<Perfil> findByName(String nome) {
        return perfilRepository.findByNome(nome);
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public void delete(Perfil perfil) {
        perfilRepository.delete(perfil);
    }

    @Override
    public Perfil findOne(Long id) {
        return perfilRepository.findOne(id);
    }
}
