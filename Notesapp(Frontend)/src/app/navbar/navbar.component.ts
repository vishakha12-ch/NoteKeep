import { Component, OnInit } from '@angular/core';
import { NoteService } from '../note.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  log:boolean=false;
  username:any=localStorage.getItem('username');
  constructor(public noteservice: NoteService, private router:Router){}

  ngOnInit(): void {
  }

  // this function to perform logout functionality
  
  Logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    this.router.navigate(['/home']);


  }

}
