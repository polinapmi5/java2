public class House {
    private int floors;

    public House(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return String.format("Дом с %d %s", floors, getFloorWord());
    }

    private String getFloorWord() {
        // Правила русского языка для выбора окончания
        if (floors % 10 == 1 && floors % 100 != 11) {
            return "этажом";
        } else if (floors % 10 >= 2 && floors % 10 <= 4 && (floors % 100 < 10 || floors % 100 >= 20)) {
            return "этажами";
        } else {
            return "этажами";
        }
    }
}

