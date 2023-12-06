public class NumbersCat {

    public static String say(long n) {
        return conversionTexto((int) n);
    }

    public static long words(String s) {
        return 0;
    }

    public static String oper(String s) {
        return "";
    }


    public static final String[] unidades = {"", "Un", "Dos", "Tres", "Quatre", "Cinc", "Sis", "Set", "Vuit", "Nou"};
    public static final String[] decenasUnidades = {"Deu", "Onze", "Dotze", "Tretze", "Catorze", "Quinze", "Setze", "Disset", "Divuit", "Dinou"};
    public static final String[] decenas = {"", "Deu", "Vint", "Trenta", "Quaranta", "Cinquanta", "Seixanta", "Setanta", "Vuitanta", "Noranta"};
    public static final String[] centenas = {"", "Cent", "Dos-cents", "Tres-cents", "Quatre-cents", "Cinc-cents", "Sis-cents", "Set-cents", "Vuit-cents", "Nou-cents"};

    public static String conversionTexto(long numero) {
        String resultado = "";
        long millar = numero / 1000;
        long millarDecenasUnidades = numero % 1000;
        long millarUnidades = numero % 1000;
        long millarDecenas = numero % 1000;
        long millarCentenas = numero % 10000;
        long centena = numero / 100;
        long decena = (numero % 100) / 10;
        long decenaUnidades = numero % 100;
        long unidad = numero % 10;

        if (numero == 0) {
            return "Zero";
        } else if (numero < 0) {
            return "Menys " + conversionTexto(-numero).toLowerCase();
        } else if (numero < 10) {
            resultado = unidades(unidad);
        } else if (numero < 20) {
            resultado = decenasUnidades(decenaUnidades);
        } else if (numero > 20 && numero < 30) {
            if (unidad == 0) {
                resultado = decenas(decena);
            } else {
                resultado = decenas(decena) + "-i-" + unidades(unidad).toLowerCase();
            }
        } else if (numero >= 10 && numero < 100) {
            if (unidad == 0) {
                resultado = decenas(decena).toUpperCase();
            } else {
                resultado = decenas(decena).toUpperCase() + "-" + unidades(unidad).toLowerCase();
            }
        } else if (numero >= 100 && numero < 1000) {
            if (numero % 100 == 0) {
                resultado = centenas(centena);
            } else {
                resultado = centenas(centena) + " " + conversionTexto(numero % 100).toLowerCase();
            }
        } else if (numero > 120 && numero < 130) {
            resultado = centenas(centena) + " " + mayusculasYMinusculas(decenas(decena) + "-i-" + unidades(unidad));

        } else if (numero > 200 && numero < 230) {
            resultado = centenas(centena) + " " + decenas(decena) + " " + unidades(unidad);
        } else if (numero < 1000) {
            resultado = centenas(centena) + " " + decenas(decena) + " " + unidades(unidad);
        } else if (numero == 1000) {
            resultado = "Mil";
        } else if (numero < 10_000) {
                    resultado = conversionTexto(millar).toLowerCase();
                    if (millarDecenasUnidades != 0) {
                        resultado += "-" + conversionTexto(millarDecenasUnidades).toLowerCase();
                    } else {
                        resultado += " ";
                    }
        } else if (numero < 100_000) {
            resultado = decenasMiles(numero / 10_000);
            if (numero % 10_000 != 0) {
                resultado += " " + conversionTexto(numero % 10_000).toLowerCase();
            }
        } else if (numero < 1_000_000) {
            resultado = centenasMiles(numero / 100_000);
            if (numero % 100_000 != 0) {
                resultado += " " + conversionTexto(numero % 100_000).toLowerCase();
            }
        } else if (numero < 10_000_000) {
            resultado = millones(numero / 1_000_000) + " " + conversionTexto(numero % 1_000_000).toLowerCase();
        }
        else if (numero < 100_000_000) {
            resultado = decenasMillones(numero / 10_000_000) + " " + conversionTexto(numero % 10_000_000).toLowerCase();
        } else if (numero < 1_000_000_000) {
            resultado = centenasMillones(numero / 100_000_000) + " " + conversionTexto(numero % 100_000_000).toLowerCase();
        } else if (numero < 10_000_000_000L) {
            resultado = billones(numero / 1_000_000_000) + " " + conversionTexto(numero % 1_000_000_000).toLowerCase();
        } else if (numero < 100_000_000_000L) {
            resultado = decenasBillones(numero / 10_000_000_000L) + " " + conversionTexto(numero % 10_000_000_000L).toLowerCase();
        } else if (numero < 1_000_000_000_000L) {
            resultado = centenasBillones(numero / 100_000_000_000L) + " " + conversionTexto(numero % 100_000_000_000L).toLowerCase();
        }

        return resultado.substring(0, 1).toUpperCase() + resultado.substring(1).toLowerCase();
    }


    public static String unidades(long unidad) {
        if (unidad == 0) {
            return "";
        } else if (unidad == 1) {
            return "Un";
        } else if (unidad == 2) {
            return "Dos";
        } else if (unidad == 3) {
            return "Tres";
        } else if (unidad == 4) {
            return "Quatre";
        } else if (unidad == 5) {
            return "Cinc";
        } else if (unidad == 6) {
            return "Sis";
        } else if (unidad == 7) {
            return "Set";
        } else if (unidad == 8) {
            return "Vuit";
        } else if (unidad == 9) {
            return "Nou";
        } else {
            return "";
        }
    }

    //Una función para representar las decenas, del 10 al 90
    public static String decenas(long decena) {
        if (decena == 0) {
            return "";
        } else if (decena == 1) {
            return "Deu";
        } else if (decena == 2) {
            return "Vint";
        } else if (decena == 3) {
            return "Trenta";
        } else if (decena == 4) {
            return "Quaranta";
        } else if (decena == 5) {
            return "Cinquanta";
        } else if (decena == 6) {
            return "Seixanta";
        } else if (decena == 7) {
            return "Setanta";
        } else if (decena == 8) {
            return "Vuitanta";
        } else if (decena == 9) {
            return "Noranta";
        } else {
            return "";
        }
    }

    public static String decenasUnidades(long decenaUnidades) {
        if (decenaUnidades == 10) {
            return "Deu";
        } else if (decenaUnidades == 11) {
            return "Onze";
        } else if (decenaUnidades == 12) {
            return "Dotze";
        } else if (decenaUnidades == 13) {
            return "Tretze";
        } else if (decenaUnidades == 14) {
            return "Catorze";
        } else if (decenaUnidades == 15) {
            return "Quinze";
        } else if (decenaUnidades == 16) {
            return "Setze";
        } else if (decenaUnidades == 17) {
            return "Disset";
        } else if (decenaUnidades == 18) {
            return "Divuit";
        } else if (decenaUnidades == 19) {
            return "Dinou";
        } else {
            return "";
        }
    }

    public static String centenas(long centena) {
        if (centena == 0) {
            return "";
        } else if (centena == 1) {
            return "Cent";
        } else if (centena == 2) {
            return "Dos-cents";
        } else if (centena == 3) {
            return "Tres-cents";
        } else if (centena == 4) {
            return "Quatre-cents";
        } else if (centena == 5) {
            return "Cinc-cents";
        } else if (centena == 6) {
            return "Sis-cents";
        } else if (centena == 7) {
            return "Set-cents";
        } else if (centena == 8) {
            return "Vuit-cents";
        } else if (centena == 9) {
            return "Nou-cents";
        } else {
            return "";
        }
    }

    public static String mil(long mil) {
        if (mil == 0) {
            return "";
        } else if (mil == 1) {
            return "Mil";
        } else if (mil == 2) {
            return "Dos mil";
        } else if (mil == 3) {
            return "Tres mil";
        } else if (mil == 4) {
            return "Quatre mil";
        } else if (mil == 5) {
            return "Cinc mil";
        } else if (mil == 6) {
            return "Sis mil";
        } else if (mil == 7) {
            return "Set mil";
        } else if (mil == 8) {
            return "Vuit mil";
        } else if (mil == 9) {
            return "Nou mil";
        } else {
            return "";

        }
    }
        public static String decenasMiles(long decenasMiles) {
            if (decenasMiles == 0) {
                return "";
            } else if (decenasMiles == 1) {
                return "Deu mil";
            } else {
                return decenas(decenasMiles) + " Mil";
            }
        }

        public static String centenasMiles(long centenasMiles) {
            if (centenasMiles == 0) {
                return "";
            } else if (centenasMiles == 1) {
                return "Cent mil";
            } else {
                return centenas(centenasMiles) + "";
            }
        }

        public static String millones(long millones) {
            if (millones == 0) {
                return "";
            } else if (millones == 1) {
                return "Un Milió";
            } else {
                return unidades(millones) + " Milions";
            }
        }

        public static String decenasMillones(long decenasMillones) {
            if (decenasMillones == 0) {
                return "";
            } else if (decenasMillones == 1) {
                return "Deu Milions";
            } else {
                return decenas(decenasMillones) + " Milions";
            }
        }

        public static String centenasMillones(long centenasMillones) {
            if (centenasMillones == 0) {
                return "";
            } else {
                return centenas(centenasMillones) + " Milions";
            }
        }

        public static String billones(long billones) {
            if (billones == 0) {
                return "";
            } else if (billones == 1) {
                return "Un bilió";
            } else {
                return unidades(billones) + " Bilions";
            }
        }

        public static String decenasBillones(long decenasBillones) {
            if (decenasBillones == 0) {
                return "";
            } else if (decenasBillones == 1) {
                return "Deu Bilions";
            } else {
                return decenas(decenasBillones) + " Bilions";
            }
        }

        public static String centenasBillones(long centenasBillones) {
            if (centenasBillones == 0) {
                return "";
            } else {
                return centenas(centenasBillones) + " Bilions";
            }
        }


    public static String mayusculasYMinusculas(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res += c;
        }
return res;

    }

}