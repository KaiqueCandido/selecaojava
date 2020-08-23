import { LoginService } from './../../../controller/services/login.service';
import { GenericService } from './../../../controller/services/generic.service';
import { MessageService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  //formulário e elementos
  loginForm: FormGroup

  constructor(
    private loginService: LoginService,
    private messageService: MessageService,
    private router: Router
  ) { }

  //função que inicia o componente
  ngOnInit() {
    this.setUrl();
    this.formComponent();
  }

  //função que define o tipo de endpoint 
  setUrl() {
    this.loginService.tipoUrl('authenticate');
  }

  //função que define o formulário 
  formComponent() {
    this.loginForm = new FormGroup({
      username: new FormControl((''), [Validators.required]),
      password: new FormControl((''), [Validators.required]),
    })
  }

  //função que chama a rota para home
  fazerLogin() {
    var addlogin = this.loginForm.value;
    this.loginService.logar(addlogin)
      .subscribe(
        (resp) => {
          this.messageService.clear();
          this.loginForm.reset();
          this.router.navigate(['home/pessoa']);
        }
      );
  }

}
