import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  items: any[];
  visibleSidebar2: boolean;

  user: string;
  perfil: string;

  constructor(
  ) { }

  ngOnInit() {
    this.initializeVariables();
  }

  //função que abre o sidebar
  openLink() {
    this.visibleSidebar2 = true;
  }

  //função que define os itens do botão
  initializeVariables() {
    this.items = [
      {
        label: 'Sair', icon: 'pi pi-power-off', routerLink: ['/login'], command: () => {
        }
      }
    ];
  }

}
