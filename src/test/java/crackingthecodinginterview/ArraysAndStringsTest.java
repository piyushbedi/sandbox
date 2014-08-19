package crackingthecodinginterview;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Piyush on 19/08/14.
 */
public class ArraysAndStringsTest {

    @Test
    public void uniqueCharactersNullAndEmptyReturnsTrue() {
        assertThat(ArraysAndStrings.allUniqueCharacters(""), is(true));
        assertThat(ArraysAndStrings.allUniqueCharacters(null), is(true));
    }

    @Test
    public void uniqueCharacters() {
        assertThat(ArraysAndStrings.allUniqueCharacters("o"), is(true));
        assertThat(ArraysAndStrings.allUniqueCharacters("helo"), is(true));
        assertThat(ArraysAndStrings.allUniqueCharacters("hello"), is(false));
        assertThat(ArraysAndStrings.allUniqueCharacters("hahaha"), is(false));
        assertThat(ArraysAndStrings.allUniqueCharacters("hhaaaa"), is(false));
    }

    @Test
    public void uniqueCharactersInPlaceNullAndEmptyReturnsTrue() {
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace(""), is(true));
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace(null), is(true));
    }

    @Test
    public void uniqueCharactersInPlace() {
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace("o"), is(true));
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace("helo"), is(true));
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace("hello"), is(false));
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace("hahaha"), is(false));
        assertThat(ArraysAndStrings.allUniqueCharactersInPlace("hhaaaa"), is(false));
    }

    @Test
    public void reverseCStyleStringReturnsEmptyOrNullForEmptyOrNullString() {
        assertThat(ArraysAndStrings.reverseCStyleString(null), is(nullValue()));
        assertThat(ArraysAndStrings.reverseCStyleString("".toCharArray()), is(""));
    }

    @Test
    public void reverseCStyleString() {
        assertThat(ArraysAndStrings.reverseCStyleString("o".toCharArray()), is("o"));
        assertThat(ArraysAndStrings.reverseCStyleString("hello".toCharArray()), is("olleh"));
        assertThat(ArraysAndStrings.reverseCStyleString("hahaha".toCharArray()), is("ahahah"));
        assertThat(ArraysAndStrings.reverseCStyleString("haaah".toCharArray()), is("haaah"));
    }

    @Test
    public void removeDuplicateCharactersReturnsEmptyStringWhenGivenANullOrEmptyString() {
        assertThat(ArraysAndStrings.removeDuplicateCharacters(null), is(""));
        assertThat(ArraysAndStrings.removeDuplicateCharacters(""), is(""));
    }

    @Test
    public void removeDuplicateCharacters() {
        assertThat(ArraysAndStrings.removeDuplicateCharacters("o"), is("o"));
        assertThat(ArraysAndStrings.removeDuplicateCharacters("unique"), is("unique"));
        assertThat(ArraysAndStrings.removeDuplicateCharacters("helloo"), is("helo"));
        assertThat(ArraysAndStrings.removeDuplicateCharacters("aaaa"), is("a"));
    }
}
