# market-nori
**market-nori**는 마켓컬리와 B마트 등과 같은 식품 판매를 전문으로 하는 온라인 쇼핑몰 플랫폼 API 서버 프로젝트입니다.

# 프로젝트 목적
- 사용자가 많은 상황에서도 대용량 트래픽을 효과적으로 관리하며 우수한 서비스 제공을 목표로 합니다.
- 사용자 경험을 최우선으로 하여, 직관적이고 사용하기 쉬운 API 디자인에 중점을 둡니다.
- 기술 선택 시 발생하는 트레이드 오프를 신중히 고려하여 최적의 솔루션을 선택합니다.
- 데이터의 정확성과 일관성을 보장하기 위해 트랜잭션 관리를 강화합니다.
- 안정적인 서비스 제공을 위해 테스트 코드 작성을 일상화합니다.
- 지속 가능한 개발을 위해 코드의 가독성과 유지보수성을 높이는 코딩 표준과 베스트 프랙티스를 적용합니다.

---

# 사용 기술
- Spring Boot 3.2.2
- Java 17
- Junit 4
- MySQL 8.2.0
- JPA
- gradle

### Git-flow 전략
✅ master : 제품으로 출시될 수 있는 브랜치  
✅ develop : 개발 완료된 feature 브랜치를 Merge하여 다음 출시 버전을 개발하는 브랜치  
✅ feature : 기능을 개발하는 브랜치  
✅ release : 이번 출시 버전을 준비하는 브랜치  
✅ hotfix : 출시한 버전에서 발생한 버그를 수정하는 브랜치  
> 참고: 우아한 형제들 기술블로그 "우린 Git-flow를 사용하고 있어요" [(click👆)](https://techblog.woowahan.com/2553/)

---

# ERD
<p align="center">
  <img src="https://github.com/f-lab-edu/market-nori/assets/63999547/b3d2d498-098e-4451-be43-593509f545ee">
</p>

---

# API 리스트
### 회원
|항목|Method|URI|
|---|------|---|
|회원가입|POST|[/v1/users/join](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=745982262)|
|로그인|POST|[/v1/login](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=12403764)|
|회원정보 조회|GET|[/v1/users/me](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=1725120388)|
|회원정보 변경|PATCH|[/v1/users/me](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=1143057640)|
|회원탈퇴|DELETE|[/v1/users/me](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=2142537548)|

### 상품
|항목|Method|URI|
|---|------|---|
|상품 리스트 조회|GET|[/v1/products](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=846007630)|
|로그인|POST|[/v1/products?name=상품명](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=146285256)|

### 장바구니
|항목|Method|URI|
|---|------|---|
|장바구니 담기|POST|[/v1/me/carts/products/{productsId}](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=296307125)|
|장바구니 조회|GET|[/v1/me/carts](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=221536156)|
|장바구니 삭제|DELETE|[/v1/me/carts/products/{productsId}](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=368351774)|

### 주문
|항목|Method|URI|
|---|------|---|
|주문하기|POST|[/v1/orders](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=427442161)|
|주문내역 조회|GET|[/v1/me/orders](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=1090431711)|
|주문취소|PATCH|[/v1/me/orders/{orderId}](https://docs.google.com/spreadsheets/d/1TijrwkxC5u_0ovg4zcTg_7nvaB9PWPK0r3xv9kOOsbM/edit#gid=918172445)|

---

# 이슈 해결 사례
[#1] 상품 목록 조회 시 순환 참조 발생 현상 개선

