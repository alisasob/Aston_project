public class BinarySearcher {

    public static <T extends Comparable<T>> int binarySearch(ArrayList<T> array, T element){

        return binarySearch(array,0, array.size(),element);
    }

    public static <T extends Comparable<T>> int binarySearch(ArrayList<T> array,int leftBorder,int rightBorder, T element){

        int middle=leftBorder+((rightBorder-leftBorder)/2);

        if((middle==leftBorder)&&(element!=array.get(middle))) return -1;
        else if(array.get(middle).compareTo(element)>0){
            return binarySearch(array,leftBorder,middle,element);
        }else if(array.get(middle).compareTo(element)<0){
            return  binarySearch(array,middle,rightBorder,element);
        }else    return middle;
    }
}