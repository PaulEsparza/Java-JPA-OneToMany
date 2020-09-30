package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "table1")
public class Table1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_table1", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idT1;
    
    @Basic(optional = false)
    @Column(name = "campo1T1", nullable = false)
    private String campo1T1;
    
    @Basic(optional = false)
    @Column(name = "campo2T1", nullable = false)
    private String campo2T1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "table1")
    private List<Table2> table2 = new ArrayList<>();

    public Table1() {
    }

    public Table1(Integer id, String campo1T1, String campo2T1) {
        this.idT1 = id;
        this.campo1T1 = campo1T1;
        this.campo2T1 = campo2T1;
    }

    public Integer getIdT1() {
        return idT1;
    }

    public void setIdT1(Integer idT1) {
        this.idT1 = idT1;
    }

    public String getCampo1T1() {
        return campo1T1;
    }

    public void setCampo1T1(String campo1T1) {
        this.campo1T1 = campo1T1;
    }

    public String getCampo2T1() {
        return campo2T1;
    }

    public void setCampo2T1(String campo2T1) {
        this.campo2T1 = campo2T1;
    }

    public List<Table2> getTable2() {
        return table2;
    }

    public void setTable2(List<Table2> table2) {
        this.table2 = table2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idT1 != null ? idT1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Table1)) {
            return false;
        }
        Table1 other = (Table1) object;
        if ((this.idT1 == null && other.idT1 != null) || (this.idT1 != null && !this.idT1.equals(other.idT1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Table1[ id=" + idT1 + " campo1=" + campo1T1
                + "campo2=" + campo2T1;
    }
    
}
