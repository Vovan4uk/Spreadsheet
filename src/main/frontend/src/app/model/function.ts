import {FunctionCategory} from './functionCategory';

export class Function {
  constructor(
    public id: number,
    public name: string,
    public description: string,
    public createDate: Date,
    public functionCategory: FunctionCategory
  ){}
}
