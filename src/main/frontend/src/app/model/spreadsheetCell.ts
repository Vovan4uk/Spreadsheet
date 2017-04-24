import {Function} from './function';
import {Spreadsheet} from "./spreadsheet";

export class SpreadsheetCell {
  constructor(
    public id: number,
    public row: number,
    public col: number,
    public createDate: Date,
    public spreadsheet: Spreadsheet,
    public value: string,
    public _function: Function
  ){}
}
