import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { VerComicComponent} from './semillero/componentes/ver-comic/ver-comic.component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent, data : null},
  { path: 'bienvenida', component: BienvenidaComponent},
  { path: 'ver-comic', component: VerComicComponent, data : null  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
