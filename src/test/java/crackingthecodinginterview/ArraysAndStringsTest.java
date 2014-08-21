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
        assertThat(ArraysAndStrings.removeDuplicateCharactersInPlace(null), is(nullValue()));
        assertThat(ArraysAndStrings.removeDuplicateCharactersInPlace("".toCharArray()), is("".toCharArray()));
    }

    @Test
    public void removeDuplicateCharacters() {
        assertThat(ArraysAndStrings.removeDuplicateCharactersInPlace("o".toCharArray()), is("o".toCharArray()));
        assertThat(ArraysAndStrings.removeDuplicateCharactersInPlace("uniqe".toCharArray()), is("uniqe".toCharArray()));
        assertThat(ArraysAndStrings.removeDuplicateCharactersInPlace("helloo".toCharArray()), is("helo".toCharArray()));
        assertThat(ArraysAndStrings.removeDuplicateCharactersInPlace("aaaa".toCharArray()), is("a".toCharArray()));
    }

    @Test
    public void areAnagramsReturnsFalseWhenOnlyOneStringIsNull() {
        assertThat(ArraysAndStrings.areAnagrams("str".toCharArray(), null), is(false));
        assertThat(ArraysAndStrings.areAnagrams(null, "str".toCharArray()), is(false));
    }

    @Test
    public void areAnagrams() {
        assertThat(ArraysAndStrings.areAnagrams(null, null), is(true));
        assertThat(ArraysAndStrings.areAnagrams("".toCharArray(), "".toCharArray()), is(true));
        assertThat(ArraysAndStrings.areAnagrams("blah".toCharArray(), "habl".toCharArray()), is(true));
        assertThat(ArraysAndStrings.areAnagrams("h".toCharArray(), "h".toCharArray()), is(true));
        assertThat(ArraysAndStrings.areAnagrams("aa".toCharArray(), "aa".toCharArray()), is(true));
        assertThat(ArraysAndStrings.areAnagrams("aab".toCharArray(), "abb".toCharArray()), is(false));
    }
}
