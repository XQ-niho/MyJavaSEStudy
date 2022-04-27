package com.syed.homework.homework0329;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * description：单词和词汇的共同父类
 * @author Administrator
 * @date 2022/3/21 15:54
 */
public abstract class Base {
    /**公共属性*/
    /**英文*/
    private String en;
    /**中文*/
    private List<String> cns;

    public Base() {
    }

    public Base(String en, List<String> cns) {
        this.en = en;
        this.cns = cns;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public List<String> getCns() {
        return cns;
    }

    public void setCns(ArrayList<String> cns) {
        this.cns = cns;
    }

    @Override
    public String toString() {
        return "Base{" +
                "en='" + en + '\'' +
                ", cns=" + cns +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return Objects.equals(en, base.en) &&
                Objects.equals(cns, base.cns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(en, cns);
    }
}