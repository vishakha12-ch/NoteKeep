import { HttpInterceptor,HttpRequest,HttpHandler,HttpEvent } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { NoteService } from "../note.service";

@Injectable()

// this class add token with header for every request

export class AuthInterceptor implements HttpInterceptor{

    constructor(private noteservice:NoteService){ }

    intercept(req:HttpRequest<any>, next:HttpHandler): Observable<HttpEvent<any>> {

        let request=req;
        let token = this.noteservice.gettoken();
        console.log("istoken",token);
        if(token!=null){
            request=request.clone({setHeaders:{Authorization:`Bearer ${token}`}});
        }

        return next.handle(request);

        }

}