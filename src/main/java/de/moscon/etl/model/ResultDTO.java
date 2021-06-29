package de.moscon.etl.model;

public class ResultDTO {

    private String text;
    private Integer count;

    public ResultDTO() {
    }

    public ResultDTO(String text, Integer count) {
        this.text = text;
        setCount();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount() {
        Integer j=0;
        String text= this.getText();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)))
                j++;
        }
        this.count=j;
    }
}
