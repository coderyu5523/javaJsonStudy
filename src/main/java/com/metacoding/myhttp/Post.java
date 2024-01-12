package com.metacoding.myhttp;

import lombok.*;

@NoArgsConstructor // 디폴트생성자
@AllArgsConstructor // 모든 변수를 다 받는 생성자.
@Getter
@Setter
@Data  // 게터 세터 동시에 만듬.
public class Post {
    int userId;
    int id;
    String title;
    String body;

}
