import { Component, OnInit } from '@angular/core';
import { ComicTareaSesionDos } from '../../dto/comicTareaSesionDos';

/**
 * @description Componente en el cual se muestra informacion sobre comics
 * @author Cesar Nicolas Cardozo Rincon / e-mail: cesar.n.cardozo.r@gmail.com
 */
@Component({
  selector: 'app-tarea-sesion-dos',
  templateUrl: './tarea-sesion-dos.component.html'
})
export class TareaSesionDosComponent implements  OnInit {

  /**
   * variable que alverga la lista de comics a mostrar
   */
  public listaComics: Array<ComicTareaSesionDos>
  /**
   * variable que cambiara de estado cuando se haya eliminado un comic
   */
  public mostrarMensaje: boolean = false;

  constructor() { }

  /**
   * inicializacion de la variable lista comics y su posterior ocupacion por 5 instancias de comic
   */
  ngOnInit() {
    this.listaComics = new Array<ComicTareaSesionDos>();
    let comic: ComicTareaSesionDos = {
      id : 1,
      nombre : "batman",
      editorial : "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 60500.99,
      autores : "Pedrito ",
      aColor : true,
      fechaVenta : new Date("10/10/2019"),
      estado : "activo"
    }
    this.listaComics.push(comic);
    comic = {
      id : 2,
      nombre : "batman y robin",
      editorial : "marvel",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 61500.99,
      autores : "Pedrito barrera y robin",
      aColor : true,
      fechaVenta : new Date("10/11/2019"),
      estado : "activo"
    }
    this.listaComics.push(comic);
    comic = {
      id : 3,
      nombre : "robin",
      editorial : "dc",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 500.99,
      autores : "Barrera",
      aColor : false,
      fechaVenta : new Date("11/10/2019"),
      estado : "activo"
    }
    this.listaComics.push(comic);
    comic = {
      id : 4,
      nombre : "superman",
      editorial : "dc",
      tematica : "drama",
      numeroPaginas : 50,
      precio : 60900.99,
      autores : "Mario Bros",
      aColor : true,
      fechaVenta : new Date("10/10/2018"),
      estado : "activo"
    }
    this.listaComics.push(comic);
    comic = {
      id : 5,
      nombre : "Flash",
      editorial : "dc",
      tematica : "accion",
      numeroPaginas : 50,
      precio : 60588.99,
      autores : "Daniel Lopez",
      aColor : false,
      fechaVenta : new Date("10/10/2017"),
      estado : "activo"
    }
    this.listaComics.push(comic);
    this.aumentarPrecioPorIva();//se aumenta el precio por el iva a los comics
    console.log(this.listaComics);//se imprime la lista de comics por consola
  }

  /**
   * Metodo que elimina el comic con el inidice provisto
   * @param indexToDelete indice del comic a borrar
   */
  deleteComic(indexToDelete:number){
    alert("Se ha eliminado el comic: " + this.listaComics[indexToDelete].nombre);
    this.listaComics.splice(indexToDelete,1);
    this.mostrarMensaje = true;
  }
  
  /**
   * metodo que permite cambiar el valor de la variable mostrarMensaje
   */
  ocultarMensaje(){
    this.mostrarMensaje = !this.mostrarMensaje;
  }

  /**
   * metodo que aumenta el precio de todos los comics por el iva
   */
  aumentarPrecioPorIva(){
    this.listaComics.forEach(comic=>{
      comic.precio = comic.precio*1.19;
    })
  }
}
