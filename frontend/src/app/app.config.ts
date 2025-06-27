import { HashLocationStrategy, LocationStrategy } from "@angular/common";
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptors } from "@angular/common/http";
import { ApplicationConfig } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule, provideAnimations } from '@angular/platform-browser/animations';
import { provideRouter } from '@angular/router';
import { JWT_OPTIONS, JwtHelperService, JwtInterceptor } from "@auth0/angular-jwt";
import { ConfirmationService, MessageService } from 'primeng/api';
import { routes } from './app.routes';
import { apiInterceptor } from "./interceptors/api.interceptor";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

export const httpInterceptorsProviders = [
	// {provide: HTTP_INTERCEPTORS, useClass: ApiUrlInterceptor, multi: true},
	{provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
];

export const appConfig: ApplicationConfig = {
	providers: [
		provideRouter(routes),
		provideAnimations(),
		provideHttpClient(withInterceptors([apiInterceptor])),
		JwtHelperService,
		httpInterceptorsProviders,
		BrowserAnimationsModule,
		FormsModule,
		ConfirmationService,
		MessageService,
		{ provide: LocationStrategy, useClass: HashLocationStrategy },
		{ provide: JWT_OPTIONS, useValue: JWT_OPTIONS }, provideAnimationsAsync()
	],
};
