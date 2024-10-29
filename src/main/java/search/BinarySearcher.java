package main.java.search;

import main.java.entity.Sortable;

public class BinarySearcher {

    public static  int binarySearch(ArrayList<Sortable> array, Sortable element){

        return binarySearch(array,0, array.size(),element);
    }

    public static int binarySearch(ArrayList<Sortable> array,int leftBorder,int rightBorder, Sortable element){

        int middle=leftBorder+((rightBorder-leftBorder)/2);

            return binarySearch(array,leftBorder,middle,element);
        }else if(array.get(middle).compareTo(element)<0){
            return  binarySearch(array,middle,rightBorder,element);
    }
}