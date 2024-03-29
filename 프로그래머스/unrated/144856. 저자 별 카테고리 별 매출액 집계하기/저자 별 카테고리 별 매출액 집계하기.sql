-- 코드를 입력하세요
SELECT C.AUTHOR_ID, AU.AUTHOR_NAME, C.CATEGORY, SUM(TOTAL) as TOTAL_SALES
FROM(
SELECT B.BOOK_ID, B.CATEGORY, B.AUTHOR_ID, A.SALESSUM * B.PRICE as TOTAL
FROM BOOK as B JOIN  
(SELECT BOOK_ID, SUM(sales) as SALESSUM
FROM BOOK_SALES
WHERE sales_date like '2022-01%'
GROUP BY BOOK_ID) as A 
ON B.BOOK_ID = A.BOOK_ID) as C JOIN AUTHOR as AU
ON C.AUTHOR_ID = AU.AUTHOR_ID
GROUP BY AU.AUTHOR_NAME, C.CATEGORY
ORDER BY 1, 3 DESC



