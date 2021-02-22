import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface PeriodicElement {
  name: string;
  id: number;
  //url: String,
  description: String,
  status: String,
  expiry_date: String,
  //featured: String,
  //image: String,
  //user_id: number;
  //created_at: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {id: 1, name: 'Hydrogen', description: 'Hydrogen', status: 'H', expiry_date: '0000-00-00 00:00:00'},
  {id: 2, name: 'Helium', description: 'Hydrogen', status: 'He', expiry_date: '0000-00-00 00:00:00'},
  {id: 3, name: 'Lithium', description: 'Hydrogen', status: 'Li', expiry_date: '0000-00-00 00:00:00'},
  {id: 4, name: 'Beryllium', description: 'Hydrogen', status: 'Be', expiry_date: '0000-00-00 00:00:00'},
  {id: 5, name: 'Boron', description: 'Hydrogen', status: 'B', expiry_date: '0000-00-00 00:00:00'},
  {id: 6, name: 'Carbon', description: 'Hydrogen', status: 'C', expiry_date: '0000-00-00 00:00:00'},
  {id: 7, name: 'Nitrogen', description: 'Hydrogen', status: 'N', expiry_date: '0000-00-00 00:00:00'},
  {id: 8, name: 'Oxygen', description: 'Hydrogen', status: 'O', expiry_date: '0000-00-00 00:00:00'},
  {id: 9, name: 'Fluorine', description: 'Hydrogen', status: 'F', expiry_date: '0000-00-00 00:00:00'},
  {id: 10, name: 'Neon', description: 'Hydrogen', status: 'Ne', expiry_date: '0000-00-00 00:00:00'},
];


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() : void {

    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Methods': 'GET, POST, DELETE, PUT'
    }
    const requestOptions : Object = {                                                                                                                                                                                 
      headers: new Headers(headerDict)
    };
    this.http.get<String>('http://demo.dreamsquadgroup.com/test/index.json', requestOptions).subscribe(
    data => console.log(data),
    error => console.error('There was an error!', error)
)
  }

  displayedColumns: string[] = ['position', 'name', 'description', 'status', 'expiry_date'];
  dataSource = ELEMENT_DATA;

}
