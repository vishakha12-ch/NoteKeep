import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes,ActivatedRoute} from '@angular/router';
import { NoteService } from '../note.service';

@Component({
  selector: 'app-addnote',
  templateUrl: './addnote.component.html',
  styleUrls: ['./addnote.component.css']
})
export class AddnoteComponent implements OnInit {

  addnote: FormGroup;
  details:any;
  username:any;

  constructor(private noteservice: NoteService, private formBuilder:FormBuilder, private route:ActivatedRoute,private router:Router){}

  ngOnInit(): void {
    this.addnote = this.formBuilder.group({
      content: ['', [
          Validators.required,
          Validators.maxLength(500),
          Validators.pattern(/^[A-Za-z@;&*+\- ]+$/)
        ]]
    });
  }

  Add(){
    this.details = this.addnote.value;
    this.username = localStorage.getItem("username");
    this.noteservice.addnote(this.details,this.username ).subscribe(data =>{
      console.log(data);
      alert("Added successfully!!");
      this.addnote.reset({});
      this.router.navigate(['/note']);
    },
    error =>{
      console.log(error);
      alert("something went wrong!!");
    }
    )


  }

}
