package com.lelewan.masterpiece;

import java.util.ArrayList;

/**
 * Created by ann.chen on 2015/4/22.
 */
public class BooksInfo {
    public BooksInfo() {}
    public int getBookAmounts(){
        return 10;
    }
    public int[] getBookIds() {
        int[] a={1,2,3,4};
        return a;
    }

    public String getBookName(int id){
        switch (id) {
            case 0:return "init";
            case 1: return "a";
            case 2: return "b";
            case 3: return "c";
            case 4: return "d";
            case 42:return "outOfBound";
            default:return null;
        }
    }
}
