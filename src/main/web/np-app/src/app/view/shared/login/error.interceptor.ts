import { LoginService } from './../../../controller/services/login.service';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private loginService: LoginService,
        private router: Router) { }
        
        intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
            return next.handle(request).pipe(catchError(err => {
                if (err.status === 401) {
                    this.loginService.logout();
                    this.router.navigate(['/login']);
                }
                return throwError(err);
            }));
        }
    }
    