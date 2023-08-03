import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AddCategoryService } from 'src/app/service/add-category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit{


  catId=0;
  category:any;

  constructor(private categoryService: AddCategoryService,
                private route: ActivatedRoute,
                private router: Router ){

  }


  ngOnInit(): void {
   
    this.catId=this.route.snapshot.params['catId'];

    this.categoryService.getCategoryById(this.catId).subscribe(
      (data:any)=>{
        this.category=data;
        console.log("your category is : "+this.category);
      },
      (error)=>{
        console.log(error);
        console.log('you got error');
      }
    )
    
  }


  
  // then((e)=>
  // this.router.navigate(['/admin/quizzes'])  
  updateCategory(){


    this.categoryService.updateCategory(this.category).subscribe(

      (data)=>{
        console.log("your data is: "+data);
        Swal.fire('Success','Data updated','success').then((e)=>
         this.router.navigate(['/add-category'])
        );
      },
      (error)=>{
        console.log("you got an error..");
        Swal.fire('Warning',error,'error');
      }
    )
  }

        

}
