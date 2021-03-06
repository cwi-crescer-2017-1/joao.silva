﻿using ProdutoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace ProdutoraCrescer.Infraestrutura.Repositorio
{
    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto;

        public UsuarioRepositorio()
        {
            contexto = new Contexto();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.FirstOrDefault(usuario=> usuario.Email == email);
        }

        public List<string> Criar(dynamic u)
        {
            string nome = u.Nome;
            string senha = u.Senha;
            string email = u.Email;
            string permissao = u.Permissao;
            Usuario usuario = new Usuario(nome, senha, email, permissao);
            if (usuario.Validar())
            {
                contexto.Usuarios.Add(usuario);
                contexto.SaveChanges();
                return null;
            }
            return usuario.Mensagens;
        }

        public List<string> Alterar(dynamic u)
        { 
            Usuario usuario = new Usuario(u.Nome, u.Senha, u.Email, u.Cargo);

            if (usuario.Validar())
            {
                contexto.Entry(usuario).State = EntityState.Modified;
                contexto.SaveChanges();
                return null;
            }
            return usuario.Mensagens;
        }

        public void Excluir(int id)
        {
            Usuario usuario = contexto.Usuarios.FirstOrDefault(x => x.Id == id);
            if (usuario != null)
            {
                contexto.Usuarios.Remove(usuario);
                contexto.SaveChanges();
            }
        }
        public void Dispose()
        {
            contexto.Dispose();
        }
    }

}
