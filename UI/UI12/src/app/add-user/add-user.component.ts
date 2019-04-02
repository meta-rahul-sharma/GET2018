import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { UserListService } from '../user-list.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  @Input() user= new User();
  constructor(private userListService: UserListService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit() {
  }

  addUser(): void {
    console.log(this.user);
    debugger;
    this.userListService.addUser(this.user).subscribe(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }
}
