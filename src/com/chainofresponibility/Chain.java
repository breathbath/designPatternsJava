package com.chainofresponibility;

public interface Chain {

    public void setNextChain(Chain nextChain);

    /**
     * @param request CalculationRequest
     * @return Number
     */
    public Number calculate(CalculationRequest request) throws Exception;

}
