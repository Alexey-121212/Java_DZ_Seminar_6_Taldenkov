
public class Notebook {
    private int ram;
    private int hdd;
    private int weight;
    private String os;
    private String brand;

    public Notebook(int ram, int hdd, int weight) {
        this.ram = ram;
        this.hdd = hdd;
        this.weight = weight;
    }

    public int getRam() {
        return this.ram;
    }

    public int getHdd() {
        return this.hdd;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getOs() {
        return this.os;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        String description = String.format("Notebook with:\nRAM: %d Gb\nHDD: %d Gb\nWeight: %d",
                this.ram,
                this.hdd,
                this.weight);

        if (this.os != null) {
            description = description + "\nOs: " + this.os;
        }
        if (this.brand != null) {
            description = description + "\nBrand:" + this.brand;
        }

        return description;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
