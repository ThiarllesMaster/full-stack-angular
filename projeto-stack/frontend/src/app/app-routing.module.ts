import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './views/home/home.component'
import { LivroCrudComponent } from './views/livro-crud/livro-crud.component'
import { UtilizadorCrudComponent } from './views/utilizador-crud/utilizador-crud.component'
import { AdicionarLivroComponent } from './components/livro/adicionar-livro/adicionar-livro.component'
import { AuthenticationGuard } from './account/authentication.guard';
import { AuthenticationComponent } from './account/authentication/authentication.component';
import { MainComponent } from './layout/main/main.component';
import { LoginComponent } from './account/login/login.component';
import { BaseLayoutComponent } from './layout/base-layout/base-layout.component';

const routes: Routes = [ {path: '', component: BaseLayoutComponent, 
children: [
 {
   path: '', component: MainComponent, //Mostra todos os componentes default
   children: [
     {
       path: "home",
       component: HomeComponent
     },
     {
       path: "livros",
       component: LivroCrudComponent
     },
     {
       path: "utilizadores",
       component: UtilizadorCrudComponent
     }, 
     {
       path:"livro/adicionar", 
       component: AdicionarLivroComponent
     }
   ]
 }
], canActivate: [AuthenticationGuard]
}, 
{
 path: '', component: AuthenticationComponent, 
 children: [
   {path: '', redirectTo: 'login', pathMatch: 'full'}, 
   {path: 'login', component: LoginComponent}
 ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
