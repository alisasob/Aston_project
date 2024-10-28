package main.java.search;

import main.java.entity.Sortable;

import java.util.ArrayList;

public class BinarySearcher {

    public static  int binarySearch(ArrayList<Sortable> array, Sortable element){

        return binarySearch(array,0, array.size(),element);
    }

    public static int binarySearch(ArrayList<Sortable> array,int leftBorder,int rightBorder, Sortable element){

        int middle = leftBorder + ((rightBorder - leftBorder) / 2);

 //       if ((middle == leftBorder) && (element != array.get(middle))){
            if ((middle == leftBorder) && (array.get(middle).compareTo(element) != 0)){
            return -1;
        } else if(array.get(middle).compareTo(element) > 0){
            return binarySearch(array,leftBorder,middle,element);
        } else if(array.get(middle).compareTo(element) < 0){
            return  binarySearch(array,middle,rightBorder,element);
        } else {
            return middle;
        }
    }
}