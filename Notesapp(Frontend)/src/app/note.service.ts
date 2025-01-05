import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  url='http://localhost:8085';

  constructor(private http: HttpClient) { }

  login(token:any){
    localStorage.setItem('token',token);
    return true;
  }

  LoggedIn()
  {
    let token=localStorage.getItem('token');
    if(token==undefined || token==null || token =="")
    {
      return false;
    }
    else{
      return true;
    }
  }

  logout()
  {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    return true;
  }

  gettoken(){
    return localStorage.getItem('token');
  }

  logindetails(username:any){
    localStorage.setItem("username",username);
    return true;

  }

  token(data:any){
    return this.http.post(`${this.url}/gettoken`,data);
  }

  getnotes(username:any){
    return this.http.get(`${this.url}/getnote/${username}`);
  }

  deletenote(id: any){
    return this.http.delete(`${this.url}/delete/${id}`);
  }

  addnote(data:any,username:any){
    return this.http.post(`${this.url}/addnote/${username}`,data);
  }



}
