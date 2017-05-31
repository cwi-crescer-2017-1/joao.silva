﻿using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public LivroRepositorio()
        {
        }
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }
        //POST   api/Livros (apenas cria, não altera)
        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        public void Delete(int livroIsbn)
        {
            Livro livro = (contexto.Livros.Where(x => x.Isbn == livroIsbn)).FirstOrDefault();
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }
    }
}
