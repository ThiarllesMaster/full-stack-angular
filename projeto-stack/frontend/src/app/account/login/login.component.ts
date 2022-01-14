import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';
import { Token } from '@angular/compiler/src/ml_parser/tokens';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  login = {
    username: '', 
    password: ''
  }

  constructor(private authService: AuthService, 
             private router: Router ) { }

  ngOnInit(): void {
  }

  async onSubmit() {
    this.authService.login(this.login).subscribe((result) => {
      window.localStorage.setItem('token', result.token)
       })
    this.authService.pegarRole().subscribe(role => {
      window.localStorage.setItem('role', role.roleName)
    })   
    this.router.navigate([''])

  }

}
