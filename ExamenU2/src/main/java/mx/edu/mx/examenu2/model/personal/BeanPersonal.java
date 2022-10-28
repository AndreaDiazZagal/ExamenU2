package mx.edu.mx.examenu2.model.personal;

public class BeanPersonal {
long id;
String name;
String lastname;
String birthday;
double estatura;
double peso;
int utiliza_magia;
int equipo;
int magia_id;
int tipo_lucha;

    public BeanPersonal(long id, String name, String lastname, String birthday, double estatura, double peso, int utiliza_magia, int equipo, int magia_id, int tipo_lucha) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.estatura = estatura;
        this.peso = peso;
        this.utiliza_magia = utiliza_magia;
        this.equipo = equipo;
        this.magia_id = magia_id;
        this.tipo_lucha = tipo_lucha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getUtiliza_magia() {
        return utiliza_magia;
    }

    public void setUtiliza_magia(int utiliza_magia) {
        this.utiliza_magia = utiliza_magia;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getMagia_id() {
        return magia_id;
    }

    public void setMagia_id(int magia_id) {
        this.magia_id = magia_id;
    }

    public int getTipo_lucha() {
        return tipo_lucha;
    }

    public void setTipo_lucha(int tipo_lucha) {
        this.tipo_lucha = tipo_lucha;
    }
    public BeanPersonal(){}
}
