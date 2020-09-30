package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "table2")
public class Table2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_table2", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idT2;
    
    @Basic(optional = false)
    @Column(name = "campo1T2", nullable = false)
    private String campo1T2;
    
    @Basic(optional = false)
    @Column(name = "campo2T2", nullable = false)
    private String campo2T2;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_table1", referencedColumnName = "id_table1",
            insertable = true, updatable = true)
    private Table1 table1;

    public Table2() {
    }

    public Table2(Integer idT2, String campo1T2, String campo2T2, Table1 table1) {
        this.idT2 = idT2;
        this.campo1T2 = campo1T2;
        this.campo2T2 = campo2T2;
        this.table1 = table1;
    }

    public Table2(Integer idT2, String campo1T2, String campo2T2) {
        this.idT2 = idT2;
        this.campo1T2 = campo1T2;
        this.campo2T2 = campo2T2;
    }
    
    public Integer getIdT2() {
        return idT2;
    }

    public void setIdT2(Integer idT2) {
        this.idT2 = idT2;
    }

    public String getCampo1T2() {
        return campo1T2;
    }

    public void setCampo1T2(String campo1T2) {
        this.campo1T2 = campo1T2;
    }

    public String getCampo2T2() {
        return campo2T2;
    }

    public void setCampo2T2(String campo2T2) {
        this.campo2T2 = campo2T2;
    }

    public Table1 getTable1() {
        return table1;
    }

    public void setTable1(Table1 table1) {
        this.table1 = table1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idT2 != null ? idT2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Table2)) {
            return false;
        }
        Table2 other = (Table2) object;
        if ((this.idT2 == null && other.idT2 != null) || (this.idT2 != null && !this.idT2.equals(other.idT2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Table2[ id=" + idT2 + " "
                + " Table1 = " + table1 + " ]";
    }
    
}
