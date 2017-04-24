import {SpreadsheetCell} from "./spreadsheetCell";

export class Spreadsheet {
  constructor(
    public id: number = null,
    public name: string,
    public createDate: Date = null,
    public spreadsheetCells: SpreadsheetCell[] = []
  ){}
}
