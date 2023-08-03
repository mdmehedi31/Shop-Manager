import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class AddMonthlyCostService {

  constructor(private http : HttpClient) { }

  //add monthly cost
   public addMonthlyCost(monthlyCost:any){
    return this.http.post(`${baseUrl}/monthly-cost/add-cost`,monthlyCost);
   }

   //Get Monthly Cost List
   public getMonthlyCostList(){
    return this.http.get(`${baseUrl}/monthly-cost/get-monthly-cost-list`)
   }

   //Get Monthly Cost by ID
   public getMonthlyCostById(mcId:any){
    console.log("from get monthly cost service class...");
    return this.http.get(`${baseUrl}/monthly-cost/get-monthly-cost/${mcId}`);
   }


   //Update Monthly Cost 
   public updateMonthlyCost(monthlyCost:any){

     return this.http.put(`${baseUrl}/monthly-cost/update-monthly-cost`,monthlyCost)
   }
}
