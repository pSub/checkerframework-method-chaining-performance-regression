import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PoC {

    public void chaining() {            // maven total build time
        Stream.of(1)                    // with 2.10.0      with 2.9.0      with 3.0.0
              .map(i -> i +1)           // 5.617 s          4.836 s          3.280 s
              .map(i -> i +1)           // 6.058 s          5.316 s         3.173 s
              .map(i -> i +1)           // 6.321 s          5.518 s         3.400 s
              .map(i -> i +1)           // 5.988 s
              .map(i -> i +1)           // 6.655 s
              .map(i -> i +1)           // 6.386 s
              .map(i -> i +1)           // 6.515 s
              .map(i -> i +1)           // 7.829 s
              .map(i -> i +1)           // 9.336 s
              .map(i -> i +1)           // 11.014 s
              .map(i -> i +1)           // 14.770 s
              .map(i -> i +1)           // 17.767 s
              .map(i -> i +1)           // 25.510 s
              .map(i -> i +1)           // 43.908 s
              .map(i -> i +1)           // 55.217 s         3.327 s         01:12 min
              .map(i -> i +1)           // 01:58 min        3.342 s          01:59 min
              .map(i -> i +1)           // 03:37 min        6.162 s         03:56 min
              .collect(Collectors.toList());
    }


}
