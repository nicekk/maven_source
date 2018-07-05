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
public class DanCombineEntry<T> extends ToStringObject {

    /**
     * 普通集合
     */
    private List<T> objectList;

    /**
     * 单集合
     */
    private List<T> danObjectList;

    public List<T> getDanObjectList() {
        return danObjectList;
    }

    public void setDanObjectList(List<T> danObjectList) {
        this.danObjectList = danObjectList;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }

}
