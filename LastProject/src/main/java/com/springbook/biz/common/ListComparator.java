package com.springbook.biz.common;

import java.util.Comparator;

import com.springbook.biz.board.BookVO;

public class ListComparator implements Comparator {
	@Override
    public int compare(Object o1, Object o2) {
        String code1 = ((BookVO)o1).getCode();
        String code2 = ((BookVO)o2).getCode();
        return code1.compareTo(code2);
    }
}
