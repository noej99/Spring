create table wp_member(
	wm_id varchar2(10char) primary key,
	wm_pw varchar2(30char) not null,
	wm_name varchar2(10char) not null,
	wm_birth date not null,
	wm_addr varchar2(100char) not null,
	wm_photo varchar2(100char) not null
);

insert into wp_member values('test', '12345', '홍길동', to_date('19990101', 'YYYYMMDD'), '서울시 종로구', 'popcat.jpg');
insert into wp_member values(?, ?, ?, to_date(?, 'YYYYMMDD'), ?, ?)

select * from wp_member;

delete wp_member;
------------------------------------------------
-- 로그인
-- 입력한 id/pw랑
-- db에 있는 id/pw랑 비교

-- 1) 모든 계정 다 가져와서
-- DAO에서 for + if로 비교
-- 계정이 많으면...
select *
from wp_member;

-- 2) id/pw 맞는 계정만 가져와서
-- DAO에서 로그인 성공처리하자
-- SQL injection공격에 취약
select *
from wp_member
where wm_id='test' and wm_pw='12345';

-- 3)  id맞는 계정만 가져와서
-- DAO에서 비번검사
select *
from wp_member
where wm_id='test';

-- 스마트폰 앱 -> 하이브리드 앱 -> 보안코딩 -> BD/AI
------------------------------------------------

delete from wp_member where wm_id = ?;

update wp_member
set wm_pw = '1111', wm_name = 'sss', wm_addr = 'sss!ssss!sss', wm_photo = 'zzz.gif'
where wm_id = 'zzzz'

create table wp_sns(
	ws_no number(3) primary key,
	ws_writer varchar2(10 char) not null,
	ws_txt varchar2(500 char) not null,
	ws_date date not null,
	constraint wsns_writer
		foreign key (ws_writer) references wp_member(wm_id)
		on delete cascade
);

create sequence wp_sns_seq;

select * from wp_sns;


drop sequence wp_sns_seq;

delete from wp_sns

select * from wp_sns order by ws_date desc

insert into wp_sns values(wp_sns_seq.nextval, ?, ?, sysdate)
------------------------------------------------

-- 1) 날짜순 역순으로 글만 3 ~ 5번
select *
from (
	select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
	from (
		select *
		from WP_SNS
		order by ws_date desc
	)
)
where rn >= 3 and rn <= 5

-- 2) 날짜순역순으로 3 ~ 5번글 쓴 사람 id, 프사
select wm_id, wm_photo
from wp_member
where wm_id in (
	select ws_writer
		from (
			select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
			from (
				select *
				from WP_SNS
			order by ws_date desc
		)
	)
	where rn >= 3 and rn <= 5
)

-- 3) 1, 2 join
select *
from (1), (2)
where ws_writer = wm_id
order by ws_date desc

select ws_no, wm_id, wm_photo, ws_txt, ws_date
from (
	select *
	from (
		select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
		from (
			select *
			from WP_SNS
			where ws_txt like '%%'
			order by ws_date desc
		)
	)
	where rn >= 3 and rn <= 5
), (
	select wm_id, wm_photo
	from wp_member
	where wm_id in (
		select ws_writer
		from (
			select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
			from (
				select *
				from WP_SNS
				where ws_txt like '%%'
				order by ws_date desc
			)
		)
		where rn >= 3 and rn <= 5
	)
)
where ws_writer = wm_id
order by ws_date desc

select *
from (
	select rownum as rn, ws_no, ws_txt, ws_date, wm_id, wm_photo
	from (
		select ws_no, ws_txt, ws_date, wm_id, wm_photo
		from wp_sns, WP_MEMBER
		where ws_writer = wm_id
		order by ws_date desc
	)
)
where rn >=3 and rn<=5;

select count(*) from wp_sns
글 번호
글 내용
글쓴 날짜
글쓴사람 id
글쓴사람 프사
글쓴사람 이름

댓글
select count(*) from wp_sns where ws_txt like '%%'
select count(*) from wp_sns where ws_txt like '%0%' or ws_writer like '%k%'

delete from WP_SNS where ws_no = ?
------------------------------------------------
update wp_sns set ws_txt = '밥줘' where ws_no = 64


create table wp_sns_reply (
	wsr_no number(5) primary key,
	wsr_ws_no number(3) not null,
	wsr_writer varchar2(10 char) not null,
	wsr_txt varchar2(100 char) not null,
	wsr_date date not null,
	constraint sns_reply
		foreign key (wsr_ws_no) references wp_sns(ws_no)
		on delete cascade,
	constraint sns_reply_writer
		foreign key (wsr_writer) references wp_member(wm_id)
		on delete cascade
);

create sequence wp_sns_reply_seq;

select * from wp_sns_reply;

delete wp_sns_reply;

drop sequence wp_sns_reply_seq;

