import { Component, OnInit } from '@angular/core';
import { AddDailyCostService } from 'src/app/service/cost/add-daily-cost.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-daily-cost',
  templateUrl: './add-daily-cost.component.html',
  styleUrls: ['./add-daily-cost.component.css']
})
export class AddDailyCostComponent implements OnInit{



  constructor(private dailyCostService : AddDailyCostService){}

  ngOnInit(): void {
   
    // this.totalCost();

    this.getDailyCostList();
  }

  public dailyCost ={
    morningSnack:0,
    eveningSnack:0,
    customerSnack:0,
    laborCharge:0,
    addingDate:new Date(),
    addBy:'',
    dailyDonation:0,
    otherCost:0,
    totalDailyCost:0
  }

  public dailyCostList=[
    {
      dcId:0,
      morningSnack:0,
      eveningSnack:0,
      customerSnack:0,
      laborCharge:0,
      addingDate:'',
      addBy:'',
      dailyDonation:0,
      otherCost:0,
      totalDailyCost:0
    }
  ]
  totalCost(){
    this.dailyCost.totalDailyCost= this.dailyCost.morningSnack+this.dailyCost.eveningSnack+
                    this.dailyCost.customerSnack+ this.dailyCost.laborCharge+this.dailyCost.dailyDonation+
                    this.dailyCost.otherCost;
  }


  getDailyCostList(){

    this.dailyCostService.getDailyCost().subscribe(
      (data:any)=>{
        
        this.dailyCostList=data;
        console.log("your list is : "+data);
      },
      (error)=>{
        console.log("your error is : "+error);
      }
    )
  }

  addDailyCost(){

    console.log(this.dailyCost);
  

    this.dailyCostService.addDailyCost(this.dailyCost).subscribe(

      (data)=>{
        console.log(data);
        Swal.fire('Success','Save Successfully','success');

        this.dailyCost.morningSnack=0,
        this.dailyCost.eveningSnack=0,
        this.dailyCost.customerSnack=0,
        this.dailyCost.laborCharge=0,
        this.dailyCost.dailyDonation=0,
        this.dailyCost.otherCost=0,
        this.dailyCost.totalDailyCost=0,
        this.dailyCost.addBy='',
        this.dailyCost.addingDate=new Date(),
        this.getDailyCostList();

      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',error,'error');
      }
      
    );}

    

}
