import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

@Component({
  selector: 'app-livro-crud',
  templateUrl: './livro-crud.component.html',
  styleUrls: ['./livro-crud.component.css']
})
export class LivroCrudComponent implements OnInit {

  exibir:boolean = false

  constructor(private router: Router) { }

  ngOnInit(): void {

    const role = window.localStorage.getItem('role')
    if (role?.toString() === "admin") {
      this.exibir = true
    }    
  }

  criarLivro():void {
     this.router.navigate(['/livro/adicionar'])
  }

}
