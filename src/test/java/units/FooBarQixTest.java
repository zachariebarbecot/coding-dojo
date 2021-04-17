package units;

import fr.zbar.codingdojo.foobarqix.FooBarQix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FooBarQixTest {

    private FooBarQix fooBarQix;

    @BeforeEach
    void init() {
        fooBarQix = new FooBarQix();
    }

    @ParameterizedTest(name = "when enter {0}, get {1}")
    @CsvSource({
            "1,1",
            "2,2",
            "3,FooFoo",
            "4,4",
            "5,BarBar",
            "6,Foo",
            "7,QixQix",
            "8,8",
            "9,Foo",
            "10,Bar",
            "333,FooFooFooFoo",
            "357,FooQixFooBarQix"
    })
    void should_foobarqix(Integer input, String expected) {
        assertThat(fooBarQix.execute(input)).isEqualTo(expected);
    }
}
