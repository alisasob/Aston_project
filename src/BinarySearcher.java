public class BinarySearcher {

    public static  int binarySearch(ArrayList<Comparable> array, Comparable element){

        return binarySearch(array,0, array.size(),element);
    }

    public static int binarySearch(ArrayList<Comparable> array,int leftBorder,int rightBorder, Comparable element){

        int middle=leftBorder+((rightBorder-leftBorder)/2);

        if((middle==leftBorder)&&(element!=array.get(middle))) return -1;
        else if(array.get(middle).compareTo(element)>0){
            return binarySearch(array,leftBorder,middle,element);
        }else if(array.get(middle).compareTo(element)<0){
            return  binarySearch(array,middle,rightBorder,element);
        }else    return middle;
    }
}