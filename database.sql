drop table if exists arena;

drop table if exists game;

drop table if exists game_genre;

drop table if exists genre;

drop table if exists host;

drop table if exists pc;

drop table if exists player;

drop table if exists prize;

drop table if exists sponsor;

drop table if exists team;

drop table if exists team_sponsor;

drop table if exists tournament;

drop table if exists tournament_host;

drop table if exists tournament_prize;

drop table if exists tournament_team;

/*==============================================================*/
/* Table: arena                                                 */
/*==============================================================*/
create table arena
(
   arena_id             int not null auto_increment,
   name                 varchar(1024) not null,
   country              varchar(1024) not null,
   city                 varchar(1024) not null,
   primary key (arena_id)
);

/*==============================================================*/
/* Table: game                                                  */
/*==============================================================*/
create table game
(
   game_id              int not null auto_increment,
   name                 varchar(1024) not null,
   release_year         int not null,
   publisher            varchar(1024) not null,
   primary key (game_id)
);

/*==============================================================*/
/* Table: game_genre                                            */
/*==============================================================*/
create table game_genre
(
   game_genre_id        int not null auto_increment,
   genre_id             int not null,
   game_id              int not null,
   primary key (game_genre_id, genre_id, game_id)
);

/*==============================================================*/
/* Table: genre                                                 */
/*==============================================================*/
create table genre
(
   genre_id             int not null auto_increment,
   name                 varchar(1024) not null,
   primary key (genre_id)
);

/*==============================================================*/
/* Table: host                                                  */
/*==============================================================*/
create table host
(
   host_id              int not null auto_increment,
   first_name           varchar(1024) not null,
   last_name            varchar(1024) not null,
   gender               varchar(1024) not null,
   jmbg                 varchar(13) not null,
   years_experience     int not null,
   primary key (host_id)
);

/*==============================================================*/
/* Table: pc                                                    */
/*==============================================================*/
create table pc
(
   pc_id                int not null auto_increment,
   gpu                  varchar(1024) not null,
   cpu                  varchar(1024) not null,
   ram                  int not null,
   ip_address           varchar(1024) not null,
   primary key (pc_id)
);


/*==============================================================*/
/* Table: player                                                */
/*==============================================================*/
create table player
(
   player_id            int not null auto_increment,
   first_name           varchar(1024) not null,
   last_name            varchar(1024) not null,
   gender               varchar(1024) not null,
   team_id              int not null,
   dob                  date not null,
   ign                  varchar(1024) not null,
   primary key (player_id)
);

/*==============================================================*/
/* Table: prize                                                 */
/*==============================================================*/
create table prize
(
   prize_id             int not null auto_increment,
   sponsor_id           int not null,
   name                 varchar(1024) not null,
   description          varchar(1024) not null,
   primary key (prize_id)
);

/*==============================================================*/
/* Table: sponsor                                               */
/*==============================================================*/
create table sponsor
(
   sponsor_id           int not null auto_increment,
   name                 varchar(1024) not null,
   primary key (sponsor_id)
);

/*==============================================================*/
/* Table: team                                                  */
/*==============================================================*/
create table team
(
   team_id              int not null auto_increment,
   pc_id                int not null,
   name                 varchar(1024) not null,
   year_est             int not null,
   tag                  varchar(1024) not null,
   primary key (team_id)
);

/*==============================================================*/
/* Table: team_sponsor                                          */
/*==============================================================*/
create table team_sponsor
(
   team_sponsor_id      int not null auto_increment,
   sponsor_id           int not null,
   team_id              int not null,
   primary key (team_sponsor_id, sponsor_id, team_id)
);

/*==============================================================*/
/* Table: tournament                                            */
/*==============================================================*/
create table tournament
(
   tournament_id        int not null auto_increment,
   arena_id             int not null,
   game_id              int,
   name                 varchar(1024) not null,
   date                 date not null,
   primary key (tournament_id)
);

/*==============================================================*/
/* Table: tournament_host                                       */
/*==============================================================*/
create table tournament_host
(
   tournament_host_id   int not null auto_increment,
   host_id              int not null,
   tournament_id        int not null,
   primary key (tournament_host_id, host_id, tournament_id)
);

/*==============================================================*/
/* Table: tournament_prize                                      */
/*==============================================================*/
create table tournament_prize
(
   tournament_prize_id  int not null auto_increment,
   prize_id             int not null,
   team_id              int not null,
   tournament_id        int not null,
   primary key (tournament_prize_id)
);

/*==============================================================*/
/* Table: tournament_team                                       */
/*==============================================================*/
create table tournament_team
(
   tournament_team_id   int not null auto_increment,
   tournament_id        int not null,
   team_id              int not null,
   primary key (tournament_team_id, tournament_id, team_id)
);

alter table game_genre add constraint fk_is foreign key (genre_id)
      references genre (genre_id) on delete cascade on update cascade;

alter table game_genre add constraint fk_is2 foreign key (game_id)
      references game (game_id) on delete cascade on update cascade;

alter table player add constraint fk_has foreign key (team_id)
      references team (team_id) on delete cascade on update cascade;

alter table prize add constraint fk_finances foreign key (sponsor_id)
      references sponsor (sponsor_id) on delete cascade on update cascade;

alter table team add constraint fk_plays_on foreign key (pc_id)
      references pc (pc_id) on delete cascade on update cascade;

alter table team_sponsor add constraint fk_sponsored foreign key (sponsor_id)
      references sponsor (sponsor_id) on delete cascade on update cascade;

alter table team_sponsor add constraint fk_sponsored2 foreign key (team_id)
      references team (team_id) on delete cascade on update cascade;

alter table tournament add constraint fk_is_located_at foreign key (arena_id)
      references arena (arena_id) on delete cascade on update cascade;

alter table tournament add constraint fk_plays foreign key (game_id)
      references game (game_id) on delete cascade on update cascade;

alter table tournament_host add constraint fk_hosted foreign key (host_id)
      references host (host_id) on delete cascade on update cascade;

alter table tournament_host add constraint fk_hosted2 foreign key (tournament_id)
      references tournament (tournament_id) on delete cascade on update cascade;

alter table tournament_prize add constraint fk_awards foreign key (prize_id)
      references prize (prize_id) on delete cascade on update cascade;

alter table tournament_prize add constraint fk_on foreign key (tournament_id)
      references tournament (tournament_id) on delete cascade on update cascade;

alter table tournament_prize add constraint fk_won foreign key (team_id)
      references team (team_id) on delete cascade on update cascade;

alter table tournament_team add constraint fk_participates foreign key (tournament_id)
      references tournament (tournament_id) on delete cascade on update cascade;

alter table tournament_team add constraint fk_participates2 foreign key (team_id)
      references team (team_id) on delete cascade on update cascade;
