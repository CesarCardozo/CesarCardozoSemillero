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
 * clase que representa al servicio que gestiona lo relacionado con personas y usuarios
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
   * metodo que permite consultar personas
   */
  public consultarPersonas(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarPersonas');
  }

  /**
   * metodo que permite consultar una persona por el id
   * @param idPersona 
   */
  public consultarPersona(idPersona: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarPersona?idPersona='+ idPersona);
  }

  /**
   * metodo que permite consultar los usuarios en la bd
   */
  public consultarUsuarios(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarUsuarios');
  }

  /**
   * metodo que permite consultar un usuario por el id
   * @param idUsuario 
   */
  public consultarUsuario(idUsuario: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/consultarUsuario?idUsuario='+ idUsuario);
  }

  /**
   * 
   * @param personaDTO metodo que crea un usuario a partir de una persona DTO y luego agrega ambos a la bd
   */
  public crearUsuario(personaDTO: PersonaDTO){
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/crearUsuario', personaDTO );
  }

  /**
   * metodo que permite modificar un usuario llamado al servicio
   * @param usuarioDTO 
   */
  public modificarUsuario(usuarioDTO: UsuarioDTO){
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/modificarUsuario', {'usuarioDTOModificado': usuarioDTO} );
  }

  /**
   * metodo que permite inactivar a un usuario llamando al servicio de eliminar
   * @param idUsuario
   */
  public eliminarUsuario(idUsuario: number){
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/eliminarUsuario?idUsuario='+idUsuario );
  }

  /**
   * metodo que valida si un usuario es activo o no
   * @param idUsuario 
   */
  public validarUsuario(idUsuario: number){
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuarios/validarUsuario?idUsuario='+idUsuario );
  }
}
