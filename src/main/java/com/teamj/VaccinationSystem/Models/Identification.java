package com.teamj.VaccinationSystem.Models;

import javax.persistence.*;

@Entity
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DocumentType type;
    @Column(unique = true)
    private int documentNumber;

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Identification{" +
                "id=" + id +
                ", type=" + type +
                ", documentNumber=" + documentNumber +
                '}';
    }
}
