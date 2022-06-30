import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Player } from 'src/app/models/player.model';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css']
})
export class PlayerDetailsComponent implements OnInit {

  @Input() viewMode = false;
  @Input() currentPlayer: Player = {
    firstName: '',
    lastName: '',
    age: 0,
    club: ''
  };
  
  message = '';
  constructor(
    private playerService: PlayerService,
    private route: ActivatedRoute,
    private router: Router) { }
  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getPlayer(this.route.snapshot.params["id"]);
    }
  }
  getPlayer(id: string): void {
    this.playerService.get(id)
      .subscribe({
        next: (data) => {
          this.currentPlayer = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updatePlayer(): void {
    this.message = '';
    this.playerService.update(this.currentPlayer.id, this.currentPlayer)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'Dane piłkarza zostały pomyślnie zaktualizowane!';
        },
        error: (e) => console.error(e)
      });
  }
  deletePlayer(): void {
    this.playerService.delete(this.currentPlayer.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/players']);
        },
        error: (e) => console.error(e)
      });
  }

}
