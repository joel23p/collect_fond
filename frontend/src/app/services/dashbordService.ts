import { Injectable } from '@angular/core';
import { Observable, of, BehaviorSubject } from 'rxjs';
import {
	Contribution,
	ContributionType,
	ContributionSummary,
	Member,
	MonthlyData,
	Alert
} from '../models/contribution.model';

@Injectable({
	providedIn: 'root'
})
export class DashboardService {
	private contributionsSubject = new BehaviorSubject<Contribution[]>([]);
	private membersSubject = new BehaviorSubject<Member[]>([]);
	private alertsSubject = new BehaviorSubject<Alert[]>([]);

	constructor() {
		this.initializeMockData();
	}

	private initializeMockData(): void {
		// Mock data pour les contributions
		const mockContributions: Contribution[] = [
			{ id: '1', type: ContributionType.ENFANT, amount: 1250, memberName: 'Marie Dupont', memberId: 'm1', date: new Date('2024-01-15') },
			{ id: '2', type: ContributionType.ORDINAIRE, amount: 1536, memberName: 'Jean Martin', memberId: 'm2', date: new Date('2024-01-14') },
			{ id: '3', type: ContributionType.BRONZE, amount: 1806, memberName: 'Alice Robert', memberId: 'm3', date: new Date('2024-01-13') },
			{ id: '4', type: ContributionType.VIP, amount: 3156, memberName: 'Paul Bernard', memberId: 'm4', date: new Date('2024-01-12') },
			{ id: '5', type: ContributionType.OR, amount: 3900, memberName: 'Sophie Moreau', memberId: 'm5', date: new Date('2024-01-11') },
		];

		// Mock data pour les membres
		const mockMembers: Member[] = [
			{ id: 'm1', name: 'Marie Dupont', email: 'marie@email.com', phone: '123456789', contributionType: ContributionType.ENFANT, lastContributionDate: new Date('2024-01-15'), totalContributions: 15000, isActive: true, joinDate: new Date('2023-01-01') },
			{ id: 'm2', name: 'Jean Martin', email: 'jean@email.com', phone: '987654321', contributionType: ContributionType.ORDINAIRE, lastContributionDate: new Date('2024-01-14'), totalContributions: 43000, isActive: true, joinDate: new Date('2023-02-01') },
			{ id: 'm3', name: 'Alice Robert', email: 'alice@email.com', phone: '456789123', contributionType: ContributionType.BRONZE, lastContributionDate: new Date('2023-10-15'), totalContributions: 12000, isActive: false, joinDate: new Date('2023-03-01') },
		];

		// Mock data pour les alertes
		const mockAlerts: Alert[] = [
			{ id: 'a1', type: 'warning', title: 'Membres inactifs', message: '5 membres n\'ont pas contribué depuis plus de 3 mois', date: new Date(), isRead: false },
			{ id: 'a2', type: 'info', title: 'Objectif mensuel', message: 'Objectif de collecte du mois atteint à 85%', date: new Date(), isRead: false },
			{ id: 'a3', type: 'danger', title: 'Contribution en retard', message: '3 membres ont des contributions en retard', date: new Date(), isRead: false },
		];

		this.contributionsSubject.next(mockContributions);
		this.membersSubject.next(mockMembers);
		this.alertsSubject.next(mockAlerts);
	}

	getContributionsSummary(): Observable<ContributionSummary[]> {
		const contributions = this.contributionsSubject.value;

		const summaryMap = new Map<ContributionType, ContributionSummary>();

		// Initialiser avec les données par défaut
		const defaultSummaries: ContributionSummary[] = [
			{ type: ContributionType.ENFANT, count: 12, totalAmount: 15000, color: 'success', icon: 'pi-users', label: 'Cotisation Enfant' },
			{ type: ContributionType.ORDINAIRE, count: 28, totalAmount: 43000, color: 'primary', icon: 'pi-user', label: 'Cotisation Ordinaire' },
			{ type: ContributionType.BRONZE, count: 18, totalAmount: 32500, color: 'warning', icon: 'pi-star-fill', label: 'Cotisation Bronze' },
			{ type: ContributionType.ARGENT, count: 14, totalAmount: 25800, color: 'secondary', icon: 'pi-money-bill', label: 'Cotisation Argent' },
			{ type: ContributionType.OR, count: 10, totalAmount: 39000, color: 'warning', icon: 'pi-sun', label: 'Cotisation Or' },
			{ type: ContributionType.DIAMANT, count: 5, totalAmount: 21700, color: 'info', icon: 'pi-box', label: 'Cotisation Diamant' },
			{ type: ContributionType.VIP, count: 9, totalAmount: 28400, color: 'danger', icon: 'pi-star', label: 'Cotisation VIP' },
			{ type: ContributionType.PASTORAL, count: 3, totalAmount: 12000, color: 'dark', icon: 'pi-verified', label: 'Soutien pastoral' }
		];

		defaultSummaries.forEach(summary => summaryMap.set(summary.type, summary));

		return of(Array.from(summaryMap.values()));
	}

	getRecentContributions(): Observable<Contribution[]> {
		const contributions = this.contributionsSubject.value;
		const recent = contributions
			.sort((a, b) => b.date.getTime() - a.date.getTime())
			.slice(0, 10);
		return of(recent);
	}

	getMonthlyData(): Observable<MonthlyData[]> {
		const mockData: MonthlyData[] = [
			{ month: 'Jan', amount: 45000, contributionsCount: 25 },
			{ month: 'Fév', amount: 52000, contributionsCount: 30 },
			{ month: 'Mar', amount: 48000, contributionsCount: 28 },
			{ month: 'Avr', amount: 55000, contributionsCount: 32 },
			{ month: 'Mai', amount: 60000, contributionsCount: 35 },
			{ month: 'Jun', amount: 58000, contributionsCount: 33 },
		];
		return of(mockData);
	}

	getMembers(): Observable<Member[]> {
		return this.membersSubject.asObservable();
	}

	getAlerts(): Observable<Alert[]> {
		return this.alertsSubject.asObservable();
	}

	markAlertAsRead(alertId: string): void {
		const alerts = this.alertsSubject.value;
		const updatedAlerts = alerts.map(alert =>
			alert.id === alertId ? { ...alert, isRead: true } : alert
		);
		this.alertsSubject.next(updatedAlerts);
	}

	getInactiveMembers(): Observable<Member[]> {
		const members = this.membersSubject.value;
		const threeMonthsAgo = new Date();
		threeMonthsAgo.setMonth(threeMonthsAgo.getMonth() - 3);

		const inactiveMembers = members.filter(member =>
			member.lastContributionDate < threeMonthsAgo
		);

		return of(inactiveMembers);
	}

	getTotalStats(): Observable<{totalMembers: number, totalAmount: number, totalContributions: number}> {
		const members = this.membersSubject.value;
		const totalStats = {
			totalMembers: 99,
			totalAmount: 217400,
			totalContributions: 99
		};
		return of(totalStats);
	}
}
