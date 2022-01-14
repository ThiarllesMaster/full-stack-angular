import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-listar-livro',
  templateUrl: './listar-livro.component.html',
  styleUrls: ['./listar-livro.component.css']
})
export class ListarLivroComponent implements OnInit {

  livros:Livro[] = []
  displayedColumns = ['titulo', 'categoria', 'exemplares', 'Ação']
  id: number = 0
  exibir:boolean = false

  constructor(private livroService: LivroService, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.livroService.listarLivros().subscribe(livros => {
      this.livros = livros
    })
    const role = window.localStorage.getItem('role')
    if (role?.toString() === "admin") {
      this.exibir = true
    }
  } 

  delete(id: number){
    if(window.confirm('Tem certeza que deseja remover o Livro?')){
      this.livroService.removerLivro(id).subscribe(() => {
        this.livroService.showMessage('Livro removido com sucesso!')        
      })    
   } 
   window.location.reload();
   this.router.navigate(['/livros'])
  }
}
