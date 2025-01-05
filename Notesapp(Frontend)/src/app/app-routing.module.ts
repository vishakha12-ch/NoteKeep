import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guard/auth.guard';

import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NoteComponent } from './note/note.component';
import { AddnoteComponent } from './addnote/addnote.component';

const routes: Routes = [
  {
    path:'home',
    component:HomeComponent,
    pathMatch:'full'
  },

  {
    path:"note",
    component:NoteComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],
  },
  {
    path:"addnote",
    component:AddnoteComponent,
    pathMatch:'full',
    canActivate:[AuthGuard],
  },

  {
    path:'',
    component:DashboardComponent,
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
