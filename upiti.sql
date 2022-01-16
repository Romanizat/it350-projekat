# TODO: 1. zadatak
# Prikazati tagove svih timova koji imaju
# igrace koji u svom IGN-u imaju broj jedan
# i koji su osnovani nakon 2019. godine

select t.tag
from player p,
     team t
where p.team_id = t.team_id
  and p.ign like '%1%' and t.year_est > 2019


# TODO: 2. zadatak
# Prikazati sve timove koji ucestvuju
# na turniru koji se održava u Kini. Sortirati timove po broju igraca.

create view team_players as
(
select t.tag tag, count(*) players
from player p,
     team t
where p.team_id = t.team_id
group by t.team_id);

select distinct tp.*
from player p,
     team t,
     arena a,
     tournament_team tt,
     tournament tour,
     team_players tp
where tt.team_id = t.team_id
  and tt.tournament_id = tour.tournament_id
  and tour.arena_id = a.arena_id
  and a.country like 'China'
  and tp.tag = t.tag
group by tp.players, tp.tag
order by tp.players desc;

# TODO: 3. zadatak
# Prikazati sve nagrade koje je
# osvojio svaki tim na poslednjem održanom turniru.

create view team_prizes as
(select tp.prize_id prize_id,tp.team_id team_id
 from tournament_prize tp
 where tp.tournament_id =
       (select t.tournament_id
        from tournament t
        order by t.date desc
        limit 1));

select prize.name, prize.description, team.name
from prize,
     team,
     team_prizes tp
where prize.prize_id = tp.prize_id
  and team.team_id = tp.team_id;


# TODO: 4. zadatak
# Prikazati broj voditelja za svaki turnir koji se
# izvodi u Areni 1, ukoliko je broj voditelja veci od 1

select count(*) host_count, t.name
from tournament_host th,
     host h,
     tournament t,
     arena a
where th.tournament_id = t.tournament_id
  and th.host_id = h.host_id
  and t.arena_id = a.arena_id
  and a.arena_id = 1
group by th.tournament_id
having host_count > 1

# TODO: 5. zadatak

# Prikazati sponzora koji finansira maksimalni broj nagrada,
# ukoliko ima više takvih sponzora prikazati ih sve.

select s.*, count(*) count
from sponsor s,
     prize p
where s.sponsor_id = p.sponsor_id
group by p.sponsor_id
having count >= (select count(*) count
                 from sponsor s,
                      prize p
                 where s.sponsor_id = p.sponsor_id
                 group by p.sponsor_id
                 order by count desc
                 limit 1)

# TODO: 6. zadatak
# Prikazati tim koji ima racunar sa najvecom kolicinom rama
# i procesorom  ciji je proizvodjac Intel

select team.*, pc.ram, pc.cpu
from team,
     pc
where team.pc_id = pc.pc_id
  and pc.cpu like '%Intel%'
  and pc.ram in (select max(pc.ram)
                 from pc)
group by team.pc_id

