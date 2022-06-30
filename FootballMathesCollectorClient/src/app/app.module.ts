import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { AddClubComponent } from './components/add-club/add-club.component';
import { ClubDetailsComponent } from './components/club-details/club-details.component';
import { ClubListComponent } from './components/club-list/club-list.component';
import { AddPlayerComponent } from './components/add-player/add-player.component';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import { PlayerListComponent } from './components/player-list/player-list.component';
import { AddMatchComponent } from './components/add-match/add-match.component';
import { MatchDetailsComponent } from './components/match-details/match-details.component';
import { MatchListComponent } from './components/match-list/match-list.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    AddClubComponent,
    ClubDetailsComponent,
    ClubListComponent,
    AddPlayerComponent,
    PlayerDetailsComponent,
    PlayerListComponent,
    AddMatchComponent,
    MatchDetailsComponent,
    MatchListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }