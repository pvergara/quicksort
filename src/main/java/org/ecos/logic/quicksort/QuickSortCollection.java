package org.ecos.logic.quicksort;

import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;

import java.util.Arrays;
import java.util.List;

public class QuickSortCollection<T extends Comparable<T>> {

    private final BinaryElement<T> binaryElement;

    public QuickSortCollection() {
        this.binaryElement = new BinaryElement<>();
    }

    public List<T> sort() {
        return this.binaryElement.goThroughElementsInOrder();
    }

    public List<T> reverseSort() {
        return this.binaryElement.goThroughElementsInReverseOrder();
    }

    @SafeVarargs
    public final QuickSortCollection<T> addElements(T... elements) throws BinaryCollectionNullPointerException {
        this.binaryElement.addAll(Arrays.stream(elements).toList());
        return this;
    }
}
