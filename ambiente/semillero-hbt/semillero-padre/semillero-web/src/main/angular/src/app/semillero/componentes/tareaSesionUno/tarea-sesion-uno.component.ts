import { Component, OnInit } from '@angular/core';

/**
 * @description Componente con la informacion del autor y entrada dinamica
 * @author Angie Viviana Galindo Suarez / e-mail: ingangievgs@gmail.com
 */
@Component({
  selector: 'app-tarea-sesion-uno',
  templateUrl: './tarea-sesion-uno.component.html'
})
export class TareaSesionUnoComponent implements OnInit {

  /**
   * Nombre del autor
   */
  nombreAutor:string = "Angie Viviana Galindo Suarez";
  /**
   * ciudad
   */
  ciudad:string = "Tunja";
  constructor() { }

  ngOnInit() {
  }

}