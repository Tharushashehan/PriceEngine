import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';

import { MatTableModule } from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  { path: 'product', component: ProductComponent , data: { title: 'Product page' } },
  { path: 'login', component: LoginComponent , data: { title: 'Login page' } }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    MatTableModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes), 
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
