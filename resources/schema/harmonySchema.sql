-- USERS TABLE
create table USERS
(
    USER_ID VARCHAR2(20) not null
        constraint USER_ID
        primary key,
    USER_PW VARCHAR2(20) not null,
    EMAIL   VARCHAR2(40),
    NAME    VARCHAR2(20) not null,
    AGE     NUMBER,
    GENDER  CHAR default 'N',
    CARD    VARCHAR2(20)
)

-- USERS DATA ADD
INSERT INTO USERS (user_id, user_pw, email, name, age, gender) VALUES ('park', '1234', 'park@gmail.com', 'park', 24, 'W');  -- 카드 등록이 안된 사용자
INSERT INTO USERS (user_id, user_pw, email, name, age, gender) VALUES ('jang', '1111', 'jang@hanmail.com', 'jang', 18, 'M');  -- 카드 등록이 안된 사용자
INSERT INTO USERS VALUES ('jeon', '2222', 'jeon@gmail.com', 'jeon', 26, 'W', '1111222233334444');
INSERT INTO USERS VALUES ('lee', '3333', 'lee@naver.com', 'lee', 22, 'M', '1234123412341234');
INSERT INTO USERS VALUES ('kim', '4444', 'kim@gmail.com', 'kim', 29, 'W', '343456566767');

SELECT * FROM USERS;


-- MUSICAL DATA ADD
-- MUSICAL TABLE
create table MUSICAL
(
    MUSICAL_ID NUMBER       not null
        constraint MUSICAL_ID
            primary key,
    TITLE      VARCHAR2(20) not null,
    ACTOR      VARCHAR2(80),
    GENRE      VARCHAR2(80),
    "DATE"     DATE,
    HALL       VARCHAR2(20),
    SUMMARY    VARCHAR2(255),
    PRODUCTION VARCHAR2(20)
)

-- MUSICAL_ID SEQUENCE
CREATE SEQUENCE MUSICAL_SEQ NOCACHE;
-- DROP SEQUENCE MUSICAL_SEQ;


-- 영웅
-- KB홀, 매일 오후 2시 공연
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '영웅', '정성화, 서영주, 린지, 윤석원..', '역사',TO_DATE('20230403140000','YYYY-MM-DD HH24:MI:SS'), 'KB홀',
                            '대한 제국의 주권이 일본에 완전히 빼앗길 위기에 놓인 1909년. 갓 서른 살의 조선 청년 안중근은 러시아 연주의 자작나무 숲에서 동지들과..', '(주)에이콤(ACOM)');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '영웅', '민우혁, 최민철, 정재은, 윤석원..', '역사',TO_DATE('20230404140000','YYYY-MM-DD HH24:MI:SS'), 'KB홀',
                            '대한 제국의 주권이 일본에 완전히 빼앗길 위기에 놓인 1909년. 갓 서른 살의 조선 청년 안중근은 러시아 연주의 자작나무 숲에서 동지들과..', '(주)에이콤(ACOM)');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '영웅', '정성화, 서영주, 린지, 김늘봄..', '역사',TO_DATE('20230405140000','YYYY-MM-DD HH24:MI:SS'), 'KB홀',
                            '대한 제국의 주권이 일본에 완전히 빼앗길 위기에 놓인 1909년. 갓 서른 살의 조선 청년 안중근은 러시아 연주의 자작나무 숲에서 동지들과..', '(주)에이콤(ACOM)');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '영웅', '정성화, 서영주, 린지, 윤석원..', '역사',TO_DATE('20230406140000','YYYY-MM-DD HH24:MI:SS'), 'KB홀',
                            '대한 제국의 주권이 일본에 완전히 빼앗길 위기에 놓인 1909년. 갓 서른 살의 조선 청년 안중근은 러시아 연주의 자작나무 숲에서 동지들과..', '(주)에이콤(ACOM)');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '영웅', '민우혁, 최민철, 정재은, 윤석원..', '역사',TO_DATE('20230407140000','YYYY-MM-DD HH24:MI:SS'), 'KB홀',
                            '대한 제국의 주권이 일본에 완전히 빼앗길 위기에 놓인 1909년. 갓 서른 살의 조선 청년 안중근은 러시아 연주의 자작나무 숲에서 동지들과..', '(주)에이콤(ACOM)');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '영웅', '정성화, 서영주, 린지, 김늘봄..', '역사',TO_DATE('20230408140000','YYYY-MM-DD HH24:MI:SS'), 'KB홀',
                            '대한 제국의 주권이 일본에 완전히 빼앗길 위기에 놓인 1909년. 갓 서른 살의 조선 청년 안중근은 러시아 연주의 자작나무 숲에서 동지들과..', '(주)에이콤(ACOM)');

