import { Component, Inject, OnInit } from '@angular/core';
import { UtilizadoresService } from 'src/app/components/utilizadores/utilizadores.service';
import { Utilizador } from './utilizador.model';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { DialogComponent } from 'src/app/layout/dialog/dialog.component';
import { UtilizadorInativado } from 'src/app/components/utilizadores/model/UtilizadorInativado';

@Component({
  selector: 'app-utilizador-crud',
  templateUrl: './utilizador-crud.component.html',
  styleUrls: ['./utilizador-crud.component.css']
})
export class UtilizadorCrudComponent implements OnInit {

  utilizadorInativado: UtilizadorInativado = {
    id: 0,
    username:''
  }

  utilizadores: Utilizador[] = []
  exibir: boolean = false
  displayedColumns = ['nome','email', 'perfil', 'data-criacao', 'Ação']

  constructor(private utilizadorService: UtilizadoresService, 
    public dialog: MatDialog) { }

  ngOnInit(): void {
    const role = window.localStorage.getItem('role')
    if (role?.toString() === "admin") {
      this.exibir = true
      this.listarUtilizadores()
      }
  }

  listarUtilizadores() {
    this.utilizadorService.listarUtilizadores().subscribe( utilizadores => {
      this.utilizadores = utilizadores     
    })
  }

  openDialog(id:number, nome:string): void {
    const dialogRef = this.dialog.open(DialogComponent)

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('Você selecionou')
        console.log(nome)
        this.utilizadorInativado.id = id
        this.utilizadorInativado.username = nome
        this.utilizadorService.inativarUtilizador(this.utilizadorInativado)
         .subscribe(resposta => {
           console.log(resposta)
         })
        } 
    })
    
  }
}


