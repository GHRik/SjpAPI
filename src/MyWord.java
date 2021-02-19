package sjpAPI;

public class MyWord {
    private String name;
    private boolean canBeUsed;
    private String description;

    public MyWord(String name, boolean canBeUsed, String description){
        this.name = name;
        this.canBeUsed = canBeUsed;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public boolean isCanBeUsed() {
        return canBeUsed;
    }

    public String getDescription() {
        return description;
    }

    public String getJSON() {
        String json = "";
        json += "\"name:\"" +'"'+this.name+'"'+"\r\n";
        json += "\"canBeUsed:\""+'"'+Boolean.toString(this.canBeUsed)+'"'+"\r\n";
        json += "\"descriprion:\""+'"'+this.description+'"'+"\n";
        return json;

    }

}
