import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MessageService, SelectItem } from 'primeng/api';
import { GenericService } from 'src/app/controller/services/generic.service';
import { Mensagens } from '../../shared/components/mensagens';
import { CommonServices } from 'src/app/controller/services/common.service';
import { SexoEnum } from 'src/app/enums/sexo.enum';

@Component({
  selector: 'app-cadastro-pessoa',
  templateUrl: './cadastro-pessoa.component.html',
  styleUrls: ['./cadastro-pessoa.component.css']
})

export class CadastroPessoaComponent implements OnInit {

  //comunicação entre componetes
  @Input() item: Array<any>;
  @Output() eventOutput = new EventEmitter;

  //formulário e elementos
  cadastroForm: FormGroup;
  pessoaId: string;
  pessoaNome: string;
  labelDialog: string;
  lstSexo: SelectItem[];

  //booleans
  displayAdicionar: boolean;
  displayExcluir: boolean;
  isEditar: boolean;

  //filter
  filtered: any[];
  selected: string;

  constructor(
    private genericService: GenericService,
    private messageService: MessageService,
    private commonServices: CommonServices
  ) { }

  //função que inicia o componente
  ngOnInit() {
    this.setUrl();
    this.formComponent();
    this.initializeComponents();
  }
  
  //função que inicializa os componentes da pagina
  initializeComponents() {
    this.lstSexo = [
      {label: 'Masculino', value: SexoEnum.Masculino},
      {label: 'Feminino', value: SexoEnum.Feminino}, 
    ];
  }

  //função que define o formulário 
  formComponent() {
    this.cadastroForm = new FormGroup({
      id: new FormControl(),
      nome: new FormControl((''), [Validators.required]),
      sexo: new FormControl(('')),
      email: new FormControl(('')),
      dt_nascimento: new FormControl(('')),
      naturalidade: new FormControl(('')),
      nacionalidade: new FormControl(('')),
      cpf: new FormControl((''), [Validators.required]),
      endereco: new FormControl(('')),
    });
  }

  //função que define o tipo de endpoint 
  setUrl() {
    this.genericService.tipoUrl('pessoa');
  }

  //função que seta os parâmetros para adição
  setFormAdd() {
    this.cadastroForm.reset();
    this.labelDialog = 'Adição de Pessoa';
    this.isEditar = false;
  }

  //função que seta os parâmetros para edição
  setFormEdit(item) {
    console.log(item);
    this.cadastroForm.controls.id.setValue(item.id);
    this.cadastroForm.controls.nome.setValue(item.nome);
    this.cadastroForm.controls.sexo.setValue(item.sexo);
    this.cadastroForm.controls.email.setValue(item.email);
    this.cadastroForm.controls.dt_nascimento.setValue(new Date(item.dt_nascimento));
    this.cadastroForm.controls.naturalidade.setValue(item.naturalidade);
    this.cadastroForm.controls.nacionalidade.setValue(item.nacionalidade);
    this.cadastroForm.controls.cpf.setValue(item.cpf);
    this.cadastroForm.controls.endereco.setValue(item.endereco);
    this.labelDialog = 'Edição de Pessoa';
    this.isEditar = true;
  }

  //função que seta os parâmetros para remoção
  setFormRemove(item) {
    this.pessoaNome = item.nome;
    this.pessoaId = item.id;
    this.isEditar = false;
  }

  //função que cancela a interação e limpa o furmulário
  cancelar() {
    this.displayAdicionar = false;
    this.cadastroForm.reset();
  }

  //função para permitir apenas número no input
  numberOnly(event): boolean {
    return this.commonServices.numberOnly(event);
  }

  //função para adicionar o elemento selecionado
  salvar() {
    var addPessoa = this.cadastroForm.value;
    this.genericService.cadastrar(addPessoa)
      .subscribe(
        (resp) => {
          this.messageService.clear();
          this.messageService.add({
            severity: 'success',
            summary: Mensagens.CadastroSummary,
            detail: Mensagens.CadastroDetail
          });
          this.eventOutput.emit();
          this.cadastroForm.reset();
          this.displayAdicionar = false;
        }, error => {
          this.messageService.clear();
          this.messageService.add({
            severity: 'warn',
            summary: Mensagens.CadastroErroSummary,
            detail: error.error.code === 409 ? Mensagens.CadastroErroCpfDuplicadoDetail : Mensagens.CadastroErroDetail
          });
          this.cadastroForm.reset();
        }
      );
  }

  //função para alterar o elemento selecionado
  editar() {
    var addPessoa = this.cadastroForm.value;
    this.genericService.editar(addPessoa)
      .subscribe(
        (resp) => {
          this.messageService.clear();
          this.messageService.add({
            severity: 'success',
            summary: Mensagens.AtualizarSummary,
            detail: Mensagens.AtualizarDetail
          });
          this.eventOutput.emit();
          this.cadastroForm.reset();
          this.displayAdicionar = false;
        }, error => {
          this.messageService.clear();
          this.messageService.add({
            severity: 'error',
            summary: Mensagens.AtualizarErroSummary,
            detail: error.error.code === 406 ? Mensagens.AtualizarEnderecoObrigatorio : Mensagens.AtualizarErroDetail
          });
        }
      );
  }

  //função para remover o elemento selecionado
  excluir() {
    this.genericService.remover(this.pessoaId)
      .subscribe(
        (resp) => {
          this.messageService.clear();
          this.messageService.add({
            severity: 'success',
            summary: Mensagens.ExcluirSummary,
            detail: Mensagens.ExcluirDetail
          });
          this.eventOutput.emit();
          this.displayExcluir = false;
        }, error => {
          this.messageService.clear();
          this.messageService.add({
            severity: 'error',
            summary: Mensagens.ExcluirErroSummary,
            detail: Mensagens.ExcluirErroDetail
          });
        }
      );
  }

  //função que define valor ao item selecionado
  selectedValue(event) {
    if (event) {
      this.cadastroForm.controls.turma.setValue(event);
    }
  }

  getDataInicio(event) {
    this.cadastroForm.controls.dt_nascimento.setValue(event)
}

}
