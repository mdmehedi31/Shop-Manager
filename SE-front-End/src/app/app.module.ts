import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { AddCategoryComponent } from './pages/add-category/add-category.component';
import { AddDailyCostComponent } from './pages/add-daily-cost/add-daily-cost.component';
import { AddMonthlyCostComponent } from './pages/add-monthly-cost/add-monthly-cost.component';
import { AppRoutingModule } from './app-routing.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddCustomerComponent } from './pages/add-customer/add-customer.component';
import { AddBrandComponent } from './pages/add-brand/add-brand.component';
import {MatListModule} from '@angular/material/list';
import { StockinComponent } from './pages/stockin/stockin.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { WastedProductComponent } from './pages/wasted-product/wasted-product.component';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatIconModule} from '@angular/material/icon';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {MatCardModule} from '@angular/material/card';
import { UpdateCategoryComponent } from './pages/update/update-category/update-category.component';
import { UpdateDailyCostComponent } from './pages/update/update-daily-cost/update-daily-cost.component';
import { UpdateMonthlyCostComponent } from './pages/update/update-monthly-cost/update-monthly-cost.component';
import { ViewCategoryComponent } from './pages/add-category/view-category/view-category.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatDialogModule} from '@angular/material/dialog';
import { ViewStockinComponent } from './pages/stockin/view-stockin/view-stockin.component';
import { UpdateStockinComponent } from './pages/update/update-stockin/update-stockin.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    AddCategoryComponent,
    AddDailyCostComponent,
    AddMonthlyCostComponent,
    AddCustomerComponent,
    AddBrandComponent,
    StockinComponent,
    WastedProductComponent,
    DashboardComponent,
    UpdateCategoryComponent,
    UpdateDailyCostComponent,
    UpdateMonthlyCostComponent,
    ViewCategoryComponent,
    ViewStockinComponent,
    UpdateStockinComponent
   ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    MatSelectModule,
    FormsModule,
    HttpClientModule,
    MatListModule,
    MatAutocompleteModule,
    MatTableModule,
    MatSnackBarModule,
    MatSlideToggleModule,
    MatIconModule,
    MatCardModule,
    MatToolbarModule,
    MatDialogModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
