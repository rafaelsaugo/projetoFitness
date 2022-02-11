package co.tiagoaguiar.codelab.myapplication;

public class MainItem {
    private int id;
    private int drawableId;
    private int textStringId;
    private int color;

    public MainItem(int id, int drawableId, int textStringId, int color) {
        this.id = id;
        this.drawableId = drawableId;
        this.textStringId = textStringId;
        this.color = color;
    }

    public void setColor (int Color){
        this.color = color;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int setTextStringId() {
        return textStringId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public int getTextStringId() {
        return textStringId;
    }
}
