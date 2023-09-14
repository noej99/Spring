create table jul07_coffee(
	c_name varchar2(20 char) primary key,
	c_price number(5) not null
);

select * from JUL07_COFFEE;

insert into JUL07_COFFEE values('아이스아메리카노', 3000);
insert into JUL07_COFFEE values('아메리카노', 2500);
insert into JUL07_COFFEE values('카페라떼', 3500);
insert into JUL07_COFFEE values('아이스카페라떼', 4000);

-- Node.js와 OracleDB 조합 어색
-- SpringMVC프로젝트에서 쓸건데, 굳이 Node.js로 해서
-- Cross-Domain AJAX를 하나...
coffee.get -> json : spring
coffee.reg -> json