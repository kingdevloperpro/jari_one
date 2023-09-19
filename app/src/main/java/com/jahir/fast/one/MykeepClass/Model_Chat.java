package com.jahir.fast.one.MykeepClass;

public class Model_Chat {
    private boolean type;
    private String message;

    public Model_Chat(boolean type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean getType() {
        return this.type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
