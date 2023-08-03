import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Brand } from 'src/app/model/Brand';


import { FileHandle } from 'src/app/model/file-handle.model';
import { AddCategoryService } from 'src/app/service/add-category.service';
import { AddBrandService } from 'src/app/service/add/add-brand.service';


@Component({
  selector: 'app-add-brand',
  templateUrl: './add-brand.component.html',
  styleUrls: ['./add-brand.component.css']
})
export class AddBrandComponent implements OnInit{


  constructor(private brandService: AddBrandService, 
    private category : AddCategoryService,
    private sanitizer: DomSanitizer){

  }


 categoryList =[{
    catId:0,
    categoryName:''
  }
]

brand = {
  brandName:'',
  categoryName:'',
  attachmentEntity:File
}


  ngOnInit(): void {
   

    this.category.getCategory().subscribe((data:any)=>{

      this.categoryList=data;
      console.log(this.categoryList);
    })
  }


 
// public brand = new Brand("","",null)

  addBrand(){

        this.brandService.addBrand(this.brand).subscribe(
          (data)=>{

            console.log("data is : "+data);
            alert("save successfully...");
            console.log(data.valueOf);
          },

          (error)=>{
            console.log(error);
          }

        )
   
  }


 
  onChangeFileField(event:any){

   // console.log(event.target.files[0]);

    this.brand.attachmentEntity= event.target.files[0];

    console.log(this.brand.attachmentEntity);
  }

  }
