package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class EmbeddedIdLikeCompositeKeyTests {

    @Autowired
    private LikeBookService likeBookService;

    /*
    * [ 복합키가 존재하는 테이블 매핑 ]
    * 1. @EmbeddedId : @Embeddable 클래스에 복합키를 정의하고 엔티티에 @EmbeddedId를 이용해 복합키 클래스를 매핑한다.
    *                  복합키의 일부 필드만을 매핑할 수도 있으므로, 필드 수가 많은 경우 유연한 매핑이 가능하다는 장점이 있다.
    * 2. @IdClass : 복합키를 필드로 정의한 클래스를 이용해 엔티티 클래스에 @IdClass를 매핑한다.
    *               복합키를 구성하는 모든 필드를 한번에 매핑할 수 있으며, 코드가 간결하다는 장점이 있다.
    *
    * 두 방식 모두 복합키 클래스는 영속성 컨텍스트가 관리하지 않는다는 특징이 있으며, 큰 기능적 차이도 존재하지 않는다.
    * 다만 @EmbeddedId이 조금 더 객체 지향다운 방법이고, @IdClass는 관계형 데이터베이스에 가까운 방법이다.
    * */

    private static Stream<Arguments> getLikeInfo() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 2)
        );
    }

    @ParameterizedTest(name = "{0}번 회원이 {1}번 책을 좋아요 등록 테스트")
    @MethodSource("getLikeInfo")
    void testGenerateLike(int likedMemberNo, int likedBookNo) {
        //given
        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> likeBookService.generateLikeBook(
                        new LikeDTO(likedMemberNo, likedBookNo)
                )
        );
    }
}
