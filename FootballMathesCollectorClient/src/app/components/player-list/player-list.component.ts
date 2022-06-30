import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/player.model';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

  players?: Player[];
  currentPlayer: Player = {};
  currentIndex = -1;
  name = '';
  club = '';
  constructor(private playerService: PlayerService) { }
  ngOnInit(): void {
    this.retrievePlayers();
  }
  retrievePlayers(): void {
    this.playerService.getAll()
      .subscribe({
        next: (data) => {
          this.players = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    
  }
  refreshList(): void {
    this.retrievePlayers();
    this.currentPlayer = {};
    this.currentIndex = -1;
  }
  setActivePlayer(player: Player, index: number): void {
    this.currentPlayer = player;
    this.currentIndex = index;
  }
  removeAllPlayers(): void {
    this.playerService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }
  searchlastName(): void {
    this.currentPlayer = {};
    this.currentIndex = -1;
    this.playerService.findBylastName(this.name)
      .subscribe({
        next: (data) => {
          this.players = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  searchclub(): void {
    this.currentPlayer = {};
    this.currentIndex = -1;
    this.playerService.findByClub(this.club)
      .subscribe({
        next: (data) => {
          this.players = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

}
