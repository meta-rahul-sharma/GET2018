import { Component, OnInit } from '@angular/core';
import { UserListService } from '../user-list.service';
import { User } from '../user';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  user: User;
  constructor(private userListService: UserListService, private route: ActivatedRoute, private location: Location) { 
  }

  ngOnInit() {
    this.getUser();
  }

  editUser(user: User): void {
    this.userListService.editUser(user, user.id).subscribe(() => this.goBack());;
  }

  getUser(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userListService.getUser(id)
      .subscribe(user => this.user = user);
  }

  goBack(): void {
    this.location.back();
  }
}
