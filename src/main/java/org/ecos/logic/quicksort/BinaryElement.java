package org.ecos.logic.quicksort;

import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;

import java.util.ArrayList;
import java.util.List;

public class BinaryElement<T extends Comparable<T>> {
    T element;
    BinaryElement<T> left;
    BinaryElement<T> right;


    public void addAll(List<T> list) throws BinaryCollectionNullPointerException {
        for (T element : list) {
            this.add(element);
        }
    }

    private void add(T element) throws BinaryCollectionNullPointerException {
        if (element == null) {
            throw new BinaryCollectionNullPointerException();
        }
        if (this.element == null) {
            this.element = element;
        } else if (this.element.compareTo(element) > 0) {
            if (this.left == null) {
                this.left = new BinaryElement<>();
            }
            this.left.add(element);
        } else {
            if (this.right == null) {
                this.right = new BinaryElement<>();
            }
            this.right.add(element);
        }
    }

    public List<T> goThroughElementsInOrder() {
        List<T> result = new ArrayList<>();
        if (this.left == null) {
            result.add(element);
            if (this.right != null) {
                result.addAll(this.right.goThroughElementsInOrder());
            }
            return result;
        } else {
            result = new ArrayList<>(this.left.goThroughElementsInOrder());
            result.add(this.element);
            if (this.right != null) {
                result.addAll(this.right.goThroughElementsInOrder());
            }
        }
        return result;
    }
}
