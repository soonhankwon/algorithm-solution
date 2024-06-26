SELECT P.PT_NAME, P.PT_NO, P.GEND_CD, P.AGE, 
COALESCE(P.TLNO, 'NONE') AS TLNO
FROM PATIENT AS P
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY P.AGE DESC, P.PT_NAME ASC;