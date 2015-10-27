package com.sap.labs.tdd.service;

import com.sap.labs.tdd.model.IBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sapir Golan on 25/10/2015.
 */

public class MeasurementsService {

    private ICalculationService calculationService;
    private double rankedValue;
    private Map<Double, Double> map;

    public MeasurementsService() {
        map = new HashMap<>();
    }

    private void calculateRankedValue(List<? extends IBlock> blocks, double threshold) {
        rankedValue = calculationService.calcRankedValue(blocks);
        map.put(threshold, rankedValue);
    }

    public void calc(List<? extends IBlock> blocks, double threshold) {
        this.calculateRankedValue(blocks, threshold);
    }

    public double getRankedValue(double threshold) {
        return map.get(threshold);
    }

    /*
    * TODO:
    * 1) create a method that calculates RankedValue
    * 2) return the latest value of RankedValue
    * 3) bind each calculation of RankedValue to a threshold.
    * 4) return the value of RankedValue using the threshold.
    * 5) do 1-4 for MRR as well
    * 6) combine the calculations of RankedValue & MRR to one public method
    * 7) For a given threshold, RankedValue can be calculated several times - keep track on the different scores.
    * 8) return the average RankedValue for a given threshold
    * 9) do 6-7 for MRR as well.
    * 10) ?
    *
    * */

}
