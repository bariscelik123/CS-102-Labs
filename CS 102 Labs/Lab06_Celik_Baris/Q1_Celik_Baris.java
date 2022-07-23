import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Q1_Celik_Baris {

    public static void main(String[] args) {
        Integer[] power = new Integer[]{4,1,8,8,7,1,6,1};
        List<Integer> game = Arrays.asList(power);
        System.out.println(calculate(game));
    }

    public static int calculate(List<Integer> half1) {

        if(half1.size() == 2){
            return half1.get(0) + half1.get(1);
        }

        else {
            int x = calculate(half1.subList(0, half1.size()/2)) + Collections.max(half1.subList(half1.size()/2, half1.size()));
            int y = calculate(half1.subList(half1.size()/2,half1.size())) + Collections.max(half1.subList(0,half1.size()/2));
            return Math.max(x, y);
        }



    }

}


