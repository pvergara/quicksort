package org.ecos.logic.quicksort;

import org.ecos.logic.quicksort.example.data.Element;
import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    @Test
    void givenTheNumbers_10_7_4_3_5_2_1_WhenIAddToQuickSortCollectionAndAskToSortTheSystemReturnsMe_1_2_3_4_5_7_10() throws BinaryCollectionNullPointerException {
        List<Integer> result = new QuickSortCollection<Integer>().addElements(10, 7, 4, 3, 5, 2, 1).sort();

        assertThat(result).contains(1, 2, 3, 4, 5, 7, 10);
    }

    @Test
    void givenTheNumbers_10_WhenIAddToQuickSortCollectionAndAskToSortTheSystemReturnsMe_10() throws BinaryCollectionNullPointerException {
        List<Integer> result = new QuickSortCollection<Integer>().addElements(10).sort();

        assertThat(result).contains(10);
    }

    @Test
    void givenTheNumbers_10_1_WhenIAddToQuickSortCollectionAndAskToSortTheSystemReturnsMe_1_10() throws BinaryCollectionNullPointerException {
        List<Integer> result = new QuickSortCollection<Integer>().addElements(10, 1).sort();

        assertThat(result).contains(1, 10);
    }

    @Test
    void givenTheNumbers_10_9_3_4_5_7_6_1_4_2_WhenIAddToQuickSortCollectionAndAskToSortTheSystemReturnsMe_1_2_3_4_4_5_6_7_9_10() throws BinaryCollectionNullPointerException {
        List<Integer> result = new QuickSortCollection<Integer>().addElements(10, 9, 3, 4, 5, 7, 6, 1, 4, 2).sort();

        assertThat(result).contains(1,2,3,4,4,5,6,7,9,10);
    }

    @Test
    void givenTheElementsOfAComparableClassWhenIAddToQuickSortCollectionAndAskToSortTheSystemReturnsMe_1_2_3_4_5_7_10() throws BinaryCollectionNullPointerException {
        Element uncleSam = new Element("Uncle", "Sam", 30);
        Element uncleTom = new Element("Uncle", "Tom", 20);
        Element aunSara = new Element("Aunt", "Ada", 10);
        List<Element> result = new QuickSortCollection<Element>().addElements(uncleSam, uncleTom, aunSara).sort();

        assertThat(result).contains(aunSara,uncleTom,uncleSam);
    }
}
