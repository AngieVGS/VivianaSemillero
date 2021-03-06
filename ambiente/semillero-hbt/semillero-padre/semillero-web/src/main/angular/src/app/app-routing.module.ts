import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionarUsuarioComponent } from './semillero/componentes/gestionar-usuario/gestionar-usuario.component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'gestionar-usuario', component: GestionarUsuarioComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
