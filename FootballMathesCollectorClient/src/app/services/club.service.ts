import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Club } from '../models/club.model';
const baseUrl = 'https://infinite-island-13820.herokuapp.com/api/clubs';
@Injectable({
  providedIn: 'root'
})
export class ClubService {
  constructor(private http: HttpClient) { }
  getAll(): Observable<Club[]> {
    console.log(baseUrl);
    return this.http.get<Club[]>(baseUrl);
  }
  get(id: any): Observable<Club> {
    return this.http.get(`${baseUrl}/${id}`);
  }
  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }
  findByName(name: any): Observable<Club[]> {
    return this.http.get<Club[]>(`${baseUrl}?name=${name}`);
  }
}
