import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class ClumpsTest {
    @ParameterizedTest
    @MethodSource("generator")
    void testClumps(int[] nums, int expectedNoOfClumps) {
        assertThat(Clumps.countClumps(nums))
                .isEqualTo(expectedNoOfClumps);
    }


    static Stream<Arguments> generator() {
        return Stream.of(
                of(new int[]{}, 0), //T1
                of(null, 0), //T2
                of(new int[]{1,2,2,1}, 1), //T3
                of(new int[]{1}, 0) //T4
        );
    }
}