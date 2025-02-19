package Week3_Generics.Exer.GenericSwapMethodStrings_03;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> objects;

    public Box() {
        this.objects = new ArrayList<>();
    }

    public void add(T object) {
        this.objects.add(object);
    }

    public  void swap (int index1, int index2) {
        T temp = this.objects.get(index1);
        this.objects.set(index1, this.objects.get(index2));
        this.objects.set(index2, temp);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.objects) {
            String fStr = String.format("%s: %s%n", element.getClass().getName(), element);
            sb.append(fStr);
        }
//        this.objects.forEach(e -> sb.append(e.getClass().getName()));

        return sb.toString();
    }

    public int countGreater(T obj) {
        int count = 0;
        for (T e : this.objects) {
            if (e.compareTo(obj) > 0) {
                count++;
            }
        }
        return count;
    }
}


//Тоест:
//1. Изтривам ред 1 в мейн файл (пр. package Week3_Generics.Week4_IteratorsAndComparators.Exer.GenericBox_01;)
//2. Изтривам ред 1 във файл с класа (пр. package Week3_Generics.Week4_IteratorsAndComparators.Exer.GenericBox_01;)
//3. Архивирам двата файла. Не папката, в която са, а самите файлове.
//4. По едно ctrl+z във всеки файл.
