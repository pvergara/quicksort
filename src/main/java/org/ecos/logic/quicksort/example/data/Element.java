package org.ecos.logic.quicksort.example.data;

public record Element(String name, String surname, int age) implements Comparable<Element> {

    @Override
    public int compareTo(Element other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
