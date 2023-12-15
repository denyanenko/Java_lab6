import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        ArrayList<ElectricalAppliance> electricalAppliances = new ArrayList<>();
        electricalAppliances.add(new ElectricKettle("Philips", "HD9353/90", 9, 220, 0.3));
        electricalAppliances.add(new ElectricKettle("BrandX", "Model123", 8, 230, 0.4));
        electricalAppliances.add(new Microwave("Samsung", "MS1234", 12, 240, 700));
        electricalAppliances.add(new Microwave("LG", "MH5678", 10, 220, 800));
        electricalAppliances.add(new Refrigerator("Whirlpool", "WR123", 15, 230, 0.7));
        electricalAppliances.add(new Refrigerator("Bosch", "BFR456", 14, 240, 0.8));
        electricalAppliances.add(new ElectricKettle("AnotherBrand", "ModelABC", 7, 210, 0.2));
        electricalAppliances.add(new Microwave("Panasonic", "P123", 11, 225, 600));
        electricalAppliances.add(new Refrigerator("Electrolux", "ER789", 13, 220, 0.6));
        electricalAppliances.add(new ElectricKettle("Philips", "HD9353/90", 9, 220, 0.3));

        for (int i = 0; i < 7; i++) {
            int result = apartment.plugIntoOutlet(electricalAppliances.get(i));
            if (result >= 0) {
                System.out.println(electricalAppliances.get(i) + " успішно підключено до розетки номер " + (result + 1));
            } else if (result == -1) {
                System.out.println("Вже підключений до іншої розетки");
            } else {
                System.out.println("Всі розетки зайняті. Вимкніть один із пристроїв або додайте кількість розеток");
            }
        }
        System.out.println("\nЗагальна потужність всіх пристроїв квартири " + apartment.calculatePowerConsumption() + "W\n");

        ArrayList<ElectricalAppliance> sortedElectricalAppliances = apartment.getSortedElectricalAppliance();
        System.out.println("Відсортований за потужністю список електроприладів квартири:");
        for (ElectricalAppliance appliance : sortedElectricalAppliances) {
            System.out.println(appliance);
        }

        double minElectromagneticRadiation = 0.4;
        double maxElectromagneticRadiation = 0.9;
        ArrayList<ElectricalAppliance> electromagneticRangeElectricalAppliances = apartment
                .findApplianceByElectromagneticRange(minElectromagneticRadiation, maxElectromagneticRadiation);
        System.out.println("\nСписок електропристроїв в діапазоні від " + minElectromagneticRadiation + "MHz до "
                + maxElectromagneticRadiation + "MHz");
        for (ElectricalAppliance appliance : electromagneticRangeElectricalAppliances) {
            System.out.println(appliance);
        }


    }
}