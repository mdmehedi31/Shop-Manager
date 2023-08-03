import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class AddCategoryService {

  constructor(private http: HttpClient) {}


  // add category
   public addCategory(category:any){
      return this.http.post(`${baseUrl}/category/add-category`,category);
   }

   //get category List
   public getCategory(){

    
    return this.http.get(`${baseUrl}/category/`);
  }


  //get category by category Id
  public getCategoryById(catId:any){
    return this.http.get(`${baseUrl}/category/get-category/${catId}`)
  }

  public updateCategory(category:any){

    return this.http.put(`${baseUrl}/category/update-category`,category);
  }
  //Delete Category 
  public deleteCategory(catId:any){
    return this.http.delete(`${baseUrl}/category/delete-category/${catId}`);
  }


}
