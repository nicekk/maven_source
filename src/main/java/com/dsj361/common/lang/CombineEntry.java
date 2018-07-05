/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.dsj361.common.lang;

import com.dsj361.common.lang.ToStringObject;

import java.util.List;

/**
 * 合并实体
 *
 * @author chenbug
 *
 * @version $Id: CombineEntry.java, v 0.1 2011-6-13 下午06:37:59 chenbug Exp $
 */
public class CombineEntry<T> extends ToStringObject {

    /**
     * 实体KEY
     */
    private Object key;

    /**
     * 选项列表
     */
    private List<T> choiceList;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public List<T> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<T> choiceList) {
        this.choiceList = choiceList;
    }

}
