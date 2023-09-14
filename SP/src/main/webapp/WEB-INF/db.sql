create table sp_member (
	sm_id varchar2(12 char) primary key,
	sm_pw varchar2(20 char) not null,
	sm_name varchar2(10 char) not null,
	sm_birthday date not null,
	sm_addr varchar2(200 char) not null,
	sm_img varchar2(100 char) not null
);

select * from sp_member

---------------------------------

create table sp_sns (
	ss_no number(4) primary key,
	ss_writer varchar2(10 char) not null,
	ss_txt varchar2(500 char) not null,
	ss_date date not null,
	ss_color char(6 char) not null,	-- 색깔(AI추천)
	constraint sp_sns_writer
		foreign key (ss_writer) references sp_member(sm_id)
		on delete cascade
);

create sequence sp_sns_seq;

select ss_no, ss_writer, ss_txt, ss_date, ss_color, sm_img from SP_SNS, sp_member where ss_writer = sm_id order by ss_date desc
---------------------------------
-- 빅데이터
create table sp_weather_color(
	swc_temp number(4, 2) not null,
	swc_humidity number(4, 2) not null,
	swc_description varchar2(20 char) not null,
	swc_color char(6 char) not null
);

select * from sp_weather_color
---------------------------------
select *
from (
	select rownum as rn, ss_no, ss_writer, ss_txt, ss_date, ss_color, sm_img
	from (
		select *
		from sp_sns, sp_member
		where ss_writer = sm_id and (ss_writer like '%22%' or ss_txt like '%22%')
		order by ss_date desc
	)
)
where rn >= 1 and rn <= 100

-- 1. 날짜 역순으로 1 ~ 5까지 글
select *
	from (
		select rownum as rn, ss_no, ss_writer, ss_txt, ss_date, ss_color
		from (
			select *
			from sp_sns
			where ss_writer like '%비%' or ss_txt like '%비%'
			order by ss_date desc
	)
)
where rn >= 1 and rn <= 5

-- 2. 날짜 역순으로 1 ~ 5까지 글을 쓴 사람
select sm_id, sm_img
from sp_member
where sm_id in (
	select ss_writer
	from (
		select rownum as rn, ss_writer
		from (
			select ss_writer
			from sp_sns
			where ss_writer like '%%' or ss_txt like '%%'
			order by ss_date desc
		)
	)
	where rn >= 1 and rn <= 5
);



-- join
select ss_no, ss_writer, ss_txt, ss_date, sm_img
from (1),(2)
where ss_writer = sm_id
order by ss_date desc


select ss_no, ss_writer, ss_txt, ss_date, ss_color, sm_img
from (
	select *
	from (
		select rownum as rn, ss_no, ss_writer, ss_txt, ss_date, ss_color
		from (
			select *
			from sp_sns
			where ss_writer like '%비%' or ss_txt like '%비%'
			order by ss_date desc
		)
	)
	where rn >= 1 and rn <= 5
), (
	select sm_id, sm_img
	from sp_member
	where sm_id in (
		select ss_writer
		from (
			select rownum as rn, ss_writer
			from (
				select ss_writer
				from sp_sns
				where ss_writer like '%비%' or ss_txt like '%비%'
				order by ss_date desc
			)
		)
		where rn >= 1 and rn <= 5
	)
)
where ss_writer = sm_id
order by ss_date desc

-----------------------------------

create table sp_sns_reply (
	ssr_no number(5) primary key,
	ssr_ss_no number(5) not null,
	ssr_writer varchar2(10 char) not null,
	ssr_txt varchar2(200 char) not null,
	ssr_date date not null,
	constraint sp_sns_reply_writer
		foreign key (ssr_writer) references sp_member(sm_id)
		on delete cascade,
	constraint sp_sns_reply
		foreign key (ssr_ss_no) references sp_sns(ss_no)
		on delete cascade
);

create sequence sp_sns_reply_seq

select * from SP_SNS_REPLY
-----------------------------------
create table sp_dr (
	sd_no number(3) primary key,
	sd_uploader varchar2(10 char) not null,
	sd_title varchar2(50 char) not null,
	sd_file varchar2(500 char) not null,
	sd_category char(6 char) not null,
	sd_date date not null,
	constraint dr_uploader
		foreign key (sd_uploader) references sp_member(sm_id)
		on delete cascade
);
delete sp_dr
select * from sp_dr
create sequence sp_dr_seq;


drop table sp_dr
drop sequence sp_dr_seq

----------------------------------------

create table sp_gallery (
	sg_no number(4) primary key,
	sg_writer varchar2(10 char) not null,
	sg_txt varchar2(500 char) not null,
	sg_img varchar2(100 char) not null,
	sg_date date not null,
	constraint spg_writer
		foreign key (sg_writer) references sp_member(sm_id)
		on delete cascade
);

create sequence sp_gallery_seq;
drop sequence sp_gallery_seq
drop table sp_gallery
select * from sp_gallery
