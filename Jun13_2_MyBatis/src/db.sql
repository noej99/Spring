create table jun13_snack(
	s_name varchar2(10 char) primary key,
	s_price number(5) not null
);

drop table jun13_snack

insert into JUN13_SNACK values('새우깡', 1600);

select * from jun13_snack;

delete from JUN13_SNACK where s_name = '알새우칩'

update jun13_snack
set s_price = s_price - 500
where s_price > 5000
-- db작업은 위험
-- 작업 -> commit해야 실제 서버에 반영/rollback하면 취소
-- 이클립스/JDBC/Connetion Pool이 자동 commit이었음