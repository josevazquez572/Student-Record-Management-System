import java.util.ArrayList;

public class studentAlgorithm {

    public static int compareStudents(student a,student b,String sortChoice) {

        if (sortChoice.equalsIgnoreCase("Id")) {

            if (a.getId() < b.getId()) {return -1;}

            else if (a.getId() > b.getId()) {return 1;}

            else {return 0;}
        }

        else if (sortChoice.equalsIgnoreCase("Name")) {

            return a.getName().compareToIgnoreCase(b.getName());
        }

        else if (sortChoice.equalsIgnoreCase("Gpa")) {

            if (a.getGpa() < b.getGpa()) {return -1;}

            else if (a.getGpa() > b.getGpa()) {return 1;}

            else {return 0;}
        }
        return 0;
    }

    public static void bubbleSort(ArrayList<student> records,String sortChoice) {

        for (int i = 0; i < records.size() - 1; i++) {
            for (int j = 0; j < records.size() - 1 - i; j++) {

                if (compareStudents(records.get(j), records.get(j + 1), sortChoice) > 0) {

                    student temp = records.get(j);

                    records.set(j, records.get(j + 1));

                    records.set(j + 1, temp);
                }
            }
        }
    }

    public static student binarySearchById(ArrayList<student> records,int target) {

        int low = 0;
        int high = records.size() - 1;

        while (low <= high) {

            int middle = (low + high) / 2;

            int middleId = records.get(middle).getId();

            if (middleId == target) {

                return records.get(middle);
            }

            else if (middleId < target) {

                low = middle + 1;
            }

            else {

                high = middle - 1;
            }
        }

        return null;
    }

    public static void quickSort(ArrayList<student> records,int low,int high,String sortChoice) {

        if (low < high) {  
            int pivotIndex = partition(records,low,high,sortChoice);

            quickSort(records,low,pivotIndex - 1,sortChoice);

            quickSort(records,pivotIndex + 1,high,sortChoice);
        }
    }


    public static int partition(ArrayList<student> records,int low,int high,String sortChoice) {

        student pivot = records.get(high);

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (compareStudents(records.get(j), pivot,
                    sortChoice) <= 0) {i++;student temp = records.get(i);

                records.set(i, records.get(j));
                records.set(j, temp);
            }
        }

        student temp = records.get(i + 1);

        records.set(i + 1, records.get(high));

        records.set(high, temp);

        return i + 1;
    }

    public static void mergeSort(ArrayList<student> records, int low, int high, String sortChoice) {

        if (low < high) {

            int middle = (low + high) / 2;

            mergeSort(records,low,middle,sortChoice);

            mergeSort(records, middle + 1,high,sortChoice);

            merge(records,low,middle,high, sortChoice);
        }
    }


    public static void merge(ArrayList<student> records, int low, int middle, int high, String sortChoice) {

        ArrayList<student> temp = new ArrayList<>();

        int left = low;
        int right = middle + 1;

        while (left <= middle && right <= high) {

            if (compareStudents(records.get(left),records.get(right),sortChoice) <= 0) {

                temp.add(records.get(left));
                left++;
            }

            else {

                temp.add(records.get(right));
                right++;
            }
        }

        while (left <= middle) {

            temp.add(records.get(left));
            left++;
        }

        while (right <= high) {

            temp.add(records.get(right));
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {

            records.set(low + i, temp.get(i));
        }
    }

    public static void bucketSort(ArrayList<student> records,String sortChoice) {

        if (records.size() == 0) {return;}

        int max;

        if (sortChoice.equalsIgnoreCase("Id")) {

            max = records.get(0).getId();

            for (student s : records) {

                if (s.getId() > max) {
                    max = s.getId();
                }
            }
        }

        else {

            max = (int) Math.round(records.get(0).getGpa() * 100);

            for (student s : records) {

                int value = (int) Math.round(s.getGpa() * 100);

                if (value > max) {
                    max = value;
                }
            }
        }

        ArrayList<ArrayList<student>> buckets = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<student>());
        }

        for (student s : records) {

            int value;

            if (sortChoice.equalsIgnoreCase("Id")) {

                value = s.getId();
            }

            else {

                value = (int) Math.round(s.getGpa() * 100);
            }

            buckets.get(value).add(s);
        }

        records.clear();

        for (ArrayList<student> bucket : buckets) {

            for (student s : bucket) {

                records.add(s);
            }
        }
    }

    public static void radixSort(ArrayList<student> records, String sortChoice) {

        if (records.size() == 0) {return;}

        int max;

        if (sortChoice.equalsIgnoreCase("Id")) {

            max = records.get(0).getId();

            for (student s : records) {
                if (s.getId() > max) {
                    max = s.getId();
                }
            }

        } else {

            max = (int) Math.round(records.get(0).getGpa() * 100);

            for (student s : records) {
                int value = (int) Math.round(s.getGpa() * 100);

                if (value > max) {
                    max = value;
                }
            }
        }

        int place = 1;

        while (max / place > 0) {

            radixPass(records, sortChoice, place);

            place = place * 10;
        }
    
    }

    public static void radixPass(ArrayList<student> records,String sortChoice,int place) {

        int[] count = new int[10];

        ArrayList<student> output = new ArrayList<>();

        for (int i = 0; i < records.size(); i++) {
            output.add(null);
        }

        for (int i = 0; i < records.size(); i++) {

            int value;

            if (sortChoice.equalsIgnoreCase("Id")) {
                value = records.get(i).getId();
            } else {
                value = (int) Math.round(records.get(i).getGpa() * 100);
            }

            int digit = (value / place) % 10;

            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = records.size() - 1; i >= 0; i--) {

            int value;

            if (sortChoice.equalsIgnoreCase("Id")) {
                value = records.get(i).getId();
            } else {
                value = (int) Math.round(records.get(i).getGpa() * 100);
            }

            int digit = (value / place) % 10;

            output.set(count[digit] - 1, records.get(i));

            count[digit]--;
        }

        for (int i = 0; i < records.size(); i++) {
            records.set(i, output.get(i));
        }
        }
}