/*
목적 : 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기
아웃풋 :자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE)
조건
1.자동차 종류가 '세단' 또는 'SUV' 인 자동차
2.2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
3.대여 금액이 50만원 이상 200만원 미만인 자동차
4.대여 금액을 기준으로 내림차순 정렬
5.대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬
6.자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬

프로세스
1. CAR_RENTAL_COMPANY_CAR,CAR_RENTAL_COMPANY_RENTAL_HISTORY 를 먼저 JOIN하면서
,DURATION_TYPE 타입을 정의
2. CAR_RENTAL_COMPANY_DISCOUNT_PLAN와 2차 조인을 할 때, CAR_TYPE과  DURATION_TYPE가 unique_key
3. 그 다음의 조건들을 추가하면 끝
*/
WITH base AS (

SELECT
    t1.car_id
    ,car_type
    ,DAILY_FEE*30 AS before_discount
    ,'30일 이상' AS DURATION_TYPE
    ,MAX(CASE 
        WHEN end_date < '2022-11-01'THEN '대여 가능'
        ELSE '대여중' END) rent_flg


FROM CAR_RENTAL_COMPANY_CAR AS t1
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS t2
ON t1.car_id = t2.car_id
WHERE t1.car_type IN ('세단','SUV')
GROUP BY 1,2,3,4
ORDER BY car_id

)

SELECT 
t1.car_id
,t1.car_type
,ROUND(before_discount*(100-DISCOUNT_RATE)*0.01,0) AS FEE
FROM base AS t1
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS t2
ON t1.car_type =t2.car_type AND t1.DURATION_TYPE = t2.DURATION_TYPE AND rent_flg ='대여 가능'
WHERE before_discount*(100-DISCOUNT_RATE)*0.01 >=500000 AND before_discount*(100-DISCOUNT_RATE)*0.01 < 2000000
ORDER BY 3 DESC,1,2 DESC