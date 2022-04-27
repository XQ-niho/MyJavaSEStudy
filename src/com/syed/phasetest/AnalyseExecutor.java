package com.syed.phasetest;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-20
 */
public class AnalyseExecutor {
    public static void main(String[] args) {
        AnalyseExecutor analyseExecutor = new AnalyseExecutor();
        analyseExecutor.execute();
    }

    @TypeOfHandleAnnotation(strategy=AnalysisStrategy.ANALYSIS_DQ,dealNum = 6)
    public List<Film> execute(){
        try {
            Class<AnalyseExecutor> analyseExecutorClass = AnalyseExecutor.class;
            Method executeMethod = analyseExecutorClass.getMethod("execute");
            TypeOfHandleAnnotation annotationOfTypeOfHandle = executeMethod.getAnnotation(TypeOfHandleAnnotation.class);
            System.out.println(annotationOfTypeOfHandle);
            AnalysisStrategy strategy = annotationOfTypeOfHandle.strategy();
            int dealNum = annotationOfTypeOfHandle.dealNum();
            System.out.println(strategy);
            System.out.println(dealNum);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
