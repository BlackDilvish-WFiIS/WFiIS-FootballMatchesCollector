import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Match } from '../models/match.model';
const baseUrl = 'https://infinite-island-13820.herokuapp.com/api/matches';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Match[]> {
    console.log(baseUrl);
    return this.http.get<Match[]>(baseUrl);
  }
  get(id: any): Observable<Match> {
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
  findByClub(club: any): Observable<Match[]> {
    return this.http.get<Match[]>(`${baseUrl}?club=${club}`);
  }
}
