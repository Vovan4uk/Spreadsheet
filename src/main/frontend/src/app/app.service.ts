import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {FunctionCategory} from './model/functionCategory';
import {Function} from './model/function';
import {Spreadsheet} from "./model/spreadsheet";
import {SpreadsheetCell} from "./model/spreadsheetCell";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class AppService {

  constructor(private http: Http) {
  }

  getFunctionCategories(): Observable<FunctionCategory[]> {
    return this.http.get('api/function_category/')
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getFunctions(): Observable<Function[]> {
    return this.http.get('api/function/')
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getSpreadsheets(): Observable<Spreadsheet[]> {
    return this.http.get('api/spreadsheet/')
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getSpreadsheet(spreadsheet: Spreadsheet): Observable<SpreadsheetCell[][]> {
    return this.http.get(`api/spreadsheet/${spreadsheet.id}/`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  addSpreadsheet(name: string): Observable<Spreadsheet[]> {
    let spreadsheet: Spreadsheet = new Spreadsheet(null, name, null, []);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});

    return this.http.post('api/spreadsheet/', JSON.stringify(spreadsheet), options)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  deleteSpreadsheet(spreadsheet: Spreadsheet): Observable<Spreadsheet[]> {
    return this.http.delete(`api/spreadsheet/${spreadsheet.id}`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  updateCell(event: any, spreadsheetCell: SpreadsheetCell, spreadsheet: Spreadsheet): Observable<any> {
    spreadsheetCell.value = event.target.value;
    spreadsheetCell.spreadsheet = spreadsheet;
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});

    return this.http.put('api/spreadsheet_cell/', JSON.stringify(spreadsheetCell), options)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  addCell(event: any, spreadsheet: Spreadsheet, row: number, col: number): Observable<any> {
    let spreadsheetCell: SpreadsheetCell = new SpreadsheetCell(null, row, col, null, spreadsheet, event.target.value, null);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post('api/spreadsheet_cell/', JSON.stringify(spreadsheetCell), options)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
}
