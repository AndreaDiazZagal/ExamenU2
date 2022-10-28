package mx.edu.mx.examenu2.model.position;

public class BeanPosition {
    long id;
    String position;

    public BeanPosition() {
    }

    public BeanPosition(long id, String position) {
        this.id = id;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

