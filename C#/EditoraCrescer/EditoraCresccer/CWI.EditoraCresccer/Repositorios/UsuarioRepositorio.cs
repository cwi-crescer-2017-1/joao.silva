using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.IO;
using System.Linq;
using System.Text;

namespace CWI.EditoraCresccer.Repositorios
{
    public class UsuarioRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        private Contexto contextoTeste = new Contexto();
        private List<string> mensagens = new List<string>();

        public UsuarioRepositorio() {}

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.Include(u => u.Permissoes).FirstOrDefault(usuario => usuario.Email == email);
        }
        public object Listar()
        {
            return contexto.Usuarios
                            .Select(usuario => new
                            {
                                Id = usuario.Id,
                                Nome = usuario.Nome,
                                Email = usuario.Email,
                                Permissoes = usuario.Permissoes
                            }).ToList();
        }
        public List<string> Criar(Usuario usuario)
        {
            if (usuarioValido(usuario,true,false))
            {
                contexto.Usuarios.Add(usuario);
                contexto.SaveChanges();
                return null;
            }
            return mensagens;
        }

        public MensagemUsuario Alterar(Usuario usuario)
        {
            if (usuarioValido(usuario,false,true))
            {
                contexto.Entry(usuario).State = EntityState.Modified;
                contexto.SaveChanges();
                return new MensagemUsuario(usuario, mensagens, true);
            }
            return new MensagemUsuario(usuario, mensagens, false);
        }
        public void Excluir(int id)
        {
            Usuario usuarioASerDeletado = contexto.Usuarios.FirstOrDefault(x => x.Id == id);
            if (usuarioASerDeletado != null)
            {
                contexto.Usuarios.Remove(usuarioASerDeletado);
                contexto.SaveChanges();
            }
        }
        public void Dispose()
        {
            contexto.Dispose();
        }

        private bool usuarioValido(Usuario usuario, bool criacao, bool alteracao)
        {
            mensagens.Clear();
            if (string.IsNullOrWhiteSpace(usuario.Nome))
                mensagens.Add("Nome inválido.");

            if (string.IsNullOrWhiteSpace(usuario.Email))
                mensagens.Add("Email inválido.");

            if (string.IsNullOrWhiteSpace(usuario.Senha))
                mensagens.Add("Senha inválida.");

            if (criacao)
            {
                bool emailJaCadastrado = contextoTeste.Usuarios.FirstOrDefault(x => x.Email == usuario.Email) != null;
                contextoTeste.Dispose();
                if (emailJaCadastrado)
                {
                    mensagens.Add("Email já cadastrado");
                }
            }
            if (alteracao)
            {
                bool usuarioNaoExistente = contextoTeste.Usuarios.FirstOrDefault(x => x.Id == usuario.Id) == null;
                contextoTeste.Dispose();
                if (usuarioNaoExistente)
                {
                    mensagens.Add("Este usuário não existe"+usuario.Id);
                }
            }
            return mensagens.Count == 0;
        }
    }
}