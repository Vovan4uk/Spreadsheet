package com.mev.perepeliuk.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BasicDomain implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false, updatable = false)
    private Date createDate;

    public abstract Long getId();

    public abstract void setId(Long id);

    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
