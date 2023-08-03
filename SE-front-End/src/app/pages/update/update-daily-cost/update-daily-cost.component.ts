import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AddDailyCostService } from 'src/app/service/cost/add-daily-cost.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-daily-cost',
  templateUrl: './update-daily-cost.component.html',
  styleUrls: ['./update-daily-cost.component.css']
})
export class UpdateDailyCostComponent implements OnInit{
 
 
  dcId=0;
 dailyCost:any;

  constructor(private route : ActivatedRoute, 
        private dailyCostService: AddDailyCostService,
        private router: Router
        ){

  }
 
  ngOnInit(): void {

    this.dcId= this.route.snapshot.params['dcId'];

    this.dailyCostService.getDailyCostById(this.dcId).subscribe(
      (data:any)=>{

        this.dailyCost=data;
      
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  totalCost(){
    this.dailyCost.totalDailyCost= this.dailyCost.morningSnack+this.dailyCost.eveningSnack+
                    this.dailyCost.customerSnack+ this.dailyCost.laborCharge+this.dailyCost.dailyDonation+
                    this.dailyCost.otherCost;
  }

  updateDailyCost(){

    this.dailyCostService.updateDailyCost(this.dailyCost).subscribe(
      (data:any)=>{
        console.log(data);
        console.log("your data is updated...")
        Swal.fire('Update','Update Successfully','success').then((e)=>{

          this.router.navigate(['/add-daily-cost'])
        });

        this.dailyCost.morningSnack=0,
        this.dailyCost.eveningSnack=0,
        this.dailyCost.customerSnack=0,
        this.dailyCost.laborCharge=0,
        this.dailyCost.dailyDonation=0,
        this.dailyCost.otherCost=0,
        this.dailyCost.totalDailyCost=0,
        this.dailyCost.addBy='',
        this.dailyCost.addingDate=new Date()
      },
      (error)=>{
        console.log("Your error is : "+error);
        Swal.fire("Warning",error,'error');
      }

    )
  }

}
