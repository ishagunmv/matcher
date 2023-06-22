import java.util.*;

public class StringMatcher {

    /**
     * Найти сматченные строки из массива
     * @param strings массив строк
     */
    public static void findMatchingStrings(String[] strings) {
        Map<String, List<Integer>> map = buildMap(strings);
        printMatchingStrings(map);
    }


    /**
     * Создаем коллекцию строка - индекс
     * @param strings массив строк
     * @return коллекция
     */
    private static Map<String, List<Integer>> buildMap(String[] strings) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String current = strings[i];
            String sortedString = sortString(current);

            List<Integer> indexes = map.getOrDefault(sortedString, new ArrayList<>());
            indexes.add(i);
            map.put(sortedString, indexes);
        }

        return map;
    }

    /**
     * Сортировка элемента из массива
     * @param str строка
     * @return возаращает отсортированную строку
     */
    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    /**
     * Печатает сматченную строку
     * @param map передаем Map
     */
    private static void printMatchingStrings(Map<String, List<Integer>> map) {
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() > 1) {
                System.out.print(entry.getKey() + " = ");
                for (int i = 0; i < indexes.size(); i++) {
                    System.out.print(indexes.get(i));
                    if (i < indexes.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"qwe", "wqe", "qwee", "a", "a"};
        findMatchingStrings(strings);
    }
}
