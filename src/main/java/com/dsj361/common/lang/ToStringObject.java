package com.dsj361.common.lang;

public class ToStringObject {

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
