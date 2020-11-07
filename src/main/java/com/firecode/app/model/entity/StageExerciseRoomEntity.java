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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "stage_exercise_room", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StageExerciseRoomEntity.findAll", query = "SELECT s FROM StageExerciseRoomEntity s"),
    @NamedQuery(name = "StageExerciseRoomEntity.findById", query = "SELECT s FROM StageExerciseRoomEntity s WHERE s.id = :id")})
public class StageExerciseRoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "learning", nullable = false, length = 2147483647)
    private String learning;
    @Basic(optional = false)
    @Lob
    @Column(name = "decision", nullable = false, length = 2147483647)
    private String decision;
    @Lob
    @Column(name = "observation", length = 2147483647)
    private String observation;
    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;
    @JoinColumn(name = "id_team", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TeamEntity idTeam;

    public StageExerciseRoomEntity() {
    }

    public StageExerciseRoomEntity(Integer id) {
        this.id = id;
    }

    public StageExerciseRoomEntity(Integer id, String learning, String decision) {
        this.id = id;
        this.learning = learning;
        this.decision = decision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String learning) {
        this.learning = learning;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public SessionEntity getIdSession() {
        return idSession;
    }

    public void setIdSession(SessionEntity idSession) {
        this.idSession = idSession;
    }

    public TeamEntity getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(TeamEntity idTeam) {
        this.idTeam = idTeam;
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
        if (!(object instanceof StageExerciseRoomEntity)) {
            return false;
        }
        StageExerciseRoomEntity other = (StageExerciseRoomEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.StageExerciseRoomEntity[ id=" + id + " ]";
    }
    
}
