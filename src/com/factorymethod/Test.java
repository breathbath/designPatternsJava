package com.factorymethod;

public class Test {
    public static void main(String[] args){
        CommandLineParser parser = new CommandLineParser(args);
        Request request = new Request(parser.getArguments());

        Controller controller = dispatch(new IndexControllerFactory(request));
        echoResponse(controller.getResponse());

        controller = dispatch(new AboutControllerFactory(request));
        echoResponse(controller.getResponse());
    }

    private static void echoResponse(Response response){
        System.out.println("Headers: "+response.getHeaders());
        System.out.println("Body: "+response.getBody());
    }

    private static Controller dispatch(Factory factory){
        Controller controller = factory.create();
        controller.action();
        return controller;
    }
}
