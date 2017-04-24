import {Component} from '@angular/core';
import {AppService} from './app.service';
import {FunctionCategory} from './model/functionCategory';
import {Function} from './model/function';
import {Spreadsheet} from "./model/spreadsheet";
import {SpreadsheetCell} from "./model/spreadsheetCell";

interface ITodo {
  title: string;
  completed: boolean;
}

const todos = [
  {
    title: 'add1',
    completed: true
  },
  {
    title: 'add2',
    completed: false
  },
  {
    title: 'add3',
    completed: false
  }
];

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'application works';
  functionCategories: FunctionCategory[] = [];
  functions: Function[] = [];
  spreadsheets: Spreadsheet[] = [];
  spreadsheet: Spreadsheet;
  spreadsheetName: string = '';
  spreadsheetData: SpreadsheetCell[][];

  constructor(private appService: AppService){
  }

  loadFunctionCategories(){
    this.appService.getFunctionCategories().subscribe(
      functionCategories => this.functionCategories = functionCategories,
      err => {
        console.log(err);
      });
  }

  loadFunctions(){
    this.appService.getFunctions().subscribe(
      functions => this.functions = functions,
      err => {
        console.log(err);
      });
  }

  loadSpreadsheets(){
    this.appService.getSpreadsheets().subscribe(
      spreadsheets => this.spreadsheets = spreadsheets,
      err => {
        console.log(err);
      });
  }

  loadSpreadsheet(spreadsheet){
    this.spreadsheet = spreadsheet;
    this.appService.getSpreadsheet(spreadsheet).subscribe(
      spreadsheetData => this.spreadsheetData = spreadsheetData,
      err => {
        console.log(err);
      });
    console.log(this.spreadsheetData);
  }
  addSpreadsheet(){
    this.appService.addSpreadsheet(this.spreadsheetName).subscribe(
      spreadsheets => this.spreadsheets = spreadsheets,
      err => {
        console.log(err);
      });
    this.spreadsheetName = '';
  }

  deleteSpreadsheet(spreadsheet: Spreadsheet) {
    this.appService.deleteSpreadsheet(spreadsheet).subscribe(
      spreadsheets => this.spreadsheets = spreadsheets,
      err => {
        console.log(err);
      });
  }

  ngOnInit(){
    this.loadFunctionCategories();
    this.loadFunctions();
    this.loadSpreadsheets();
  }
  updateCell(event: any, spreadsheetCell: SpreadsheetCell, spreadsheet: Spreadsheet){
    this.appService.updateCell(event, spreadsheetCell, spreadsheet).subscribe(
      spreadsheets => {},
      err => {});
    console.log(spreadsheetCell);
  }
  addCell(event: any, spreadsheet: Spreadsheet, row: number, col: number){
    this.appService.addCell(event, spreadsheet, row, col).subscribe(
      spreadsheets => {},
      err => {});
  }
  toggle(todo: ITodo) {
    todo.completed = !todo.completed;
  }

}
