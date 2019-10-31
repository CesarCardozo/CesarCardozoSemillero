import { Component, OnInit } from '@angular/core';

/**
 * @description Componente en el cual se muestra la informacion del autor
 * @author Cesar Nicolas Cardozo Rincon / e-mail: cesar.n.cardozo.r@gmail.com
 */
@Component({
  selector: 'app-tarea-sesion-uno',
  templateUrl: './tarea-sesion-uno.component.html'
})
export class TareaSesionUnoComponent implements OnInit {

  /**
   * variable que alberga el nombre del autor
   */
  nombre:string = "Cesar Nicolas Cardozo Rincon";
  /**
   * ciudad del autor
   */
  ciudad:string = "Tunja"
  constructor() { }

  ngOnInit() {
  }

}
