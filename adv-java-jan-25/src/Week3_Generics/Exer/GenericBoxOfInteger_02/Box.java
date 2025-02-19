package Week3_Generics.Exer.GenericBoxOfInteger_02;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> objects;

    public Box() {
        this.objects = new ArrayList<>();
    }

    public void add(T object) {
        this.objects.add(object);
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
}


//Тоест:
//1. Изтривам ред 1 в мейн файл (пр. package Week3_Generics.Week4_IteratorsAndComparators.Exer.GenericBox_01;)
//2. Изтривам ред 1 във файл с класа (пр. package Week3_Generics.Week4_IteratorsAndComparators.Exer.GenericBox_01;)
//3. Архивирам двата файла. Не папката, в която са, а самите файлове.
//4. По едно ctrl+z във всеки файл.
