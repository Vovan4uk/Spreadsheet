package com.mev.perepeliuk.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "spreadsheet_cell")
public class SpreadsheetCell extends BasicDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "row", nullable = false)
    private Integer row;

    @NotNull
    @Column(name = "col", nullable = false)
    private Integer col;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "spreadsheet_id", nullable = false)
    @JsonBackReference
    private Spreadsheet spreadsheet;

    @Size(max = 255)
    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "function_id")
    private Function function;

    public SpreadsheetCell() {
    }

    public SpreadsheetCell(Integer row, Integer col, Spreadsheet spreadsheet, String value, Function function) {
        this.row = row;
        this.col = col;
        this.spreadsheet = spreadsheet;
        this.value = value;
        this.function = function;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
