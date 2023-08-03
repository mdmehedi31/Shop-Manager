import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class AddDailyCostService {

  constructor(private http : HttpClient) { }

  //add daily Cost
  public addDailyCost(cost:any){
    return this.http.post(`${baseUrl}/daily-cost/add-cost`,cost);
  }

  //get DailyCost List
  public getDailyCost(){
    return this.http.get(`${baseUrl}/daily-cost/getAll`);
  }

  // Get Daily Cost by Id
  public getDailyCostById(dcId:any){
    return this.http.get(`${baseUrl}/daily-cost/get-daily-cost/${dcId}`);
  }

  //update daily cost
  public updateDailyCost(dailyCost:any){
    
    console.log("your data is : "+dailyCost);
    return this.http.put(`${baseUrl}/daily-cost/update-daily-cost`,dailyCost);
  }
}
