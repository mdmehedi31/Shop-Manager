import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { StockinComponent } from '../stockin.component';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { StockinService } from 'src/app/service/stockin.service';
import { UpdateCategoryComponent } from '../../update/update-category/update-category.component';
import { UpdateStockinComponent } from '../../update/update-stockin/update-stockin.component';
import Swal from 'sweetalert2';
import { SimpleSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-view-stockin',
  templateUrl: './view-stockin.component.html',
  styleUrls: ['./view-stockin.component.css']
})
export class ViewStockinComponent implements OnInit {


  ngOnInit(): void {

    this.getStockInList();
  }


  constructor(private dialog: MatDialog,
            private stockInService: StockinService) {

  }


  stockIn() {

   const dialogRef=  this.dialog.open(StockinComponent);

   dialogRef.afterClosed().subscribe({
    next:(val)=>{
      if(val){

        this.getStockInList();
      }
    }
   })
  }

  getUpdatePage(){
      const dialogRef= this.dialog.open(UpdateStockinComponent);
      dialogRef.afterClosed().subscribe({
        next:(val)=>{
          if(val){
          this.getStockInList();
          }
        }
      })
  }
  dataSource!: MatTableDataSource<any>;


  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

 // stockin:any;

  displayedColumns: string[] = [
    'stockId',
    'brandName',
    'categoryName',
    'productName',
    'origin',
    'totalProduct',
    'unitPrice',
    'unitSellingPrice',
    'shopProductAmount',
    'shopShelfNo',
    'shopShelfLevelNo',
    'wearHouseProductAmount',
    'wearHouseShelfNo',
    'wearHouseShelfLevelNo',
    'action'
  ]


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();

      
    }

  }

 
  getStockInList(){

    this.stockInService.getStockInList().subscribe(
      (data:any)=>{
        this.dataSource= new MatTableDataSource(data);
        this.dataSource.sort= this.sort;
        this.dataSource.paginator=this.paginator;
      },
      (error)=>{
        console.log("you got an error "+error);
      }
    )
  }

  deleteStockIn(stockId:any){

    Swal.fire({
      icon:'info',
      title:'are you sure.?',
      confirmButtonText:'Delete',
      showCancelButton: true
    }
    ).then((result)=>{
      if(result.isConfirmed){

          this.stockInService.deleteStockInById(stockId).subscribe(
            (data:any)=>{
              this.getStockInList();
              Swal.fire('Success','Stock Delete','success');

            },
            (error:any)=>{
              Swal.fire('Error','Delete Error','error');

            }
          )
        
      }
    });
    
  }
}
