package com.ruijie.util;

import java.util.ArrayList;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
public class ProcessType {

    private ProcessType(){}

    private static final ArrayList<String> processTypeA = new ArrayList<>();
    private static final ArrayList<String> processTypeP = new ArrayList<>();
    private static final ArrayList<String> processTypeT = new ArrayList<>();
    private static final ArrayList<String> processTypeY = new ArrayList<>();

    static {
        processTypeA.add("caaca1740685c0409309ca40e5779cf286c1");
        processTypeP.add("caaca1740685c0409309ca40e5779cf286c1");
        processTypeT.add("780869290110804f7f0b05a02c19cc52ab54");
        processTypeY.add("caaca1740685c0409309ca40e5779cf286c1");

    }

    public static String getProcessTypeByProcessId(String processId){

        if(processTypeA.contains(processId)){
            return "A";
        }
        if(processTypeP.contains(processId)){
            return "P";
        }
        if(processTypeT.contains(processId)){
            return "T";
        }
        if(processTypeY.contains(processId)){
            return "Y";
        }
        return processId;
    }
}
