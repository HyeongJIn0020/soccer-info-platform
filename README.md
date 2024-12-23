# ⚽ 축구 정보 플랫폼

__[✅ GOALTONG 바로가기](https://goaltong.store)__

---
## 📑 목차
[1. 프로젝트 개요](#-프로젝트-개요)
+ [주제 및 동기](#-주제-및-동기)
+ [팀 구성 및 개발 환경](#-팀-구성-및-개발-환경)

[2. 주요 기능](#-주요-기능)
+ [회원가입 및 로그인](회원가입-및-로그인)
+ [API를 활용한 축구 데이터 제공](API를-활용한-축구-데이터-제공)
+ [커뮤니티 게시판](#-커뮤니티-게시판)
+ [관리자 페이지](#-관리자-페이지)

[3. 프로젝트 후기](#-프로젝트-후기)


---
## 📌 프로젝트 개요

### 📅 기간

2024.10.16 ~ 2024.11.20 (약 6주)

<img src="https://github.com/user-attachments/assets/11111af0-9935-46ca-98f5-c5263467942e" width="700">

### 🔍 주제 및 동기

__[주제] :__ 축구 팬들을 위한 종합 웹 플랫폼

__[동기] :__
+ 축구 팬들의 연결과 소통을 위한 플랫폼
+ 많은 사람들에게 축구를 알리고 관심을 높이기 위함
+ 다양한 정보를 제공함으로써 축구 경기의 이해도 향상

---

### 👥 팀 구성 및 개발 환경

__[팀원] :__
|[🙍‍♂️ 이형진](https://github.com/HyeongJIn0020) (팀장)|[🙍‍♂️ 장창연](https://github.com/jchangy)|🙍‍♂️ 권우진|🙍‍♂️ 윤현규|
|---|---|---|---|
|Backend/Frontend|Backend/Frontend|Backend/Frontend|Backend/Frontend|

__개발 환경__

__[ DB ]__

![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

__[ Backend ]__

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=MyBatis&logoColor=white"> 
![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

__[ Frontend ]__

![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)

__[ CI / CD ]__

![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Jenkins](https://img.shields.io/badge/jenkins-%232C5263.svg?style=for-the-badge&logo=jenkins&logoColor=white)

---

## 🔥 주요 기능

#### 🔑 회원가입 및 로그인

<img src="https://github.com/user-attachments/assets/b3ec56cc-f9dc-4185-b3d4-496f67b14041" width="280" height="450">
<img src="https://github.com/user-attachments/assets/16c75a21-3142-4ebc-8e6c-2f93a29ffe5b" width="280" height="450">

__[1] 회원가입__

아이디, 비밀번호, 닉네임 등 필수사항 입력  
 -> 이메일 중복 확인 후 인증번호 전송  
 -> 인증번호 확인이 되면 정상적으로 회원가입 가능

 <img src="https://github.com/user-attachments/assets/23d55a84-8059-4bc3-8dbc-7d5673170d1e" width="400"> __▶__
 <img src="https://github.com/user-attachments/assets/bdfa1a64-56f2-4d9c-ab65-6aa8c7fe9c6a"> __▶__
 <img src="https://github.com/user-attachments/assets/b9a6f3cb-01ad-4b1e-b458-4d1a76d05147"><br>  

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">

```
@PostMapping("/sendVerificationEmailForSignUp")
   public ResponseEntity<?> sendVerificationEmailForSignUp(@RequestBody Map<String, String> request) {
       String email = request.get("email"); // 요청 본문에서 email 가져오기

       // 이메일이 null인지 확인
       if (email == null || email.isEmpty()) {
           return ResponseEntity.badRequest().body("이메일이 필요합니다.");
       }

       // 인증번호 전송
       String storedVerificationCode = emailService.sendVerificationEmail(email);
       HttpSessionUtil.getSession().setAttribute("checkCode", storedVerificationCode);
       log.info("전송된 인증번호: {}", storedVerificationCode);
       
       if (storedVerificationCode == null) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이메일 전송에 실패했습니다.");
       }
       
       return ResponseEntity.ok(Map.of("message", "인증번호가 전송되었습니다."));
   }
```

</div>
</details> 
  
__[2] 로그인__  

+ 아이디, 비밀번호를 입력하는 로그인  
+ 네이버, 카카오 소셜 로그인 
+ 이메일 인증을 통한 아이디 찾기, 비밀번호 찾기

<img src="https://github.com/user-attachments/assets/3271f39e-b057-4047-a765-9a19f6f824c4" width="300">
<img src="https://github.com/user-attachments/assets/4a60d648-7df1-4650-8830-ea4caa56aca9" width="300"><br>

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">

```
    @GetMapping("/login/kakao")
    public String kakaoLogin() {
        String kakaoLoginUrl = "https://kauth.kakao.com/oauth/authorize"
                + "?client_id=" + appKey
                + "&redirect_uri=" + redirectUri
                + "&response_type=code"
                + "&prompt=login";  
        return "redirect:" + kakaoLoginUrl;
    }

    @GetMapping("/login/kakao/callback")
    public String kakaoCallback(@RequestParam(value = "code", required = false) String code) {
        if (code == null) {
            return "redirect:/";
        }

        try {
            String accessToken = getAccessToken(code);
            String userInfoResponse = getKakaoUserInfo(accessToken);
            
            String userId = extractUserId(userInfoResponse);
            String nickname = extractUserNickname(userInfoResponse);

            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setUiId("KAKAO_" + userId);
            userInfoVO.setUiPwd("KAKAO_USER");
            userInfoVO.setUiName(nickname);
            userInfoVO.setUiNickName(nickname);
            userInfoVO.setKakaoUser(true);
            userInfoVO.setEmailVerified(true);

            UserInfoVO savedUser = kakaoLoginService.insertKakaoUser(userInfoVO);
            
            HttpSession session = request.getSession();
            session.setAttribute("user", savedUser);
            
            return "redirect:/";
            
        } catch (Exception e) {
            log.error("Kakao login error", e);
            return "redirect:/";
        }
    }
```

</div>
</details> 

---

#### 📊 API를 활용한 축구 데이터 제공
외부 API를 활용하여 축구 데이터를 조회할 수 있습니다. <br>

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">

```
public String getNextMatch() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Auth-Token", "a61b8c6337d1474fac182286f7f3af8b");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            String response = restTemplate.exchange(
                "http://api.football-data.org/v4/competitions/PL/matches",
                HttpMethod.GET,
                entity,
                String.class
            ).getBody();

            JSONObject jsonObject = new JSONObject(response);
            JSONArray matchesArray = jsonObject.getJSONArray("matches");

            SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date now = new Date();
            Date nextMatchDate = null;
            String homeTeam = "";
            String awayTeam = "";

            for (int i = 0; i < matchesArray.length(); i++) {
                JSONObject match = matchesArray.getJSONObject(i);
                Date matchDate = utcFormat.parse(match.getString("utcDate"));

                if (matchDate.after(now)) {
                    if (nextMatchDate == null || matchDate.before(nextMatchDate)) {
                        nextMatchDate = matchDate;
                        homeTeam = match.getJSONObject("homeTeam").getString("name");
                        awayTeam = match.getJSONObject("awayTeam").getString("name");
                    }
                }
            }

            if (nextMatchDate != null) {
                long timeDiff = nextMatchDate.getTime() - now.getTime();
                long secondsRemaining = timeDiff / 1000;

                long days = secondsRemaining / (24 * 3600);
                secondsRemaining %= (24 * 3600);
                long hours = secondsRemaining / 3600;
                secondsRemaining %= 3600;
                long minutes = secondsRemaining / 60;
                long seconds = secondsRemaining % 60;

                return String.format("%s vs %s, 시작까지 남은 시간: %02d일 %02d시 %02d분", 
                                     homeTeam, awayTeam, days, hours, minutes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // 다음 경기가 없을 경우 null 반환
    }
```

</div>
</details> 

__[1] 프리미어 리그표, 다음 경기 및 최근 경기 정보__

<img src="https://github.com/user-attachments/assets/6d46fff0-559c-4315-aad6-1b36b61aef09" width="600"><br>

__[2] 월별 경기 일정__

<img src="https://github.com/user-attachments/assets/01ea4f72-a8dd-442b-8a98-094a786929ab" width="600"><br>

__[3] 경기 소식(뉴스, 하이라이트 영상)__

<img src="https://github.com/user-attachments/assets/c8459a65-f581-4f6b-b13c-487cd3f994aa" width="500">
<img src="https://github.com/user-attachments/assets/56776ce2-ad5f-4a5b-9274-5c0a7a4ccb31" width="500"><br>

---

#### 📱 커뮤니티 게시판

__[1] 게시글 조회__

<img src="https://github.com/user-attachments/assets/daccc0b4-6d20-45d7-a92c-b4fdcf5eefe9" width="500">

+ 제목, 닉네임, 내용 3가지 조건에 따라 게시글 검색이 가능
<details>
<summary>주요 코드 보기</summary>
<div markdown="1">

```
// 게시글 목록 조회
    public ResultList<PostInfoVO> selectPosts(PostInfoVO post) {
        if (post.getCount() == 0) {
            post.setCount(DEFAULT_COUNT);
        }
        if (post.getPage() != 0) {
            int start = (post.getPage() - 1) * post.getCount();
            post.setStart(start);
        }
        ResultList<PostInfoVO> rl = new ResultList<>();
        List<PostInfoVO> posts = postInfoMapper.selectPosts(post);
        rl.setList(posts);
        int totalCnt = postInfoMapper.selectPostsTotal(post);
        rl.setCount(totalCnt);

        int postNumber = totalCnt - post.getStart();
        for (PostInfoVO postInfo : posts) {
            postInfo.setPostNum(postNumber--);
            PostInfoVO latestPostInfo = postInfoMapper.selectPost(postInfo.getPiNum());
            postInfo.setPiViews(latestPostInfo.getPiViews());  // 최신 조회수 반영
        }

        return rl;
    }
```

</div>
</details> 

<img src="https://github.com/user-attachments/assets/d6b68e94-549a-444f-b2e7-0e1dc5c86321" width="500">  <br>  
<details>
<summary>주요 코드 보기</summary>
<div markdown="1">

```
// 게시글 상세보기
    public PostInfoVO selectPost(int piNum, HttpServletRequest request, HttpServletResponse response) {
        // DB에서 게시글 조회
        PostInfoVO postInfo = postInfoMapper.selectPost(piNum);

        // 쿠키에서 조회수를 가져오고, 첫 방문일 경우 조회수 증가
        int viewCount = getViewCountFromCookie(request, piNum);

        if (viewCount == 0) {  // 첫 방문일 때만 조회수 증가
            // DB에서 조회수 증가
            int newViewCount = postInfo.getPiViews() + 1;  // 기존 조회수에 1을 더함
            postInfoMapper.updateViewCount(piNum, newViewCount);  // DB에 반영

            // 쿠키에 조회수 저장
            viewCount = incrementViewCount(viewCount);  // 조회수 증가
            saveViewCountToCookie(response, piNum, viewCount);  // 쿠키에 저장

            // 게시글 정보에 최신 조회수 반영 (디스플레이용)
            postInfo.setPiViews(newViewCount);  
        } else {
            // 첫 방문이 아닐 경우 DB에서 최신 조회수를 가져옴
            postInfo = postInfoMapper.selectPost(piNum);
        }

        return postInfo;
    }
```

</div>
</details> 


__[2] 게시글 작성 및 수정__

Summernote 에디터를 활용하여 사용자는 글을 작성하거나 수정을 할 수 있습니다.

<img src="https://github.com/user-attachments/assets/f65b5389-e752-4ce0-a0b4-0e845f9cff8a" width="500">
<img src="https://github.com/user-attachments/assets/f7031887-4984-4073-b759-bf84cb9f53f0" width="500">  <br>  

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">
  
```
// 게시글 및 이미지 등록
    public int insertPostWithImages(PostInfoVO post, List<String> imageUrls) {
        int insertResult = postInfoMapper.insertPost(post);
        int generatedPiNum = post.getPiNum();

        if (insertResult > 0 && imageUrls != null && !imageUrls.isEmpty()) {
            List<ImageInfoVO> images = new ArrayList<>();
            for (String imgUrl : imageUrls) {
                ImageInfoVO image = new ImageInfoVO();
                image.setImgUrl(imgUrl);
                image.setPiNum(generatedPiNum);
                images.add(image);
            }
            imageInfoService.insertImages(images);
        }

        return insertResult > 0 ? generatedPiNum : -1;
    }

//게시글 등록
function insertPost() {
        var title = $('\#postTitle').val();
        var content = $('\#summernote').summernote('code');

        if (!title) {
            alert('제목을 입력해주세요.');
            return;
        }

        var formData = new FormData();
        formData.append('piTitle', title);
        formData.append('piContent', content);

        imageUrls.forEach(function(url) {
            formData.append('imageUrls', url);
        });

        fetch('/posts', {
            method: 'POST',
            body: formData
        })
        .then(function(response) {
            if (!response.ok) throw new Error('Post submission failed');
            return response.json();
        })
        .then(function(piNum) {
            if (piNum > 0) {
                alert('게시글이 등록되었습니다!');
                window.location.href = "/views/community/post-list";
            } else {
                alert('게시글 등록 실패');
            }
        })
        .catch(function(error) {
            alert('게시글 등록 중 오류가 발생했습니다.');
        });
    }
```

</div>
</details>




__[3] 추천 및 신고__

+ 추천
<img src="https://github.com/user-attachments/assets/1c53c7e0-2a4a-474e-8493-4a79a4432dfa">
<img src="https://github.com/user-attachments/assets/6f65ebfe-fa5f-491b-ae3b-b88865172a1d"><br>

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">
  
```
public Map<String, Object> insertLike(int piNum, int uiNum) {
        Map<String, Object> result = new HashMap<>();
        
        int count = countLikeByUser(piNum, uiNum);
        if(count > 0) {
            likeInfoMapper.deleteLike(piNum, uiNum);
            result.put("liked", false);
        } else {
            likeInfoMapper.insertLike(piNum, uiNum);
            result.put("liked", true);
        }
        result.put("count", countLikeByPost(piNum));
        return result;
    }
```

</div>
</details>

+ 신고

<img src="https://github.com/user-attachments/assets/9b47ffe4-6ce9-4b06-b439-7733c1ad9039"><br>

신고 사유 입력 후 신고하기 버튼을 누르면 관리자가 검토 후 적절한 조치를 취합니다.  
게시글의 경우 목록에서 안 보이고, <br> 

<img src="https://github.com/user-attachments/assets/23f2f991-c726-4cfc-8b70-60c82c7294bd"><br>
댓글은 __삭제된 댓글입니다.__ 라는 표시와 함께 사용자의 인터페이스가 변경됩니다.

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">
  
```
@PostMapping("/reports")
	public int addReport(@RequestBody ReportVO report) {
		if (report.getReportedType() == null) {
        log.error("ReportedType is null!");
    } else {
        log.info("ReportedType: {}", report.getReportedType());
    }
		return reportInfoService.insertReport(report);
}

// 상태가 BLOCKED인 댓글 처리: "삭제된 댓글입니다."로 내용 변경
  for (CommentInfoVO commentVO : comments) {
    if ("BLOCKED".equals(commentVO.getStatus())) {
      commentVO.setCmiContent("삭제된 댓글입니다.");
    }
  }
```

</div>
</details>

---

#### 📢 관리자 페이지

__[1]__ 가입자 수 파악

chart.js를 활용하여 최근 가입한 사용자 수를 파악할 수 있습니다.

<img src="https://github.com/user-attachments/assets/3595b50a-3d1a-4e1d-991e-66a42e3ff09e">

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">
  
```
@GetMapping("/signup-count")
   public List<UserInfoVO> getSignupStats() {
       List<UserInfoVO> stats = uiService.getRecentSignupCounts();
       log.info("Result: {}", stats);
       return stats;
   }

// 데이터 로드 및 Chart.js 생성
    fetch('/signup-count')
        .then(response => response.json())
        .then(data => {
        	const allLabels = ['2024-10', '2024-11', '2024-12']; // 표시할 달
            const signupCounts = allLabels.map(label => {
                // 데이터에서 일치하는 달 찾기
                const match = data.find(item => item.month === label);
                return match ? match.signupCount : 0; // 데이터가 없으면 0으로 설정
            });

            // Chart.js 생성
            signupChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: allLabels, // X축 데이터
                    datasets: [{
                        label: '최근 가입한 유저수',
                        data: signupCounts, // Y축 데이터
                        backgroundColor: 'rgba(75, 192, 192, 0.2)', // 막대 배경색
                        borderColor: 'rgba(75, 192, 192, 1)', // 막대 테두리색
                        borderWidth: 1 // 막대 테두리 두께
                    }]
                },
                options: {
                    responsive: true, // 반응형 설정
                    scales: {
                    	x: {
                            barPercentage: 0.5,       // 막대 너비 조정 (기본값: 0.9)
                            categoryPercentage: 0.1, // 카테고리 내 막대 공간 비율 (기본값: 0.8)
                        },
                        y: {
                        	beginAtZero: true, // Y축 0부터 시작
                        	min: 0,            
                            max: 50, 
                            ticks: {
                                stepSize: 5    // Y축 간격을 5로 설정
                            }
                        }
                    }
                }
            });
        })
```

</div>
</details>

__[2]__ 신고 내역

신고가 들어온 내역을 확인하여 검토 후 조치를 취할 수 있으며, 게시글 내용을 누르면 게시글 페이지로 이동한다. 

<img src="https://github.com/user-attachments/assets/2fb5ec3a-68b6-4b13-b47b-1abc995f7c45">

<details>
<summary>주요 코드 보기</summary>
<div markdown="1">
  
```
// 신고 상태 업데이트
    public int updateReportStatus(ReportVO report) {
    	return reportInfoMapper.updateReportStatus(report);
    }

@PutMapping("/reports")
	public int modifyReport(@RequestBody ReportVO report) {
		return reportInfoService.updateReportStatus(report);
	}

```

</div>
</details>


---
## 🎓 프로젝트 후기
1. 코드 컨벤션 및 보안 관리  
  + 프로젝트 기획 단계에서 코드 컨벤션을 미리 정하지 않아 민감한 정보가 코드에 하드 코딩되는 문제가 발생했습니다.
  + 이 경험을 통해 보안과 코드 품질을 위한 규칙 설정의 중요성을 깨달았습니다.
2. 팀 프로젝트 경험과 협업의 중요성
  + 팀 프로젝트를 진행하며 협업의 중요성을 깨달을 수 있었습니다. 소통과 역할 분담이 얼마나 중요한지 알게되는 계기가 되었습니다.
  + 프로젝트 전에는 무엇을 만들어야 할지 고민이 많았지만, 직접 구현해보면서 더 많은 프로젝트를 직접 만들어보고 싶다는 열정이 생겼습니다.
