import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { StockinComponent } from '../stockin.component';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { StockinService } from 'src/app/service/stockin.service';
import { UpdateCategoryComponent } from '../../update/update-category/update-category.component';
import { UpdateStockinComponent } from '../../update/update-stockin/update-stockin.component';

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

    this.dialog.open(StockinComponent)
  }

  getUpdatePage(){
    this.dialog.open(UpdateStockinComponent)
  }
  dataSource!: MatTableDataSource<any>;


  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

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
}
