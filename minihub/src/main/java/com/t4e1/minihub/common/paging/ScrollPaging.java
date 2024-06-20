package com.t4e1.minihub.common.paging;

import lombok.Getter;

@Getter
public class ScrollPaging {

    /* Pageable 라이브러리를 사용해도 되지만 간단한 스크롤 형식의 페이징 처리를 할 예정이라
    *  그냥 하나 만들어보기. 전체 개수를 보여줄 필요 없다.
    *  필요한 정보? 1. 몇 개씩 검색할건지, 2. 현재 페이지 정보, 3. 마지막 페이지 정보(?) - 아직 확실하지 않음
   * */

    /* (offset * (현재 페이지 + 1)) - (offset * 현재 페이지) 이렇게 조회 해야한다.
     *  1회차 조회 인덱스: (10*1) - (10*0)
     *  2회차 조회 인덱스: (10*2) - (10*1)
     *
     *  어떻게 10개를 뽑아올것인지? id는 기준이 될 수없다 ( 삭제를 하드 딜리트로 처리할 것이기 때문 )
     *  Limit 과 Offset으로 한다.
     *    SELECT *
     *    FROM history H
     *    LIMIT {searchNum}, OFFSET {offset}
     * searchNum 만큼의 행을 offset부터 가져온다. (offset은 0부터 시작한다. offset=3이면 4~13을 반환한다는 뜻)
     * */

    private int getNum;  // 몇개씩 조회할건지 -> 디폴트 10
    private int currentPage; // 현재 페이지 정보 -> 디폴트 0 (DB에서 조회할때 1~10까지가 첫번째 조회일 거니까)
    private int offset; // 어디서부터 조회를 시작할건지
    private int totalNum;

    public ScrollPaging(int getNum, int currentPage) {
        this.getNum = getNum;
        this.currentPage = currentPage - 1; // 1페이지라면 인덱스 0~9까지를 조회해화야하니 -1 시켜준다.
        this.offset = getNum * currentPage; // 현재 페이지 * getNum 이후부터 조회를 시작한다.
    }

    
}
