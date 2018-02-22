import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/Rx';
import {Observable} from "rxjs";

@Injectable()
export class SequenceFormService {

  constructor(private http: Http) { }

  generateSequence(n: number): Observable<string> {
    return this.http.get("/math/cos/sequence?n=" + n).map((response: Response) => response.text());
  }
}
