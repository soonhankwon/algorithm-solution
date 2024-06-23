import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Item> items = new ArrayList<>();
        for (int[] d : data) {
            Item item = new Item(d[0], d[1], d[2], d[3]);
            items.add(item);
        }

        items = filterByExt(items, ext, val_ext);
        items = sort(items, sort_by);

        int size = items.size();
        int[][] answer = new int[size][4];
        for (int i = 0; i < size; i++) {
            Item item = items.get(i);
            answer[i] = new int[]{item.code, item.date, item.max, item.remain};
        }
        return answer;
    }
    
    private List<Item> filterByExt(List<Item> items, String ext, int val_ext) {
        if (ext.equals("code")) {
            return items.stream().filter(i -> i.code <= val_ext)
                    .collect(Collectors.toList());
        }
        if (ext.equals("date")) {
            return items.stream().filter(i -> i.date <= val_ext)
                    .collect(Collectors.toList());
        }
        if (ext.equals("maximum")) {
            return items.stream().filter(i -> i.max <= val_ext)
                    .collect(Collectors.toList());
        }
        return items.stream().filter(i -> i.remain <= val_ext)
                .collect(Collectors.toList());
    }
    
    private List<Item> sort(List<Item> items, String sort_by) {
        if (sort_by.equals("code")) {
            return items.stream()
                    .sorted(Comparator.comparingInt(i -> i.code))
                    .collect(Collectors.toList());
        }
        if (sort_by.equals("date")) {
            return items.stream()
                    .sorted(Comparator.comparingInt(i -> i.date))
                    .collect(Collectors.toList());
        }
        if (sort_by.equals("maximum")) {
            return items.stream()
                    .sorted(Comparator.comparingInt(i -> i.max))
                    .collect(Collectors.toList());
        }
        return items.stream()
                .sorted(Comparator.comparingInt(i -> i.remain))
                .collect(Collectors.toList());
    }
    
    private class Item {
        int code;
        int date;
        int max;
        int remain;

        public Item(int code, int date, int max, int remain) {
            this.code = code;
            this.date = date;
            this.max = max;
            this.remain = remain;
        }
    }
}
