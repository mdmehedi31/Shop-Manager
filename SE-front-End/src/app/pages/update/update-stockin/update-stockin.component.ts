import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ViewStockinComponent } from '../../stockin/view-stockin/view-stockin.component';
import { StockinService } from 'src/app/service/stockin.service';
import { FormBuilder, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AddCategoryService } from 'src/app/service/add-category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-stockin',
  templateUrl: './update-stockin.component.html',
  styleUrls: ['./update-stockin.component.css']
})


export class UpdateStockinComponent implements OnInit {



  constructor(
    private stockInService: StockinService,
    private route: Router,
    private router: ActivatedRoute,
    private categoryService: AddCategoryService) {

  }



  public catList = [{
    catId: 0,
    categoryName: '',
    categoryDesc: '',
    addingDate: ''
  }]

  public brandList = [{
    brandId: 0,
    brandName: ''
  }]
  /*
    stockInValue= this.fb.group({
  
      stockId: 0,
      brandName: '',
      categoryName: '',
      origin:'',
      productName: '',
      totalProduct: 0,
      unitPrice: 0.0,
      totalProductPrice: 0.0,
      productDescription: '',
      unitSellingPrice: 0.0,
      shopProductAmount: 0,
      shopShelfNo: '',
      shopShelfLevelNo: '',
      wearHouseProductAmount: 0,
      wearHouseShelfNo: '',
      wearHouseShelfLevelNo: '',
      stockInDate: new Date(),
    })
  */


  stockId!: 0;
  stock:any;
  // stock = {

  //   stockId: 0,
  //   brandName: '',
  //   categoryName: '',
  //   origin: '',
  //   productName: '',
  //   totalProduct: 0,
  //   unitPrice: 0.0,
  //   totalProductPrice: 0.0,
  //   productDescription: '',
  //   unitSellingPrice: 0.0,
  //   shopProductAmount: 0,
  //   shopShelfNo: '',
  //   shopShelfLevelNo: '',
  //   wearHouseProductAmount: 0,
  //   wearHouseShelfNo: '',
  //   wearHouseShelfLevelNo: '',
  //   newProductAmount: 0,
  //   newUnitRate: 0.0,
  //   newShelfProductAmount:0,
  //   newWearProductAmount:0,
  //   updateStockInDate: new Date(),
  // };

  updateDate= new FormControl(new Date())


  ngOnInit(): void {

    this.stockId = this.router.snapshot.params['stockId']
    console.log("your stock in id is : " + this.stockId);

    this.stockInService.getStockInById(this.stockId).subscribe(
      (data: any) => {

        this.stock = data;
      },
      (error) => {
        console.log(error);
      }
    )
  }


  public getCatList() {

    this.categoryService.getCategory().subscribe(
      (data: any) => {

        this.catList = data;
      },
      (error) => {
        console.log("you got this error : " + error);
      }
    )
  }

  public originList = [];

  public getBrandList() {

    this.stockInService.getBrandByCategory(this.stock.categoryName).subscribe(
      (data: any) => {
        this.brandList = data;
      },
      (error) => {
        console.log("you got an error : " + error);
      }
    )
  }

  public getOriginList() {

    this.stockInService.getOriginByCategory(this.stock.categoryName).subscribe(
      (data: any) => {
        this.originList = data;
      },
      (error) => {

        console.log("you got an error : " + error);
      }
    )
  }

  public updateProductUnitPrice(){

    if(this.stock.newUnitRate== this.stock.unitPrice){

      this.stock.newUnitRate=0.0;
      this.stock.newProductAmount=0.0
    }
  }

  public totalProduct(){

    this.stock.totalProduct=this.stock.totalProduct+this.stock.newProductAmount;
  }

  public updateTotalProductPrice(){
  //  let newProduct=
    this.stock.totalProductPrice=+this.stock.newProductAmount*this.stock.newUnitRate;
    this.stock.totalProduct=+this.stock.newProductAmount;
    if(this.stock.newProductAmount==0){
      this.stock.totalProduct=this.stock.totalProduct;
    }
  }

  num1=20;
  num2=30;
  

  // while product is exist in system, but you want to add more product 

  public stockInProduct(){
     this.stockInService.updateStockInProduct(this.stock).subscribe(
      (data)=>{

        console.log(data);
        Swal.fire('Success','Product Stock in success','success');
        
        this.route.navigate(['/stock-in-product'])
      },
      (error)=>{
        console.log("you got an error "+error);
      }
     );
  }
}


