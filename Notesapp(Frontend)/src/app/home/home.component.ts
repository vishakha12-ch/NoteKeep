import { Component , OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router, RouterModule, Routes} from '@angular/router';
import { NoteService } from '../note.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  implements OnInit{

  login: FormGroup;
  show:Boolean=false;
  message='User not Found!!'
  token:any;
  details:any;

  constructor(private formBuilder: FormBuilder, private router:Router,private noteservice: NoteService){}

  ngOnInit(): void {
    this.login = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  Login(){
    if(this.login.invalid) {
      return;
    }
    this.details=this.login.value;
    this.noteservice.token(this.details).subscribe((data:any)=>{
      this.token=data;
      this.noteservice.login(data.token);
      console.log("token",this.token);
      this.noteservice.logindetails(this.login.value.username);
      console.log('hii..')
      this.login.reset({});
      this.router.navigate(['/note']);
      
    },
    error=>{
      console.log(error);
      this.show=true;

    }
    ) 
  }
  Close(){
    this.show=false;
  }


}
