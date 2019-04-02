import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { parse } from 'url';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserListService {
  private url = 'http://localhost:3000/user';
  private users;
  private demoUser = [];
  response: User;
  constructor(private http: HttpClient) { }
  
  /** get users from server */
  getUsers(): Observable<User[]> {
    this.users = this.http.get<User[]>(this.url);
    return this.users;
  }

  /** PUT: update the user on the server */
  editUser(user: User, id: number): Observable<any> {
    console.log("here");
    return this.http.put(this.url+'/'+id, user, httpOptions);
  }

  getUser(id: number): Observable<User> {
    const url = this.url + '/' + id;
    return this.http.get<User>(url);
  }

  /** POST: add a new hero to the server */
  addUser (user: User): Observable<User> {
    return this.http.post<User>(this.url, user, httpOptions);
  }
}
