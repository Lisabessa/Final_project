package ru.samsung.final_project;

public class User { // модель базы данных
    private long id;
    private String name;
    private float result_module_software;
    private float result_module_hardware;
    private float result_module_genverbs;
    private float result_module_internet;

    public User(long id, String name, float result_module_software, float result_module_hardware,
    float result_module_genverbs, float result_module_internet) {
        this.id = id;
        this.name = name;
        this.result_module_software = result_module_software;
        this.result_module_hardware = result_module_hardware;
        this.result_module_genverbs = result_module_genverbs;
        this.result_module_internet = result_module_internet;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getResult_module_software() {
        return result_module_software;
    }

    public void setResult_module_software(float result_module_software) {
        this.result_module_software = result_module_software;
    }

    public float getResult_module_hardware() {
        return result_module_hardware;
    }

    public void setResult_module_hardware(float result_module_hardware) {
        this.result_module_hardware = result_module_hardware;
    }

    public float getResult_module_genverbs() {
        return result_module_genverbs;
    }

    public void setResult_module_genverbs(float result_module_genverbs) {
        this.result_module_genverbs = result_module_genverbs;
    }

    public float getResult_module_internet() {
        return result_module_internet;
    }

    public void setResult_module_internet(float result_module_internet) {
        this.result_module_internet = result_module_internet;
    }

    @Override
    public String toString() {
        return this.name+"\n"+ "Result Software: " + this.result_module_software
                + "%\n" + "Result Hardware: " + this.result_module_hardware
                + "%\n" + "Result General Verbs: " + this.result_module_genverbs
                + "%\n" + "Result Internet: " + this.result_module_internet + "%";
    }


}
