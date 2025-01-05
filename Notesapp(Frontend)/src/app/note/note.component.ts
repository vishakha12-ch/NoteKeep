import { Component, OnInit } from '@angular/core';
import { NoteService } from '../note.service';
import { Router ,ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent  implements OnInit {

  notelist:any;
  show:Boolean=false;
  list:any;
  username:any;

  constructor(public noteservice:NoteService, private routers:ActivatedRoute,private router:Router ){}

  ngOnInit(): void {
    this.username = localStorage.getItem("username");
    this.noteservice.getnotes(this.username).subscribe(data =>{
      this.notelist=data;
      console.log(this.notelist);
      if(this.notelist.length<=0){
        this.show = true;
      }

    },
    error =>{
      console.log(error);
    }
    )

}

delete(id: any){
  this.noteservice.deletenote(id).subscribe((result) =>{
    console.warn('result',result);
    window.location.reload();
    this.router.navigate(['/note']);
  });
  
}

}