insert into wp_sns_reply values (wp_sns_reply_seq.nextval, '', '', sysdate);

select *
from WP_SNS_REPLY, wp_sns
where wsr_ws_no = ws_no

select *
from wp_sns_reply
where wsr_ws_no in

select * 
from wp_sns_reply
where wsr_ws_no = 66 
order by wsr_date


delete from wp_sns_reply where wsr_no = 5

update wp_sns_reply set wsr_txt = '뭐' where wsr_no = 15
--------------------------------------------------------------

create table wp_bbs(
	wb_no number(3) primary key,
	wb_writer varchar2(10 char) not null,
	wb_title varchar2(100 char) not null,
	wb_txt varchar2(500 char) not null,
	wb_date date not null,
	constraint bbs_writer
		foreign key (wb_writer) references wp_member(wm_id)
		on delete cascade
);

create sequence wp_bbs_seq;

drop table wp_Bbs

drop sequence wp_bbs_seq;

select * from WP_BBS
select wb_no, wb_title, wb_date from wp_bbs
insert into WP_BBS values(wp_bbs_seq.nextval, 'noej', 'hi', 'hello', sysdate)

select *
from (
	select rownum as rn, wb_no, wb_title, wb_date
	from (
		select *
		from Wp_bbs
		where wb_title like '%2%' or wb_txt like '%2%'
		order by wb_date desc
	)
)
where rn >= 3 and rn <= 5

select count(*) from wp_bbs 

delete from wp_bbs where wb_no=3

update wp_bbs set wb_title = '싫어', wb_txt = '밥줘' where wb_no = 32

select *
from (  
	select rownum as rn, wb_no, wb_title, wb_writer, wb_date 
	from (  
		select *  
		from Wp_bbs  
		where wb_title like '%%' or wb_txt like '%%' 
		order by wb_date desc
	) 
)  
where rn >= 1 and rn <= 10

create table wp_bbs_reply (
	wbr_no number(5) primary key,
	wbr_wb_no number(3) not null,
	wbr_writer varchar2(10 char) not null,
	wbr_txt varchar2(100 char) not null,
	wbr_date date not null,
	constraint bbs_reply
		foreign key (wbr_wb_no) references wp_bbs(wb_no)
		on delete cascade,
	constraint bbs_reply_writer
		foreign key (wbr_writer) references wp_member(wm_id)
		on delete cascade
);

create sequence wp_bbs_reply_seq

select * from wp_Bbs_reply

insert into wp_bbs_reply values(wp_bbs_reply_seq.nextval, 35, '22', '?', sysdate)

select *
from (
	select rownum as rn, ws_no, ws_writer, ws_txt, ws_date, wm_photo
	from (
		select ws_no, ws_writer, ws_txt, ws_date, wm_photo
		from wp_sns, WP_MEMBER
		where ws_Writer = wm_id
		order by ws_date desc
	)
)


select ws_no, ws_writer, ws_txt, ws_date, wm_photo
from (
	select *
	from (
		select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
		from (
			select *
			from wp_sns
			order by ws_date desc
		)
	)
	where rn >= 3 and rn <= 5
),(
	select rownum as rn, wm_id, wm_photo
	from (
		select *
		from wp_member
		where wm_id in (
			select ws_writer
			from (
				select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
				from (
					select *
					from wp_sns
					order by ws_date desc
				)
			)
			where rn>=3 and rn<=5
		)
	)
)
where ws_writer = wm_id
order by ws_date desc;


select *
from (
	select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
	from (
		select *
		from wp_sns
		where ws_txt like '%%' or ws_writer like '%%'
		order by ws_date desc
)
)
where rn >= 1 and rn <= 10

select wm_id, wm_photo
from wp_member
where wm_id in (
	select ws_writer
	from (
		select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
		from (
			select *
			from wp_sns
			where ws_txt like '%%' or ws_writer like '%%'
			order by ws_date desc
		)
	)
	where rn >= 1 and rn <= 10
)


select ws_no, ws_writer, ws_txt, ws_date, wm_photo
from (
	select *
	from (
		select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
		from (
			select *
			from wp_sns
			where ws_txt like '%%' or ws_writer like '%%'
			order by ws_date desc
		)
	)
	where rn >= 1 and rn <= 10
),(
	select wm_id, wm_photo
	from wp_member
	where wm_id in (
		select ws_writer
		from (
			select rownum as rn, ws_no, ws_writer, ws_txt, ws_date
			from (
				select *
				from wp_sns
				where ws_txt like '%%' or ws_writer like '%%'
				order by ws_date desc
			)
		)
		where rn >= 1 and rn <= 10
	)
)
where wm_id = ws_writer
order by ws_date desc

-- 변수 : 데이터 RAM 임시저장

-- join : HDD에 있던 데이터
--			멤버테이블에 100개
--			글테이블에 100개
--			=> 10000개로 만들어서 RAM에