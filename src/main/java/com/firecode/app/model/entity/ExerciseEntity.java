/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "exercise", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"file"}),
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"media"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExerciseEntity.findAll", query = "SELECT e FROM ExerciseEntity e"),
    @NamedQuery(name = "ExerciseEntity.findById", query = "SELECT e FROM ExerciseEntity e WHERE e.id = :id"),
    @NamedQuery(name = "ExerciseEntity.findByName", query = "SELECT e FROM ExerciseEntity e WHERE e.name = :name"),
    @NamedQuery(name = "ExerciseEntity.findByFile", query = "SELECT e FROM ExerciseEntity e WHERE e.file = :file"),
    @NamedQuery(name = "ExerciseEntity.findByMedia", query = "SELECT e FROM ExerciseEntity e WHERE e.media = :media")})
public class ExerciseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "file", nullable = false, length = 20)
    private String file;
    @Basic(optional = false)
    @Column(name = "media", nullable = false, length = 20)
    private String media;

    public ExerciseEntity() {
    }

    public ExerciseEntity(Integer id) {
        this.id = id;
    }

    public ExerciseEntity(Integer id, String name, String file, String media) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.media = media;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
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
        if (!(object instanceof ExerciseEntity)) {
            return false;
        }
        ExerciseEntity other = (ExerciseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ExerciseEntity[ id=" + id + " ]";
    }
    
}
