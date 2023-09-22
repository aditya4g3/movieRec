import java.util.ArrayList;

public class Sorter{
	public void insertionSort(int opt, ArrayList<Movie> list) {
    for (int j = 1; j < list.size(); j++) {
        Movie current = list.get(j);
        int i = j-1;
        while ((i >= 0) && ((list.get(i).compareTo(opt,current)) > 0)) {
            list.set(i+1, list.get(i));
            i--;
        }
        list.set(i+1, current);
    }
}
	
}