-- 여기는 food 접속

CREATE TABLE tbl_foods(
    f_code	        CHAR(7)		    PRIMARY KEY,
    f_name	        nVARCHAR2(125)	NOT NULL,	
    f_date	        CHAR(4)     	NOT NULL,	
    f_ccode	        CHAR(6)	        NOT NULL,	
    f_tcode	        CHAR(4)	        NOT NULL,	
    f_aps	        NUMBER	        NOT NULL,	
    f_spc	        NUMBER	        NOT NULL,	
    f_calories	    NUMBER	        NOT NULL,	
    f_protein	    NUMBER,		
    f_fat	        NUMBER,		
    f_carbohydrate	NUMBER,		
    f_sugars	    NUMBER		
);


CREATE TABLE tbl_company(
    c_code	CHAR(6)		    PRIMARY KEY,
    c_name	nVARCHAR2(125)	NOT NULL	
);

CREATE TABLE tbl_items(
    t_code	CHAR(4)		    PRIMARY KEY,
    t_name	nVARCHAR2(30)	NOT NULL	
);

SELECT COUNT(*) FROM tbl_foods;
SELECT COUNT(*) FROM tbl_company;
SELECT COUNT(*) FROM tbl_items;

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company
FOREIGN KEY(f_ccode)
REFERENCES tbl_company(c_code);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY(f_tcode)
REFERENCES tbl_items(t_code);

CREATE VIEW view_식품정보 AS
(
    SELECT F.f_code AS 식품코드,
           F.f_name AS 식품명,
           F.f_date AS 출시연도,
           C.c_name AS 제조사명,
           T.t_name AS 분류명,
           F.f_aps AS "1회제공량",
           F.f_spc AS "총내용량(g)",
           F.f_calories AS "에너지(kcal)",
           F.f_protein AS "단백질(g)",
           F.f_fat AS "지방(g)",
           F.f_carbohydrate AS "탄수화물(g)",
           F.f_sugars AS "총당류(g)"
    FROM tbl_foods F
        LEFT JOIN tbl_company C 
            ON F.f_ccode = C.c_code
        LEFT JOIN tbl_items T
            ON F.f_tcode = T.t_code
);

CREATE TABLE tbl_myfoods(
    mf_seq	    NUMBER		PRIMARY KEY,
    mf_date	    CHAR(10)	NOT NULL,	
    mf_pcode	CHAR(7)	    NOT NULL,	
    mf_intake	NUMBER	    NOT NULL	
);

DELETE FROM tbl_myfoods
WHERE mf_date = '50';

ALTER TABLE tbl_myfoods
ADD CONSTRAINT fk_foods
FOREIGN KEY(mf_pcode)
REFERENCES tbl_foods(f_code);


CREATE SEQUENCE seq_myfoods
START WITH 1
INCREMENT BY 1;

INSERT INTO tbl_myfoods
VALUES(seq_myfoods.NEXTVAL,'2021-05-19','PD00001',3);

DROP VIEW view_식품섭취정보;

CREATE VIEW view_식품섭취정보 AS
(
    SELECT M.mf_seq AS SEQ,
           M.mf_date AS 날짜,
           F.f_name AS 식품명,
           M.mf_intake AS 섭취량,
           M.mf_intake * F.f_spc AS 총내용량,
           M.mf_intake * F.f_calories AS "에너지(kcal)",
           M.mf_intake * F.f_protein AS "단백질(g)",
           M.mf_intake * F.f_fat AS "지방(g)",
           M.mf_intake * F.f_carbohydrate AS "탄수화물(g)",
           M.mf_intake * F.f_sugars AS "총당류(g)"
    FROM tbl_myfoods M
        LEFT JOIN tbl_foods F
            ON M.mf_pcode = F.f_code
);            


