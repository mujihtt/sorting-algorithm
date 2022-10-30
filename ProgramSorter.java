import java.lang.Math;
import java.util.Scanner;

class ProgramSorter {
    int[] random_numbers;
    int min, max, length;
    Scanner in = new Scanner(System.in);

    enum sortMode {
        ASC,
        DESC
    }

    void initialize(int length) {
        System.out.print("\u001b[0mBatas Bawah: \u001b[92m");
        this.min = in.nextInt();
        System.out.print("\u001b[0mBatas Atas: \u001b[92m");
        this.max = in.nextInt();
        this.length = length;
        this.random_numbers = new int[length];
        this.random();
    }

    private int[] swap(int posX, int posY) {
        int[] swapped_array = new int[length];
        int temporary = this.random_numbers[posX];
        this.random_numbers[posX] = this.random_numbers[posY];
        this.random_numbers[posY] = temporary;
        return swapped_array;
    }

    private void printArrayOfInt(int[] array, String separator) {
        for (int i = 0; i < length; i++) {
            System.out.print("\u001b[0m" + array[i] + separator);
        }
        System.out.print("\n");
    }

    void random() {
        for (int i = 0; i < length; i++) {
            random_numbers[i] = (int) (Math.floor(Math.random() * (max - min + 1) + min));
        }
        printArrayOfInt(random_numbers, "\t");
    }

    void bubble_sort(sortMode mode) {
        int[] sorted_number = random_numbers;
        for (int i = 0; i < length - 1; i++) {
            System.out.println("\n\u001b[0mPass " + (i + 1));

            for (int j = 0; j < length - i - 1; j++) {
                if (mode == sortMode.ASC) {
                    if (sorted_number[j] > sorted_number[j + 1]) {
                        swap(j, j + 1);
                    }
                } else if (mode == sortMode.DESC) {
                    if (sorted_number[j] < sorted_number[j + 1]) {
                        swap(j, j + 1);
                    }
                }

                printArrayOfInt(sorted_number, " ");
            }
            System.out.println("\nResult of Pass " + (i + 1));
            printArrayOfInt(sorted_number, " ");
        }
    }

    void bubble_sort_asc() {
        this.bubble_sort(sortMode.ASC);
    }

    void bubble_sort_desc() {
        this.bubble_sort(sortMode.DESC);
    }

    void selection_sort(sortMode mode) {
        int[] sorted_numbers = random_numbers;
        for (int i = 0; i < length - 1; i++) {
            System.out.println("\n\u001b[0mPass " + (i + 1));

            int lowest_index = i;
            for (int j = i + 1; j < length; j++) {
                if (mode == sortMode.ASC) {
                    if (random_numbers[j] < random_numbers[lowest_index]) {
                        lowest_index = j;
                    }
                } else if (mode == sortMode.DESC) {
                    if (random_numbers[j] > random_numbers[lowest_index]) {
                        lowest_index = j;
                    }
                }

                printArrayOfInt(sorted_numbers, " ");
            }
            swap(lowest_index, i);
            System.out.println("\nResult of Pass " + (i + 1));
            printArrayOfInt(sorted_numbers, " ");
        }
    }

    void selection_sort_asc() {
        this.selection_sort(sortMode.ASC);
    };

    void selection_sort_desc() {
        this.selection_sort(sortMode.DESC);
    }

    public void start() {
        System.out.println("\n");
        System.out.println("Selamat Datang di Program Simulasi");
        System.out.println("Menu");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");
        System.out.println("Masukan Pilihan Anda \u001b[92m");

        int command = in.nextInt();
        switch (command) {
            case 1:
                this.initialize(5);
                this.start();
                break;
            case 2:
                this.bubble_sort_asc();
                this.start();
                break;
            case 3:
                this.selection_sort_asc();
                this.start();
                break;
            case 4:
                this.bubble_sort_desc();
                this.start();
                break;
            case 5:
                this.selection_sort_desc();
                this.start();
                break;
            case 6:
                this.close();
                break;
            default:
                break;
        }
    }

    public void close() {
        in.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        ProgramSorter program = new ProgramSorter();
        program.start();
    }
}