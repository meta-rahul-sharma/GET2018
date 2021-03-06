import { Component, OnInit, Input } from '@angular/core';
import { UserListService } from '../user-list.service';
import { User } from '../user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  userFilter: any = { name: '' };
  users: User[];
  constructor(private userListService: UserListService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {
    this.userListService.getUsers().subscribe(users => this.users = users);
  }
}
