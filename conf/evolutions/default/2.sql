# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

insert into COCKTAIL values (1, 'Margarita');
insert into COCKTAIL values (2, 'Caipirinha');
insert into COCKTAIL values (3, 'Piña colada');

# --- !Downs

delete COCKTAIL

