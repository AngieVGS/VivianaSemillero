import { Injectable, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './template.service';
import { Observable } from 'rxjs';
import { PersonaDTO } from '../dto/persona.dto';
import { UsuarioDTO } from '../dto/Usuario.dto';

@Injectable({
  providedIn: 'root'
})
/**
 * clase que representa al servicio que permite gestionar una persona
 */
export class UsuariosService extends AbstractService {

  /**
   * constructor del servicio de usuarios
   * @param injector
   * @param httpClient
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    super(injector);
  }

  /**
   * metodo que permite consultar una lista de personas
   */
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersonas/consultarPersonas');
  }

  /**
   * metodo que permite consultar una persona ingresando su id
   * @param pid
   */
  public consultarPersona(pid: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarPersonas/consultarPersona?pid='+ pid);
  }

  /**
   * metodo que permite consultar una lista de usuarios
   */
  public consultarUsuarios(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarUsuarios');
  }

  /**
   * metodo que permite consultar un usuario por su id
   * @param idUsuario
   */
  public consultarUsuario(idUsuario: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarUsuario?uid='+ idUsuario);
  }


  /**
   *
   * @param personaDTO metodo que crea un usuario
   */
  public crearUsuario(personaDTO: PersonaDTO){
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/crear', personaDTO );
  }

  /**
   * metodo que permite modificar un usuario
   * @param usuarioDTO
   */
  public modificarUsuario(usuarioDTO: UsuarioDTO){
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/modificar', {'usuarioDTOModificado': usuarioDTO} );
  }

  /**
   * metodo que permite inactivar a un usuario
   * @param idUsuario
   */
  public eliminarUsuario(idUsuario: number){
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/eliminar?idUsuario='+idUsuario );
  }
}
