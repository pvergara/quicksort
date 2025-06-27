import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryCollection<T extends Comparable<T>> {
    T element;
    BinaryCollection<T> left;
    BinaryCollection<T> right;


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
                this.left = new BinaryCollection<>();
            }
            this.left.add(element);
        } else {
            if (this.right == null) {
                this.right = new BinaryCollection<>();
            }
            this.right.add(element);
        }
    }

    public List<T> goThroughElementsInOrder() {
        List<T> result;
        if (this.left == null) {
            return Collections.singletonList(element);
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
