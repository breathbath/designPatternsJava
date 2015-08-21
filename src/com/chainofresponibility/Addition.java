package com.chainofresponibility;

public class Addition implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    /**
     * @param request
     * @return Number
     * @throws Exception
     */
    public Number calculate(CalculationRequest request) throws Exception {
        if (request.getCalculationWanted().equals("add")) {
            int x1 = request.getNumber1();
            int x2 = request.getNumber2();
            return x1+x2;
        }
        else{
            return this.nextInChain.calculate(request);
        }
    }
}
