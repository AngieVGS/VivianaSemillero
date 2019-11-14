import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ComicDTO } from '../../dto/comic.dto';
import { Location } from '@angular/common';

/**
 * @description Componenete ver comic,
 * el cual permite  observar la infromacion de un comic
 *
 * @author Angie Viviana Galindo <ingangievgs@gmail.com>
 */
@Component({
  selector: 'app-ver-comic',
  templateUrl: './ver-comic.component.html',
  styleUrls: ['./ver-comic.component.css']
})
export class VerComicComponent implements OnInit {

   /**
     * Atributo que contiene los controles del formulario
     */
    public verComicForm: FormGroup;
    /**
     * @description Este es el constructor del componente VerComicComponent
     * @author Angie Viviana Galindo <ingangievgs@gmail.com>
     */
    constructor(private router: Router,
      private activatedRoute: ActivatedRoute,
      private fb: FormBuilder,
      private location: Location) {
        this.verComicForm = this.fb.group({
          nombre: [null, Validators.required],
          editorial: [null],
          tematica: [null],
          coleccion: [null],
          numeroPaginas: [null],
          precio: [null],
          autores: [null],
          color: [null]
        });
    }
  /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Angie Viviana Galindo <ingangievgs@gmail.com>
     */

    ngOnInit() {
      let comic = this.activatedRoute.snapshot.params;
      this.verComicForm.controls.nombre.setValue(comic.nombre);
      this.verComicForm.controls.editorial.setValue(comic.editorial);
      this.verComicForm.controls.tematica.setValue(comic.tematica);
      this.verComicForm.controls.coleccion.setValue(comic.coleccion);
      this.verComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
      this.verComicForm.controls.precio.setValue(comic.precio);
      this.verComicForm.controls.autores.setValue(comic.autores);
      this.verComicForm.controls.color.setValue(comic.color);
      this.verComicForm.controls.nombre.disable();
      this.verComicForm.controls.editorial.disable();
      this.verComicForm.controls.tematica.disable();
      this.verComicForm.controls.coleccion.disable();
      this.verComicForm.controls.numeroPaginas.disable();
      this.verComicForm.controls.precio.disable();
      this.verComicForm.controls.autores.disable();
      this.verComicForm.controls.color.disable();
    }

      /**
     * @description metodo que permite regresar al componente gestionar comic
     * @author Angie Viviana Galindo <ingangievgs@gmail.com>
     */
    public navegarGestionarComic(): void {
      this.location.back();
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.verComicForm.controls;
    }

}
