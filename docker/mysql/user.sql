CREATE TABLE `user`(
`id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT 'index',
`name` varchar(50) NOT NULL COMMENT '사용자 이름',
`age` int null default '1' comment '사용자 나이',
`email` varchar(100) NULL DEFAULT '' COMMENT '이메일 주소',
PRIMARY KEY(`id`)
);

name: null을 허용하지 않음
email: null을 허용하지만 기본 값은 빈 문자열임
-----------------------------------------------------------------------------
INSERT INTO `user`
(
    `name`,
    `age`,
    `email`
)
VALUES
(
	'홍길동',
     10 ,
     'homg@email.com'
);

id: AUTO_INCREMENT 이기에 INSERT 안함
age, email도 default 값이 지정되어 있어서 안해도 됨

-----------------------------------------------------------------------------

UPDATE `user` SET
age=20
WHERE
id>0 and name='유관순'

id>0 && name=유관순인 데이터의 age를 20으로  변경