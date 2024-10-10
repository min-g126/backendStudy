package com.ohgiraffers.section01.autowired.sub02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    private BookDAO bookDAO;

//    public BookService() {}

    /*
    * 생성자가 1개인 경우에는 @Autowired 어노테이션을 생략해도 자동으로 생성자 주입이 동작한다.
    * 단, 생성자가 2개 이상일 경우에는 명시적으로 @Autowired 어노테이션을 작성해 주어야 한다.
    * */

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }

    /*
    * [ 생성자 주입의 '장점' ]
    * - 객체가 생성될 때 모든 의존성이 주입되므로 의존성을 보장할 수 있다.
    *   ㄴ '순환 참조'에 대해 필드 주입/setter 주입은 메소드 실행 시점에 오류가 발생한다.
    *   ㄴ 생성자 주입은 애플리케이션 실행 시점에 오류가 발생한다.
    * - 객체의 불변성을 보장할 수 있다.
    *   ㄴ 필드에 'final' 키워드 사용이 가능하고, 객체 생성 이후 의존성을 변경할 수 없어 안정성이 보장된다.
    * - 코드 가독성이 좋다.
    *   ㄴ 해당 객체가 어떤 의존성을 가지고 있는지 명확히 알 수 있다.
    * */
}
