import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-consultar-comic',
  templateUrl: './consultar-comic.component.html'
})
export class ConsultarComicComponent implements OnInit {

  /**
     * Atributo que contiene los controles del formulario
     * @author Cesar Nicolas Cardozo Rincon
     */
  public gestionarComicForm: FormGroup;

  /**
   * constructor de la clase consultar comic
   * @param router 
   * @param activatedRoute 
   * @param fb 
   * @param location 
   */
  constructor(private router: Router,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private location: Location) {
      this.gestionarComicForm = this.fb.group({
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
   * Metodo que incializa el componente
   * @author Cesar Nicolas Cardozo Rincon
   */
  ngOnInit() {
    let comic = this.activatedRoute.snapshot.params;
    this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
    this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
    this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
    this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
    this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
    this.gestionarComicForm.controls.precio.setValue(comic.precio);
    this.gestionarComicForm.controls.autores.setValue(comic.autores);
    this.gestionarComicForm.controls.color.setValue(comic.color);
    this.gestionarComicForm.controls.nombre.disable();
    this.gestionarComicForm.controls.editorial.disable();
    this.gestionarComicForm.controls.tematica.disable();
    this.gestionarComicForm.controls.coleccion.disable();
    this.gestionarComicForm.controls.numeroPaginas.disable();
    this.gestionarComicForm.controls.precio.disable();
    this.gestionarComicForm.controls.autores.disable();
    this.gestionarComicForm.controls.color.disable();
  }

  /**
   * metodo que permite volver a la pantalla de gestion de comics
   * @author Cesar Nicolas Cardozo Rincon
   */
  volver(){
    this.location.back();
  }

}
