import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilizador } from 'src/app/views/utilizador-crud/utilizador.model';
import { environment } from 'src/environments/environment';
import { UtilizadorInativado } from './model/UtilizadorInativado';


@Injectable({
  providedIn: 'root'
})
export class UtilizadoresService {

  baseUrl = environment.apiBaseUrl.concat('/utilizadores')

  constructor(private http : HttpClient) { }

  listarUtilizadores():Observable<Utilizador[]> {
    return this.http.get<Utilizador []>(this.baseUrl);
  }

  inativarUtilizador(utilizadorInativado: UtilizadorInativado):Observable<String> {
    return this.http.put<String>(this.baseUrl, utilizadorInativado)
  }


}
