create table jun26_coffee(
	jc_name varchar2(20 char) primary key,
	jc_price number(5) not null
);

insert into jun26_coffee values('아메리카노', 3000);
insert into jun26_coffee values('아이스아메리카노', 3500);
insert into jun26_coffee values('아메리카노디카페인', 4500);
insert into jun26_coffee values('아이스아메리카노디카페인', 5000);
insert into jun26_coffee values('카페라떼', 4500);
insert into jun26_coffee values('아이스카페라떼', 5000);
insert into jun26_coffee values('고구마라떼', 5000);
insert into jun26_coffee values('아이스고구마라떼', 5500);
insert into jun26_coffee values('녹차라떼', 4500);
insert into jun26_coffee values('아이스녹차라떼', 5000);
insert into jun26_coffee values('자몽에이드', 5000);
insert into jun26_coffee values('레몬에이드', 5000);
insert into jun26_coffee values('카푸치노', 4500);
insert into jun26_coffee values('아이스카푸치노', 5000);
insert into jun26_coffee values('에스프레소', 3000);
insert into jun26_coffee values('바닐라라떼', 5000);
insert into jun26_coffee values('아이스바닐라라떼', 5500);


create table jun27_snack (
	s_name varchar2(20 char) primary key,
	s_price number(5) not null
);

insert into JUN27_SNACK values('초코파이', 5500);
insert into JUN27_SNACK values('오감자', 2500);
insert into JUN27_SNACK values('오징어땅콩', 1500);
insert into JUN27_SNACK values('새우깡', 1600);
insert into JUN27_SNACK values('고구마깡', 1600);
insert into JUN27_SNACK values('빅파이', 4000);
insert into JUN27_SNACK values('후렌치파이딸기맛', 6000);
insert into JUN27_SNACK values('후렌치파이사과맛', 6000);
insert into JUN27_SNACK values('꿀꽈배기', 1400);
insert into JUN27_SNACK values('고래밥', 1200);
insert into JUN27_SNACK values('쫄병스낵', 1000);
insert into JUN27_SNACK values('허니버터칩', 1800);
insert into JUN27_SNACK values('포테이토칩', 2500);
insert into JUN27_SNACK values('스윙칩', 2500);
insert into JUN27_SNACK values('도리토스', 2300);
insert into JUN27_SNACK values('빼빼로', 1200);
insert into JUN27_SNACK values('뿌셔뿌셔', 1200);
insert into JUN27_SNACK values('자갈치', 1500);
insert into JUN27_SNACK values('콘칩', 1700);
insert into JUN27_SNACK values('꼬깔콘', 1500);
insert into JUN27_SNACK values('키드오', 1100);
insert into JUN27_SNACK values('초코송이', 1000);
insert into JUN27_SNACK values('조리퐁', 1300);

select *
from (
	select rownum as rn, s_name, s_price
	from (
		select *
		from JUN27_SNACK
		order by s_name
	)
)
where rn >= 1 and rn <=5

		select *
		from (
			select rownum as rn, s_name, s_price
			from (
				select *
				from JUN27_SNACK
				order by s_name
			)
		)
		where rn &gt;=1 and rn &lt;=5