import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddCategoryService } from 'src/app/service/add-category.service';
import { __makeTemplateObject } from 'tslib';
import Swal from 'sweetalert2';
import { DialogRef } from '@angular/cdk/dialog';
import { ViewCategoryComponent } from './view-category/view-category.component';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {


     constructor(private categoryService : AddCategoryService,
      private snack: MatSnackBar, private ref: DialogRef<ViewCategoryComponent>,
      private router: Router
      ){}

     public category={
      catId:0,
      categoryName:'',
      categoryDesc:'',
      addingDate: new Date()
     }

     
     

    // displayedColumns: string[]=['Category Name','Category Description','Adding Date']
     public categoryList=[{
      catId:0,
      categoryName:'',
      categoryDesc:'',
      addingDate:'',
      acition:''
     }]

    ngOnInit():void{

      //this.getCategoryList();

      
      
    }


    getCategoryList(){
      this.categoryService.getCategory().subscribe(
        (data : any)=>{
          this.categoryList=data;
          console.log("list is : "+this.categoryList)
          console.log("data list is : "+data);
        },
        (error)=>{
          console.log("your error is : "+error);
        }
      )
    }

    // /if(this.quiz.title.trim()=='' || this.quiz.title==null){
    //   this.snack.open('Title is required','',{
    //     duration: 3000,
    //   });
    //   return;/
   
    

    formSubmit(): void{
      if(this.category.categoryName.trim()=='' || this.category.categoryName==null){
         this.snack.open('Category Name is Required.','',{
          duration:3000,
          verticalPosition:'top',
          horizontalPosition:'right'
          
         });
         return;
      }

      if(this.category.categoryDesc.trim()==''|| this.category.categoryDesc==null){
        this.snack.open('Category Description is Required.','',{
          duration:3000,
          verticalPosition:'top'
        });
        return;
      }

      // if(this.category.addingDate.trim()==''|| this.category.addingDate==null){
      //   this.snack.open('Date is Required..','',{
      //     duration:3000,
      //   });
      //   return;
      // }
     
      this.categoryService.addCategory(this.category).subscribe(
        (data)=>{
          //success
          console.log(data);
          this.category.categoryName="";
          this.category.categoryDesc="";
         

          Swal.fire('Success','Category Added Successfully','success');
          this.ref.close();
          this.router.navigate(['/category-list']);
  
        },
        (error)=>{
            console.log(error);
            Swal.fire('Error','Got an Error','error');
        }
      );
    }


    
}
