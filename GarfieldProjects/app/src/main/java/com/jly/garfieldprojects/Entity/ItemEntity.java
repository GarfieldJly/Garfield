package com.jly.garfieldprojects.Entity;//**

/**
 * User: garfield
 * Date: 2016-05-05
 * Time: 20:20
 * Des:
 */
public class ItemEntity {
    private boolean checked = true;
    private String content;

    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public ItemEntity(boolean checked, String content) {
        super();
        this.checked = checked;
        this.content = content;
    }
    public ItemEntity() {
        super();
    }

}
