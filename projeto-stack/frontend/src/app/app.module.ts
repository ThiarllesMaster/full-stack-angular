import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component'
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';

import { MatSidenavModule } from '@angular/material/sidenav'
import { MatListModule } from '@angular/material/list';
import { HomeComponent } from './views/home/home.component'
import { MatCardModule } from '@angular/material/card';
import { LivroCrudComponent } from './views/livro-crud/livro-crud.component';
import { UtilizadorCrudComponent } from './views/utilizador-crud/utilizador-crud.component'
import { MatButtonModule } from '@angular/material/button';
import { AdicionarLivroComponent } from './components/livro/adicionar-livro/adicionar-livro.component'
import { LivroService } from './components/livro/livro.service'
import { MatSnackBarModule } from '@angular/material/snack-bar'
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { FormsModule } from '@angular/forms'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatInputModule } from '@angular/material/input'
import {MatSelectModule} from '@angular/material/select';
import { ListarLivroComponent } from './components/livro/listar-livro/listar-livro.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MainComponent } from './layout/main/main.component';
import { AuthenticationComponent } from './account/authentication/authentication.component';
import { LoginComponent } from './account/login/login.component';
import { BaseLayoutComponent } from './layout/base-layout/base-layout.component';
import { AuthService } from './login/auth.service';
import { AuthInterceptor } from './http-interceptors/auth.interceptor';
import { DialogComponent } from './layout/dialog/dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    LivroCrudComponent,
    UtilizadorCrudComponent,
    AdicionarLivroComponent,
    ListarLivroComponent,
    MainComponent,
    AuthenticationComponent,
    LoginComponent,
    BaseLayoutComponent,
    DialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, 
    MatToolbarModule, 
    MatSidenavModule, 
    MatListModule, 
    MatCardModule, 
    MatButtonModule, 
    MatSnackBarModule, 
    HttpClientModule, 
    FormsModule, 
    MatFormFieldModule,
    MatInputModule, 
    MatSelectModule, MatTableModule, MatPaginatorModule, MatSortModule, 
    MatDialogModule

  ],
  providers: [LivroService, AuthService, 
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
