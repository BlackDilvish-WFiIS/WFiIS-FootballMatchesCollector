import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';

import { ClubListComponent } from './components/club-list/club-list.component';
import { ClubDetailsComponent } from './components/club-details/club-details.component';
import { AddClubComponent } from './components/add-club/add-club.component';

import { PlayerListComponent } from './components/player-list/player-list.component';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import { AddPlayerComponent } from './components/add-player/add-player.component';

import { MatchListComponent } from './components/match-list/match-list.component';
import { MatchDetailsComponent } from './components/match-details/match-details.component';
import { AddMatchComponent } from './components/add-match/add-match.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'clubs', component: ClubListComponent },
  { path: 'clubs/:id', component: ClubDetailsComponent },
  { path: 'addclub', component: AddClubComponent },
  { path: 'players', component: PlayerListComponent },
  { path: 'players/:id', component: PlayerDetailsComponent },
  { path: 'addplayer', component: AddPlayerComponent },
  { path: 'matches', component: MatchListComponent },
  { path: 'matches/:id', component: MatchDetailsComponent },
  { path: 'addmatch', component: AddMatchComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }