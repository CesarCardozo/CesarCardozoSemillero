/**
 * @description Clase ComicDTO que contiene la informacion del objeto que se solicita en la segunda tarea
 * del semillero de fabricas de heishohn en angular
 * 
 * @author Cesar Nicolas Cardozo Rincon <cesar.n.cardozo.r@gmail.com>
 */
export class ComicTareaSesionDos {

    /**
    * Identificador del comic
    */
    public id: number;

    /**
    * nombre del comic
    */
    public nombre: string;

    /**
    * editorial del comic.
    */
    public editorial: string;

    /**
    * tematica del comic
    */
    public tematica: string;

    /**
     * numero de paginas del comic
     */
    public numeroPaginas: number;
    
    /**
    * Iprecio del comic
    */
   public precio: number;

   /**
    * autores del comic
    */
   public autores: string;

    /**
    * define si el comic es a color o no
    */
    public aColor: boolean;

    /**
    * fecha de venta del comic
    */
    public fechaVenta: Date;

    /**
    * Estado del comic
    */
    public estado: string;
}