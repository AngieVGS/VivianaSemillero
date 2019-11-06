import { Component, OnInit } from '@angular/core';
import { Ejercicio } from '../../dto/ejercicio.dto';

/**
 * @description Componente con la informacion del autor y entrada dinamica
 * @author Angie Viviana Galindo Suarez / e-mail: ingangievgs@gmail.com
 */
@Component({
  selector: 'datos',
  templateUrl: './datos-component.html'
})
export class DatosComponent implements OnInit {

  /**
   * Nombre del autor
   */
  nombreAutor:string = "Angie Viviana Galindo Suarez";
  /**
   * ciudad
   */
  ciudad:string = "Tunja";

  public listaEjercicio : Array<any>;
  /**
   * variable que cambiara de estado cuando se haya eliminado un comic
   */
  public mostrarMensaje: boolean;

  constructor() { }

  ngOnInit() {
    this.inicializarVariablesGlobales();

  }

  public inicializarVariablesGlobales():void{
    this.mostrarMensaje = false;
    this.listaEjercicio = new Array<any>();

    //---------------Objeto 1 de la lista de Objetos 
    let ejercicioUno: Ejercicio = new Ejercicio();
    ejercicioUno.id = 1;
    ejercicioUno.nombre = "batman";
    ejercicioUno.editorial = "marvel";
    ejercicioUno.tematica = "accion";
    ejercicioUno.numeroPaginas = 50;
    ejercicioUno.precio = 60,500.99;
    ejercicioUno.autores = "Pedrito barrera";
    ejercicioUno.color = true;
    ejercicioUno.fechaVenta = new Date("10-10-2019");
    ejercicioUno.estado = "activo";
    this.listaEjercicio.push(ejercicioUno);
    
    //---------------Objeto 2 de la lista de Objetos 
    let ejercicioDos: Ejercicio = new Ejercicio();
    ejercicioDos.id = 2;
    ejercicioDos.nombre = "Spiderman";
    ejercicioDos.editorial = "marvel";
    ejercicioDos.tematica = "accion";
    ejercicioDos.numeroPaginas = 50;
    ejercicioDos.precio = 60,500.99;
    ejercicioDos.autores = "Pedrito barrera";
    ejercicioDos.color = true;
    ejercicioDos.fechaVenta = new Date("10-10-2019");
    ejercicioDos.estado = "activo";
    this.listaEjercicio.push(ejercicioDos);

    //---------------Objeto 3 de la lista de Objetos 
    let ejercicioTres: Ejercicio = new Ejercicio();
    ejercicioTres.id = 3;
    ejercicioTres.nombre = "Hulk";
    ejercicioTres.editorial = "marvel";
    ejercicioTres.tematica = "accion";
    ejercicioTres.numeroPaginas = 50;
    ejercicioTres.precio = 60,500.99;
    ejercicioTres.autores = "Pedrito barrera";
    ejercicioTres.color = true;
    ejercicioTres.fechaVenta = new Date("10-10-2019");
    ejercicioTres.estado = "activo";
    this.listaEjercicio.push(ejercicioTres);

    //---------------Objeto 4 de la lista de Objetos 
    let ejercicioCuatro: Ejercicio = new Ejercicio();
    ejercicioCuatro.id = 4;
    ejercicioCuatro.nombre = "Capitan America";
    ejercicioCuatro.editorial = "marvel";
    ejercicioCuatro.tematica = "accion";
    ejercicioCuatro.numeroPaginas = 50;
    ejercicioCuatro.precio = 60,500.99;
    ejercicioCuatro.autores = "Pedrito barrera";
    ejercicioCuatro.color = true;
    ejercicioCuatro.fechaVenta = new Date("10-10-2019");
    ejercicioCuatro.estado = "activo";
    this.listaEjercicio.push(ejercicioCuatro);

    //---------------Objeto 5 de la lista de Objetos 
    let ejercicioCinco: Ejercicio = new Ejercicio();
    ejercicioCinco.id = 5;
    ejercicioCinco.nombre = "Superman";
    ejercicioCinco.editorial = "marvel";
    ejercicioCinco.tematica = "accion";
    ejercicioCinco.numeroPaginas = 50;
    ejercicioCinco.precio = 60,500.99;
    ejercicioCinco.autores = "Pedrito barrera";
    ejercicioCinco.color = true;
    ejercicioCinco.fechaVenta = new Date("10-10-2019");
    ejercicioCinco.estado = "activo";
    this.listaEjercicio.push(ejercicioCinco);
    console.log(this.listaEjercicio);
  }
  

    /**
   * Metodo que elimina el comic con el inidice provisto
   * @param indiceAEliminar indice del comic a borrar
   */
  public deleteComic(indiceAEliminar: number): void {
    alert("Se elimino el objeto " + this.listaEjercicio[indiceAEliminar].nombre);
    this.listaEjercicio.splice(indiceAEliminar,1);
    this.mostrarMensaje = true;
  }

  /**
   * metodo que permite cambiar el valor de la variable mostrarMensaje
   */
  public ocultarMensaje(): void{
    this.mostrarMensaje = !this.mostrarMensaje;
  }
  
}