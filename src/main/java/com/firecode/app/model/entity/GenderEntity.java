package com.firecode.app.model.entity;

import com.firecode.app.controller.util.AppUtil;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "gender", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"})})

public class GenderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGender")
    private Collection<CoacheeEntity> coacheeEntityCollection;

    public GenderEntity() {
    }

    public GenderEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        if (name != null) {
            return AppUtil.convertFirstUppercaseCharacter(name);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<CoacheeEntity> getCoacheeEntityCollection() {
        return coacheeEntityCollection;
    }

    public void setCoacheeEntityCollection(Collection<CoacheeEntity> coacheeEntityCollection) {
        this.coacheeEntityCollection = coacheeEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenderEntity)) {
            return false;
        }
        GenderEntity other = (GenderEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.GenderEntity[ id=" + id + " ]";
    }

}