-- 비밀의 화원
-- Art홀, 매일 오후 5시 공연
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '비밀의 화원', '유낙원, 임진섭, 박선영, 박슬기..', '드라마',TO_DATE('20230403170000','YYYY-MM-DD HH24:MI:SS'), 'Art홀',
                            '1950년대 영국 요크셔의 성 안토니오 보육원. 곧 퇴소를 눈앞에 둔 네 명의 아이. 마지막 오픈데이를 하루 앞둔 날...', '국립정동극장');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '비밀의 화원', '유낙원, 임진섭, 김종형, 류비..', '드라마',TO_DATE('20230404170000','YYYY-MM-DD HH24:MI:SS'), 'Art홀',
                            '1950년대 영국 요크셔의 성 안토니오 보육원. 곧 퇴소를 눈앞에 둔 네 명의 아이. 마지비막 오픈데이를 하루 앞둔 날...', '국립정동극장');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '비밀의 화원', '홍나현, 정백선, 박선영, 박슬기..', '드라마',TO_DATE('20230405170000','YYYY-MM-DD HH24:MI:SS'), 'Art홀',
                            '1950년대 영국 요크셔의 성 안토니오 보육원. 곧 퇴소를 눈앞에 둔 네 명의 아이. 마지막 오픈데이를 하루 앞둔 날...', '국립정동극장');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '비밀의 화원', '유낙원, 임진섭, 박선영, 박슬기..', '드라마',TO_DATE('20230406170000','YYYY-MM-DD HH24:MI:SS'), 'Art홀',
                            '1950년대 영국 요크셔의 성 안토니오 보육원. 곧 퇴소를 눈앞에 둔 네 명의 아이. 마지막 오픈데이를 하루 앞둔 날...', '국립정동극장');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '비밀의 화원', '유낙원, 임진섭, 김종형, 류비..', '드라마',TO_DATE('20230407170000','YYYY-MM-DD HH24:MI:SS'), 'Art홀',
                            '1950년대 영국 요크셔의 성 안토니오 보육원. 곧 퇴소를 눈앞에 둔 네 명의 아이. 마지비막 오픈데이를 하루 앞둔 날...', '국립정동극장');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '비밀의 화원', '홍나현, 정백선, 박선영, 박슬기..', '드라마',TO_DATE('20230408170000','YYYY-MM-DD HH24:MI:SS'), 'Art홀',
                            '1950년대 영국 요크셔의 성 안토니오 보육원. 곧 퇴소를 눈앞에 둔 네 명의 아이. 마지막 오픈데이를 하루 앞둔 날...', '국립정동극장');


-- 오페라의 유령
-- Recital홀, 매일 오후 8시 공연
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '오페라의 유령', '조승우, 손지수, 황건하, 한보라..', '드라마',TO_DATE('20230403200000','YYYY-MM-DD HH24:MI:SS'), 'Recital홀',
                            '13년 간의 긴 기다림.. 환영과도 같은 무대 사라지지 않을 영원한 당신의 첫 감동! 13년 만에 오페라 하우스의 문이 열린다...', '에스앤코');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '오페라의 유령', '김주택, 송은혜, 황건하, 이지영..', '드라마',TO_DATE('20230404200000','YYYY-MM-DD HH24:MI:SS'), 'Recital홀',
                            '13년 간의 긴 기다림.. 환영과도 같은 무대 사라지지 않을 영원한 당신의 첫 감동! 13년 만에 오페라 하우스의 문이 열린다...', '에스앤코');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '오페라의 유령', '전동석, 손지수, 송원근, 한보라..', '드라마',TO_DATE('20230405200000','YYYY-MM-DD HH24:MI:SS'), 'Recital홀',
                            '13년 간의 긴 기다림.. 환영과도 같은 무대 사라지지 않을 영원한 당신의 첫 감동! 13년 만에 오페라 하우스의 문이 열린다...', '에스앤코)');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '오페라의 유령', '조승우, 손지수, 황건하, 한보라..', '드라마',TO_DATE('20230406200000','YYYY-MM-DD HH24:MI:SS'), 'Recital홀',
                            '13년 간의 긴 기다림.. 환영과도 같은 무대 사라지지 않을 영원한 당신의 첫 감동! 13년 만에 오페라 하우스의 문이 열린다...', '에스앤코');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '오페라의 유령', '김주택, 송은혜, 황건하, 이지영..', '드라마',TO_DATE('20230407200000','YYYY-MM-DD HH24:MI:SS'), 'Recital홀',
                            '13년 간의 긴 기다림.. 환영과도 같은 무대 사라지지 않을 영원한 당신의 첫 감동! 13년 만에 오페라 하우스의 문이 열린다...', '에스앤코');
INSERT INTO MUSICAL VALUES (MUSICAL_SEQ.nextval, '오페라의 유령', '전동석, 손지수, 송원근, 한보라..', '드라마',TO_DATE('20230408200000','YYYY-MM-DD HH24:MI:SS'), 'Recital홀',
                            '13년 간의 긴 기다림.. 환영과도 같은 무대 사라지지 않을 영원한 당신의 첫 감동! 13년 만에 오페라 하우스의 문이 열린다...', '에스앤코');


