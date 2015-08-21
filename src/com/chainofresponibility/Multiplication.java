package com.chainofresponibility;

public class Multiplication implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public Number calculate(CalculationRequest request) throws Exception{
        if (request.getCalculationWanted().equals("mult")) {
            int x1 = request.getNumber1();
            int x2 = request.getNumber2();
            return x1 * x2;
//            System.out.println(x1 + " * " + x2 + " = " + (x1 * x2));
        }
        else{
            return this.nextInChain.calculate(request);
        }
    }
}
