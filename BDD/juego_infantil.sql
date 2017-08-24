/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     23/08/2017 16:01:37                          */
/*==============================================================*/


drop table if exists juego;

drop table if exists puntaje;

drop table if exists usuario;

/*==============================================================*/
/* Table: juego                                                 */
/*==============================================================*/
create table juego
(
   cod_juego            int(30) not null auto_increment,
   juego_nombre         varchar(100),
   jue_imagen           varchar(200),
   jue_tipo_juego       varchar(20),
   primary key (cod_juego)
);

/*==============================================================*/
/* Table: puntaje                                               */
/*==============================================================*/
create table puntaje
(
   cod_puntaje          int(30) not null auto_increment,
   cod_juego            int,
   jugador              varchar(100),
   puntos               decimal(8,2),
   puntos_dos           decimal(8,2),
   primary key (cod_puntaje)
);

/*==============================================================*/
/* Table: usuario                                               */
/*==============================================================*/
create table usuario
(
   cod_usuario          int(30) not null auto_increment,
   usu_nombre           varchar(100),
   usu_login            varchar(100),
   usu_password         varchar(100),
   usu_correo           varchar(100),
   usu_nivel            int,
   usu_foto             longblob,
   usu_tipo_usuario     varchar(100),
   primary key (cod_usuario)
);

alter table puntaje add constraint fk_relationship_2 foreign key (cod_juego)
      references juego (cod_juego) on delete restrict on update restrict;

