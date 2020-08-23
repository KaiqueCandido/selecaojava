import { SexoEnum } from './../enums/sexo.enum';
export class PessoaModel {
    constructor(
        public id: string,
        public nome: string,
        public sexo: SexoEnum,
        public email: string,
        public dt_nascimento: Date,
        public naturalidade: string,
        public nacionalidade: string,
        public cpf: string,
        public endereco: string,
        ) { }
    }