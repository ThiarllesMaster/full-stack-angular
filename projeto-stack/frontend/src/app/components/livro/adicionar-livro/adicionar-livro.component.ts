import { Component, OnInit } from '@angular/core';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';
import { Router } from '@angular/router'
import { Categoria } from '../categoria.model';
import { AuthService } from 'src/app/login/auth.service';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { LivroException } from '../livro.exception.model';
import { CampoException } from "../campo.livro.exception"

@Component({
  selector: 'app-adicionar-livro',
  templateUrl: './adicionar-livro.component.html',
  styleUrls: ['./adicionar-livro.component.css']
})
export class AdicionarLivroComponent implements OnInit {

  categoria: string = "";
  exibir:boolean = false

  categorias: Categoria[] = [
    {value: 'Informática', viewValue: 'Informática'},
    {value: 'Ciências', viewValue: 'Ciências'}
  ];

  livro: Livro = {
    titulo: "", 
    categoria: "", 
    exemplares: 0
  }

  exception: LivroException = {
    status: "", 
    titulo: ""    
  }

  constructor(private livroService: LivroService, 
    private router: Router, 
    private authService: AuthService) { }

  ngOnInit(): void {
    const role = window.localStorage.getItem('role')
    if (role?.toString() === "admin") {
      this.exibir = true
    }
  }

  adicionarLivro():void {
    this.livro.categoria = this.categoria
    //this.livroService.adicionarLivro(this.livro).subscribe(()=> {
    //  this.livroService.showMessage('Livro adicionado com sucesso')
    //  this.router.navigate(['/livros'])
        //})
    this.livroService.adicionarLivro(this.livro).subscribe({
      complete: () => 
      this.livroService.showMessage('Livro adicionado com sucesso'),
      error: err => {
        this.exception.status = err.error.status;
        this.exception.titulo = err.error.titulo
        this.exception.campos = err.error.campos
        console.log(this.exception)
        this.livroService.showMessage(JSON.stringify(this.exception))
      }   
    })
    
    this.router.navigate(['/livros'])
      
  }

  retornar():void {
    this.router.navigate(['/livros'])
  }

}
