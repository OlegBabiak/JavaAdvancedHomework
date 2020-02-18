package HomeWork01;

public class Salary {


    public double nadbavka(double oklad, double vidsNadb) {
        return oklad * vidsNadb;
    }

    public double zarplata(double oklad, double nadbavka, double premija) {
        return oklad + nadbavka + premija;
    }

    public double doVydachi(double zarplata, double tax) {
        if (zarplata < tax)
            throw new IllegalArgumentException("zarplata must be greater that tax");

        return zarplata - tax;
    }

}

