package service;

import com.sap.labs.tdd.model.IBlock;

import java.util.List;

/**
 * Created by Sapir Golan on 25/10/2015.
 */
public interface ICalculationService {

    double calcRankedValue(final List<? extends IBlock> blocks);

    double calcMRR(final List<? extends IBlock> blocks);
}
