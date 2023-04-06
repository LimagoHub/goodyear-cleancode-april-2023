package uebung.client;

import uebung.ArrayService;

public class ArrayClient {

    private int feld[] = new int[Integer.MAX_VALUE/2];
    private final ArrayService arrayService;

    public ArrayClient(ArrayService arrayService) {
        this.arrayService = arrayService;
    }

    public void doSomethingWithFilledArray() {
        arrayService.fillArray(feld);
        //---
    }
}