-- SEAT TABLE
create table SEAT
(
    SEATNUM    CHAR(2)          not null,
    MUSICAL_ID NUMBER           not null
        constraint "SEAT_MUSICAL_MUSICAL_ID_fk"
            references MUSICAL,
    SOLD       CHAR default 'N' not null,
    PRICE      NUMBER,
    constraint "SEAT_pk"
        primary key (MUSICAL_ID, SEATNUM)
)

-- SEAT DATA ADD
-- musical_id 1
    INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 1, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 1, '45000');


-- musical_id 2
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 2, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 2, '45000');


-- musical_id 3
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 3, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 3, '45000');


-- musical_id 4
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 4, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 4, '45000');


-- musical_id 5
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 5, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 5, '45000');


-- musical_id 6
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 6, '45000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 6, '45000');


-- musical_id 7
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 7, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 7, '55000');


-- musical_id 8
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 8, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 8, '55000');


-- musical_id 9
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 9, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 9, '55000');


-- musical_id 10
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 10, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 10, '55000');


-- musical_id 11
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 11, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 11, '55000');


-- musical_id 12
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 12, '55000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 12, '55000');


-- musical_id 13
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 13, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 13, '60000');


-- musical_id 14
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 14, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 14, '60000');


-- musical_id 15
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 15, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 15, '60000');


-- musical_id 16
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 16, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 16, '60000');


-- musical_id 17
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 17, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 17, '60000');



-- musical_id 18
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A1', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A2', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A3', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A4', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('A5', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B1', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B2', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B3', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B4', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('B5', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C1', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C2', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C3', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C4', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('C5', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D1', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D2', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D3', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D4', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('D5', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E1', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E2', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E3', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E4', 18, '60000');
INSERT INTO SEAT (seatnum, musical_id, price) VALUES ('E5', 18, '60000');


SELECT * FROM SEAT;


-- TICKET TABLE
create table TICKET
(
    TICKET_ID  NUMBER not null
        constraint "TICKET_pk"
            primary key,
    USER_ID    VARCHAR2(20)
        constraint "ticket_USERS_USER_ID_fk"
        references USERS,
    SEATNUM    CHAR(2),
    MUSICAL_ID NUMBER,
    ISSUE      DATE,
    constraint "ticket_SEAT_SEATNUM_MUSICAL_ID_fk"
        foreign key (MUSICAL_ID, SEATNUM) references SEAT
)

-- TICKET_ID_SEQ SEQUENCE
CREATE SEQUENCE TICKET_ID_SEQ NOCACHE;
-- DROP SEQUENCE TICKET_ID_SEQ;

-- TICKET DATA ADD
INSERT INTO TICKET VALUES (TICKET_ID_SEQ.nextval, 'park', 'D2', 1, TO_DATE('20230402150000','YYYY-MM-DD HH24:MI:SS'));  -- 과거 구매
INSERT INTO TICKET VALUES (TICKET_ID_SEQ.nextval, 'park', 'A3', 9, TO_DATE('20230401180000','YYYY-MM-DD HH24:MI:SS'));  -- 과거 구매 - 아직 공연 시작 안함
INSERT INTO TICKET VALUES (TICKET_ID_SEQ.nextval, 'park', 'C3', 15, TO_DATE('20230405120000','YYYY-MM-DD HH24:MI:SS'));  -- 과거 구매 - 아직 공연 시작 안함
INSERT INTO TICKET VALUES (TICKET_ID_SEQ.nextval, 'lee', 'E5', 14, TO_DATE('20230405110000','YYYY-MM-DD HH24:MI:SS'));  -- 아직 보지 않은 공연
INSERT INTO TICKET VALUES (TICKET_ID_SEQ.nextval, 'lee', 'C3', 15, TO_DATE('20230403190000','YYYY-MM-DD HH24:MI:SS'));  -- 아직 보지 않은 공연
INSERT INTO TICKET VALUES (TICKET_ID_SEQ.nextval, 'lee', 'B3', 15, sysdate);  -- 아직 보지 않은 공연

-- INSERT TICKET에 따른 SEAT 값 변경
UPDATE SEAT SET SOLD = 'Y' WHERE MUSICAL_ID = 1 AND SEATNUM = 'D2';
UPDATE SEAT SET SOLD = 'Y' WHERE MUSICAL_ID = 9 AND SEATNUM = 'A3';
UPDATE SEAT SET SOLD = 'Y' WHERE MUSICAL_ID = 15 AND SEATNUM = 'C3';
UPDATE SEAT SET SOLD = 'Y' WHERE MUSICAL_ID = 14 AND SEATNUM = 'E5';
UPDATE SEAT SET SOLD = 'Y' WHERE MUSICAL_ID = 15 AND SEATNUM = 'C3';
UPDATE SEAT SET SOLD = 'Y' WHERE MUSICAL_ID = 15 AND SEATNUM = 'B3';


SELECT * FROM TICKET;

