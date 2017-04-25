package com.mev.perepeliuk.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spreadsheet")
public class Spreadsheet extends BasicDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "spreadsheet", cascade = CascadeType.ALL)
    private Set<SpreadsheetCell> spreadsheetCells = new HashSet<>();

    public Spreadsheet() {
    }

    public Spreadsheet(String name, Set<SpreadsheetCell> spreadsheetCells) {
        this.name = name;
        this.spreadsheetCells = spreadsheetCells;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SpreadsheetCell> getSpreadsheetCells() {
        return spreadsheetCells;
    }

    public void setSpreadsheetCells(Set<SpreadsheetCell> spreadsheetCells) {
        this.spreadsheetCells = spreadsheetCells;
    }
}
