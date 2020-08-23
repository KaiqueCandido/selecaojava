import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HandleErrosService } from './handleErros.service';
import { catchError, map, retry } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})

export class LoginService {
    
    urlService: string = undefined;
    api_ref: string = environment.API_URL;
    subject = new Subject<any>();
    
    constructor(
        public httpClient: HttpClient,
        public handleErrosService: HandleErrosService
        ) {
        }
        
        //define a url
        public tipoUrl(url) {
            this.urlService = url;
        }
        
        //logar
        public logar(item: any) {
            return this.httpClient.post<any>(`${this.api_ref}/${this.urlService}`, item, { observe: 'response' })
            .pipe(map(resp => {
                if (resp.body.token) {
                    this.setSession(resp.body);
                }
            }))
            .pipe(
                retry(3),
                catchError(this.handleErrosService.handleError)
                );
            }
            
            setSession(authResult) {
                const token = authResult.token.substr(7);
                localStorage.setItem('token', authResult.token);
            }
            
            // responsável por verificar se o token é diferente de null
            isLoggedIn() {
                return (localStorage.getItem('token') !== null);
            }
            
            // responsável por limpar o localstorage
            logout() {
                localStorage.removeItem('token');
            }
            
        }
        