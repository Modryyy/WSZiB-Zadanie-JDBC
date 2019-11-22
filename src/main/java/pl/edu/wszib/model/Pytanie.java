package pl.edu.wszib.model;

public class Pytanie {
    private int idPytania;
    private int Nagroda;
    private String Pytanie;
    private String Odpowiedzi;
    private String PrawidlowaOdpowiedz;

    public int getIdPytania() {
        return idPytania;
    }

    public void setIdPytania(int idPytania) {
        this.idPytania = idPytania;
    }

    public int getNagroda() {
        return Nagroda;
    }

    public void setNagroda(int nagroda) {
        Nagroda = nagroda;
    }

    public String getPytanie() {
        return Pytanie;
    }

    public void setPytanie(String pytanie) {
        Pytanie = pytanie;
    }

    public String getOdpowiedzi() {
        return Odpowiedzi;
    }

    public void setOdpowiedzi(String odpowiedzi) {
        Odpowiedzi = odpowiedzi;
    }

    public String getPrawidlowaOdpowiedz() {
        return PrawidlowaOdpowiedz;
    }

    public void setPrawidlowaOdpowiedz(String prawidlowaOdpowiedz) {
        PrawidlowaOdpowiedz = prawidlowaOdpowiedz;
    }

    @Override
    public String toString() {
        return "Pytanie{" +
                "idPytania=" + idPytania +
                ", Nagroda=" + Nagroda +
                ", Pytanie='" + Pytanie + '\'' +
                ", Odpowiedzi='" + Odpowiedzi + '\'' +
                ", PrawidlowaOdpowiedz='" + PrawidlowaOdpowiedz + '\'' +
                '}';
    }
}
