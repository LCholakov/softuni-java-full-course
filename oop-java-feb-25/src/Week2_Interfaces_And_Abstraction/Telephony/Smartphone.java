package Week2_Interfaces_And_Abstraction.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String toString() {
        return call() + browse();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String s : urls) {
            if(!hasDigits(s)) {
                sb.append(String.format("Browsing: %s!", s));
            } else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String s : numbers) {
            if(isNumeric(s)) {
                sb.append("Calling... ").append(s);
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDigits(String s) {
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
