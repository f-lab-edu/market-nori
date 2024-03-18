# market-nori
**market-nori**는 마켓컬리, B마트와 같은 식품 판매를 전문으로 하는 온라인 쇼핑몰 플랫폼 API 서버 프로젝트입니다.

# 프로젝트 목적


# 사용 기술
- Spring Boot 3.2.2
- Java 17
- Junit 4
- MySQL 8.2.0
- JPA
- gradle

# Git-flow 전략
✅ master : 제품으로 출시될 수 있는 브랜치  
✅ develop : 개발 완료된 feature 브랜치를 Merge하여 다음 출시 버전을 개발하는 브랜치  
✅ feature : 기능을 개발하는 브랜치  
✅ release : 이번 출시 버전을 준비하는 브랜치  
✅ hotfix : 출시한 버전에서 발생한 버그를 수정하는 브랜치  
> 참고: 우아한 형제들 기술블로그 "우린 Git-flow를 사용하고 있어요" [(click👆)](https://techblog.woowahan.com/2553/)

# ERD
<p align="center">
  <img src="https://github.com/f-lab-edu/market-nori/assets/63999547/b3d2d498-098e-4451-be43-593509f545ee">
</p>

# API 리스트
### 회원
|항목|Method|URI|
|---|------|---|
|회원가입|POST|/v1/users/join|
|로그인|POST|/v1/login|
|회원정보 조회|GET|/v1/users/me|
|회원정보 변경|PATCH|/v1/users/me|
|회원탈퇴|DELETE|/v1/users/me|

### 상품
|항목|Method|URI|
|---|------|---|
|상품 리스트 조회|GET|/v1/products|
|로그인|POST|/v1/products?name=상품명|

### 장바구니
|항목|Method|URI|
|---|------|---|
|장바구니 담기|POST|/v1/me/carts/products/{productsId}|
|장바구니 조회|GET|/v1/me/carts|
|장바구니 삭제|DELETE|/v1/me/carts/products/{productsId}|

### 주문
|항목|Method|URI|
|---|------|---|
|주문하기|POST|/v1/orders|
|주문내역 조회|GET|/v1/me/orders|
|주문취소|PATCH|/v1/me/orders/{orderId}|


# 주요 기능 시퀀스 다이어그램

