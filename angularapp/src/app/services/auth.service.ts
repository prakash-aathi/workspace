import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from '../models/user.model';
import { Login } from '../models/login.model';


export interface LoginResponse {
  token: string;
  username: string;
  userRole: string;
  userId: number;
}


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public apiUrl = 'http://localhost:8080'; // Replace this with your actual port URL

  private currentUserRole = new BehaviorSubject<string | null>(null);
  private currentUserId = new BehaviorSubject<number | null>(null);

  constructor(private http: HttpClient) {}

  getRole(): Observable<string | null> {
    return this.currentUserRole.asObservable();
  }

  getUserId(): Observable<number | null> {
    return this.currentUserId.asObservable();
  }

  register(user: User): Observable<any> {
    const url = `${this.apiUrl}/api/register`;
    return this.http.post(url, user);
  }

  login(loginData: Login): Observable<LoginResponse> {
    const url = `${this.apiUrl}/api/login`;
    return this.http.post<LoginResponse>(url, loginData).pipe(
      tap((res: LoginResponse) => {
        localStorage.setItem('token', res.token);
        this.currentUserRole.next(res.userRole);
        this.currentUserId.next(res.userId);
      })
    );
  }

  getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': token ? `Bearer ${token}` : ''
    });
  }

  logout(): void {
    localStorage.removeItem('token');
    this.currentUserRole.next(null);
    this.currentUserId.next(null);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }
}
