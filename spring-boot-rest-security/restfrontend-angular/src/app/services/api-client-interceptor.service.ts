import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConstantsService } from './constants.service';
import { isNull } from '@angular/compiler/src/output/output_ast';

@Injectable()
export class ApiClientInterceptorService implements HttpInterceptor {

  constructor(private constants: ConstantsService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):Observable<HttpEvent<any>> {
    let headers = null; 
    if(this.constants.AUTH_TOKEN !== null) {
      headers = req.headers.set("Content-Type", "application/json")
                  .set("Accept", "application/json")
                  .set("Authorization", `Bearer ${this.constants.AUTH_TOKEN}`);
    } else {
      headers = req.headers.set("Content-Type", "application/json")
                   .set("Accept", "application/json");
    }
    const request = req.clone({
      headers: headers 
    });
 
    // request.headers.set("Content-Type", "application/json");
    // request.headers.set("Accept", "application/json");
    // request.headers.set("Authorization", `Bearer ${this.constants.AUTH_TOKEN}`); 
    console.log(request.headers);
    return next.handle(request);
  }
}
