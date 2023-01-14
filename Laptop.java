public class Laptop {

    String id;
    String brand;
    String processor;
    String ram;
    String ssd;
    String color;

    public Laptop(String id, String brand,
            String processor,
            String ram, String ssd,
            String color) {
        this.id = id;
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.ssd = ssd;
        this.color = color;
    }

    public String toString() {
        return String.format("\nid:%s\nModel:%s\nProcessor:%s\nRAM:%s\nSSD:%s\nColor:%s",
                id, brand, processor, ram, ssd, color);
    }

    public String getInfo(String filter) {

        if (filter == "brand") {
            return brand;
        }
        if (filter == "processor") {
            return processor;
        }
        if (filter == "RAM") {
            return ram;
        }
        if (filter == "SSD") {
            return ssd;
        }
        if (filter == "сolor") {
            return color;
        }
        return "id - " + id;
    }

}