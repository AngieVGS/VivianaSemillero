import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuariosService } from '../../services/usuario.service';
import { PersonaDTO } from '../../dto/persona.dto';
import { UsuarioDTO } from '../../dto/Usuario.dto';

/**
 * @description Componenete gestionar usuario, el cual contiene la logica CRUD
 *
 * @author Angie Viviana Galindo Suarez
 */
@Component({
  selector: 'gestionar-usuario',
  templateUrl: './gestionar-usuario.component.html',
  styleUrls: ['./gestionar-usuario.component.css']
})
export class GestionarUsuarioComponent implements OnInit {
 /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarUsuarioForm: FormGroup;

    /**
     * Atributo que contendra la informacion del usuario
     */
    public usuario: UsuarioDTO;
    /**
     * Atributo que contendra la informacion del usuario
     */
    public persona: PersonaDTO;

    /**
   * lista de personas que se tienen en la base de datos
   */
  public listaPersonas: Array<PersonaDTO>;

  /**
   * lista de usuarios que se tienen en la base de datos
   */
  public listaUsuarios: Array<UsuarioDTO>;

    /**
     * Atributo que contendra el id de un usuario
     *  cuando se desea consultar o editar o eliminar
     */
    public uid: number = 0;

     /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    /**
     * @description Este es el constructor del componente GestionarUsuarioComponent
     * @author Angie Viviana Galindo Suarez
     *      */
  /**
   * constructor del componente
   * @param fb
   * @param router
   * @param _usuarioService
   */
  constructor(private fb: FormBuilder,
    private router: Router,
    private _usuarioService: UsuariosService) {
    this.gestionarUsuarioForm = this.fb.group({
      SCNOMBRE: [null, Validators.required],
      SCNUMIDENTIFICACION: [null, Validators.required],
      NOMBREUSUARIO: [null,Validators.required]
    });
  }



  ngOnInit(): void{
    console.log("Ingreso al al evento oninit de gestionar usuario");
        this.usuario = new UsuarioDTO();
        this.persona = new PersonaDTO();
        this.listaUsuarios = new Array<UsuarioDTO>();
        this.listaPersonas = new Array<PersonaDTO>();
        this.listaUsuarios = new Array<UsuarioDTO>();
      //  this.cargarListas();
  }



   /**
     * @description Metodo que permite validar el formulario
     *  y crear o actualizar un usuario
     */
    public crearActualizarUsuario() : void {
      this.submitted = true;
      this.persona = new PersonaDTO();
      this.persona.pid = this.uid++;
      this.persona.nombre = this.gestionarUsuarioForm.controls.SCNOMBRE.value;
      this.persona.numeroDeIdentificacion = this.gestionarUsuarioForm.controls.SCNUMIDENTIFICACION.value;
      this.usuario = new UsuarioDTO();
      this.usuario.uid = this.uid++;
      this.usuario.nombre = this.gestionarUsuarioForm.controls.NOMBREUSUARIO.value;
      this.usuario.idPerson = this.persona.pid;
      this._usuarioService.crearUsuario(this.persona).subscribe(data => {
      //  this.cargarListas();
      });
      this.limpiarFormulario();
    }
  /**
   * @description metodo que obtiene las listas de usuarios y personas
   */
  cargarListas() {
    this._usuarioService.consultarUsuarios().subscribe(data => {
      this.listaUsuarios = data;
    });
    this._usuarioService.consultarPersonas().subscribe(data => {
      this.listaPersonas = data;
    });
  }

  /**
   * @description metodo que limpia todos los campos del formulario
   */
  private limpiarFormulario(): void {
    this.submitted = false;
    this.gestionarUsuarioForm.controls.SCNOMBRE.setValue(null);
    this.gestionarUsuarioForm.controls.SCNUMIDENTIFICACION.setValue(null);
    this.gestionarUsuarioForm.controls.NOMBREUSUARIO.setValue(null);
  }

  /**
   * @description metodo que desactiva un usuario debido a que no se puede eliminar
   * @param uid
   */
  public eliminarUsuario(uid):void {
    this._usuarioService.eliminarUsuario(uid).subscribe();
    this.cargarListas();
  }

}
