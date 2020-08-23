import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { GenericService } from 'src/app/controller/services/generic.service';
import { PessoaModel } from 'src/app/model/pessoa.model';
import { Mensagens } from '../shared/components/mensagens';
import { CadastroPessoaComponent } from './cadastro-pessoa/cadastro-pessoa.component';

@Component({
  selector: 'app-pessoa',
  templateUrl: './pessoa.component.html',
  styleUrls: ['./pessoa.component.css']
})

export class PessoaComponent implements OnInit {

  //comunicação entre componetes
  @ViewChild(CadastroPessoaComponent) componetChild;

  //modelo
  pessoas: PessoaModel[];

  //tabela
  cols: any[];

  constructor(
    private genericService: GenericService,
    private messageService: MessageService,
    private router: Router
  ) {
  }

  //função que inicia o componente
  ngOnInit() {
    this.setUrl();
    this.getTableInfo();
    this.setParamsTable();
  }

  //função que define o tipo de endpoint 
  setUrl() {
    this.genericService.tipoUrl('pessoa');
  }

  //função que define os parâmetros para a criação da tabela
  setParamsTable() {
    this.cols = [
      { field: 'nome', header: 'Nome', width: '45%', align: 'left' },
      { field: 'sexo', header: 'Sexo', width: '20%', align: 'center' },
      { field: 'email', header: 'E-mail', width: '40%', align: 'left' },
      { field: 'dt_nascimento', header: 'Dt. Nasc.', width: '20%', align: 'center' },
      { field: 'naturalidade', header: 'Natu.', width: '23%', align: 'left' },
      { field: 'nacionalidade', header: 'Naci.', width: '23%', align: 'left' },
      { field: 'cpf', header: 'CPF', width: '25%', align: 'center' }
    ];
  }

  //função que consulta as informações cadastradas
  getTableInfo() {
    this.genericService.consultar()
      .subscribe(
        (resp) => {
          if (resp.body === undefined) {
            this.pessoas = [];
          } else {
            this.pessoas = resp.body;
          }
        })
      , error => {
        this.messageService.clear();
        this.messageService.add({
          severity: 'warn',
          summary: Mensagens.ConnectionErrorSummary,
          detail: Mensagens.ConnectionErrorDetail
        });
      }
  }

  //função que define os parametros de exclusão para o elemento filho
  getExcluir(event, pessoa) {
    this.componetChild.setFormRemove(pessoa);
    this.componetChild.displayExcluir = true;
  }

  //função que define os parametros de edição para o elemento filho
  getEditar(event, pessoa) {
    this.componetChild.setFormEdit(pessoa);
    this.componetChild.displayAdicionar = true;
  }

  //função que define os parametros de adição para o elemento filho
  getAdicionar() {
    this.componetChild.setFormAdd();
    this.componetChild.displayAdicionar = true;
  }

}