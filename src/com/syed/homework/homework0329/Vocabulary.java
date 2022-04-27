package com.syed.homework.homework0329;

import java.util.List;
import java.util.Objects;

/**
 * description：词汇子类
 * @author Administrator
 * @date 2022/3/21 16:06
 */
public class Vocabulary extends Base {
    /**特有属性:缩写*/
    private String abbreviation = "";

    public Vocabulary() {
    }

    public Vocabulary(String en, List<String> cns) {
        super(en, cns);
    }

    public Vocabulary(String en, List<String> cns, String abbreviation) {
        super(en, cns);
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "abbreviation='" + abbreviation + '\'' +
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
        if (!super.equals(o)) {
            return false;
        }
        Vocabulary that = (Vocabulary) o;
        return Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), abbreviation);
    }
}