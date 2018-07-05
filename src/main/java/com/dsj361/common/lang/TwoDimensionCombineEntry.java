/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.dsj361.common.lang;

import com.dsj361.common.lang.ToStringObject;

import java.util.List;

/**
 * 二维组合实体
 *
 * @author chenbug
 *
 * @version $Id: TwoDimensionCombineEntry.java, v 0.1 2011-6-13 下午06:37:59
 *          chenbug Exp $
 */
public class TwoDimensionCombineEntry<T, E> extends ToStringObject {

    /**
     * 1维拖
     */
    private List<T> firstList;

    /**
     * 1维胆
     */
    private List<T> firstDanList;

    /**
     * 2维拖
     */
    private List<E> secondList;

    /**
     * 2维胆
     */
    private List<E> secondDanList;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public List<T> getFirstList() {
        return firstList;
    }

    public void setFirstList(List<T> firstList) {
        this.firstList = firstList;
    }

    public List<E> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<E> secondList) {
        this.secondList = secondList;
    }

    public List<T> getFirstDanList() {
        return firstDanList;
    }

    public void setFirstDanList(List<T> firstDanList) {
        this.firstDanList = firstDanList;
    }

    public List<E> getSecondDanList() {
        return secondDanList;
    }

    public void setSecondDanList(List<E> secondDanList) {
        this.secondDanList = secondDanList;
    }
}
