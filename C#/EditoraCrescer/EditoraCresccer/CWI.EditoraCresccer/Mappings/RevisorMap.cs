using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity.ModelConfiguration;
using CWI.EditoraCresccer.Entidades;

namespace CWI.EditoraCresccer.Mappings
{
    internal class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");

            Property(a => a.Nome)
                    .HasMaxLength(300);
        }
    }
}
