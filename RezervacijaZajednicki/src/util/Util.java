/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Mesto;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Aco Kandic
 */
public class Util {

    public static final String url = "jdbc:mysql://localhost:3306/rezervacijaprostora";
    public static final String username = "root";
    public static final String password = "";
    public static final int SK_UNOS_KORISNIKA = 1;
    public static final int SK_IZMENA_KORISNIKA = 2;
    public static final int SK_UNOS_REZERVACIJE = 3;
    public static final int SK_IZMENA_REZERVACIJE = 4;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final int OPERACIJA_SACUVAJ_MESTO = 100;
    public static final int OPERACIJA_VRATI_SVA_MESTA = 101;
    public static final int OPERACIJA_VRATI_MESTO_PO_PTT = 102;
    public static final int OPERACIJA_SACUVAJ_KORISNIKA = 200;
    public static final int OPERACIJA_SACUVAJ_SVE_KORISNIKE = 201;
    public static final int OPERACIJA_VRATI_SVE_KORISNIKE = 202;
    public static final int OPERACIJA_VRATI_SVE_KORISNIKE_PO_MESTU = 203;
    public static final int OPERACIJA_AZURIRAJ_KORISNIKA = 204;
    public static final int OPERACIJA_VRATI_SVE_PROSTORIJE = 300;
    public static final int OPERACIJA_VRATI_SVE_REZERVACIJE = 400;
    public static final int OPERACIJA_SACUVAJ_REZERVACIJU = 401;
    public static final int OPERACIJA_ULOGUJ_ADMINISTRATORA = 600;
    public static final int OPERACIJA_IZLOGUJ_ADMINISTRATORA = 601;
    public static final int OPERACIJA_VRATI_SVE_ADMINISTRATORE = 602;

    public static final int SERVER_STATUS_OPERACIJA_OK = 1000;
    public static final int SERVER_STATUS_OPERACIJA_NOT_OK = 1001;

    public static final String MAP_KEY_SOKET = "soket";

    public static final String ADMIN1_UN = "admin";
    public static final String ADMIN1_PASS = "admin";

}
