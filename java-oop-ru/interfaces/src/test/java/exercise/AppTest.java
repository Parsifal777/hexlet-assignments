package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

class AppTest {

    @Test
    void testBuildApartmentsList1() {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
                "Квартира площадью 44.0 метров на 10 этаже",
                "Квартира площадью 90.0 метров на 2 этаже",
                "2 этажный коттедж площадью 125.5 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildApartmentsList2() {
        List<Home> apartments = new ArrayList<>(List.of(
                new Cottage(100, 1),
                new Flat(190, 10, 2),
                new Flat(180, 30, 5),
                new Cottage(250, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
                "1 этажный коттедж площадью 100.0 метров",
                "Квартира площадью 200.0 метров на 2 этаже",
                "Квартира площадью 210.0 метров на 5 этаже",
                "3 этажный коттедж площадью 250.0 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 4);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildApartmentsList3() {
        List<Home> apartments = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = App.buildApartmentsList(apartments, 10);
        assertThat(result).isEqualTo(expected);
    }

    // BEGIN
    @Test
    void testReversedSequence() {
        CharSequence text = new ReversedSequence("abcdef");

        // Проверка toString()
        assertThat(text.toString()).isEqualTo("fedcba");

        // Проверка length()
        assertThat(text.length()).isEqualTo(6);

        // Проверка charAt()
        assertThat(text.charAt(1)).isEqualTo('e');
        assertThat(text.charAt(5)).isEqualTo('a');

        // Проверка subSequence()
        assertThat(text.subSequence(1, 4).toString()).isEqualTo("edc");

        // Проверка пустой строки
        CharSequence empty = new ReversedSequence("");
        assertThat(empty.toString()).isEqualTo("");
        assertThat(empty.length()).isEqualTo(0);
    }

    @Test
    void testReversedSequenceEdgeCases() {
        // Проверка одного символа
        CharSequence singleChar = new ReversedSequence("a");
        assertThat(singleChar.toString()).isEqualTo("a");
        assertThat(singleChar.length()).isEqualTo(1);
        assertThat(singleChar.charAt(0)).isEqualTo('a');
        assertThat(singleChar.subSequence(0, 1).toString()).isEqualTo("a");

        // Проверка специальных символов
        CharSequence specialChars = new ReversedSequence("a1!ф");
        assertThat(specialChars.toString()).isEqualTo("ф!1a");
        assertThat(specialChars.charAt(1)).isEqualTo('!');
    }

    @Test
    void testReversedSequenceExceptions() {
        CharSequence text = new ReversedSequence("abc");

        // Проверка выхода за границы для charAt()
        assertThrows(IndexOutOfBoundsException.class, () -> text.charAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> text.charAt(3));

        // Проверка выхода за границы для subSequence()
        assertThrows(IndexOutOfBoundsException.class, () -> text.subSequence(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> text.subSequence(1, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> text.subSequence(2, 1));
    }
    // END
}