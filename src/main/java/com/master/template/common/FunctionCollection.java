package com.master.template.common;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FunctionCollection {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");


    public static String getNumericOnly(String text) {
        String tmp = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9') {
                tmp += text.charAt(i);
            }
        }
        return tmp;
    }


    @SuppressWarnings("deprecation")
    public static Date getDate(String date) {
        String temp = "";

        temp = date.substring(6, 10) + "/";
        temp += date.substring(3, 5) + "/";
        temp += date.substring(0, 2);

        return new Date(temp);
    }


    @SuppressWarnings("deprecation")
    public static Date getStringToDate(String date) {
        String temp = "";

        temp = date.substring(6, 10) + "/";
        temp += date.substring(3, 5) + "/";
        temp += date.substring(0, 2);

        return new Date(temp);
    }

    public static Date getStringToDate1(String date) {
        String temp = "";

        temp = date.substring(3, 5) + "/";
        temp += date.substring(6, 10) + "/";
        temp += date.substring(0, 2);

        return new Date(temp);
    }


    @SuppressWarnings("deprecation")
    public static Date getDateReverse(String date) {
        String temp = "";

        temp = date.substring(0, 4) + "/";
        temp += date.substring(4, 6) + "/";
        temp += date.substring(6, 8);

        return new Date(temp);
    }



    public static void writeFile(String location, String[] list) {
        try {
            OutputStream file = new FileOutputStream(location);
            DataOutputStream out = new DataOutputStream(file);

            for (int i = 0; i < list.length; i++) {
                out.writeBytes(list[i].trim() + "\n");
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * Fungsi yang menulis ArrayOfCode ke disk untuk digunakan pada ComboBox
     */
    public static void writeFile(String directory, String location, String[] list) {
        try {
            new File(directory).mkdir();
            OutputStream file = new FileOutputStream(directory + "/" + location);
            DataOutputStream out = new DataOutputStream(file);

            for (int i = 0; i < list.length; i++) {
                out.writeBytes(list[i].trim() + "\n");
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String formatDate(Date date) {
        if(date != null)
            return dateFormat.format(date).trim();
        return "";
    }

    public static String getStatusText(String code) {
        if (code.equals("001")) {
            return "INACTIVE";
        } else if (code.equals("002")) {
            return "ACTIVE";
        } else if (code.equals("003")) {
            return "ACCOUNT BLOCKED";
        } else if (code.equals("004")) {
            return "CLOSED";
        } else if (code.equals("005")) {
            return "DELETED";
        } else if (code.equals("006")) {
            return "HALF BLOCKED";
        } else if (code.equals("007")) {
            return "FULL BLOCKED";
        } else {
            return null;
        }
    }

    public static String getNamaHari(String hari) {
        if (hari.equals("Monday")) {
            return "SENIN";
        } else if (hari.equals("Tuesday")) {
            return "SELASA";
        } else if (hari.equals("Wednesday")) {
            return "RABU";
        } else if (hari.equals("Thursday")) {
            return "KAMIS";
        } else if (hari.equals("Friday")) {
            return "JUMAT";
        } else if (hari.equals("Saturday")) {
            return "SABTU";
        } else if (hari.equals("Sunday")) {
            return "MINGGU";
        } else {
            return null;
        }
    }

    public static String getNamaBulan(String bulan) {

        if (bulan.equals("January") || bulan.equals("01") || bulan.equals("1")) {
            return "Januari";
        } else if (bulan.equals("February") || bulan.equals("02")  || bulan.equals("2")) {
            return "Februari";
        } else if (bulan.equals("March") || bulan.equals("03")  || bulan.equals("3")) {
            return "Maret";
        } else if (bulan.equals("April") || bulan.equals("04")  || bulan.equals("4")) {
            return "April";
        } else if (bulan.equals("May") || bulan.equals("05")  || bulan.equals("5") ) {
            return "Mei";
        } else if (bulan.equals("June") || bulan.equals("06")  || bulan.equals("6") ) {
            return "Juni";
        } else if (bulan.equals("July") || bulan.equals("07")  || bulan.equals("7") ) {
            return "Juli";
        }else if (bulan.equals("August") || bulan.equals("08")  || bulan.equals("8")) {
            return "Agustus";
        }else if (bulan.equals("September") || bulan.equals("09")  || bulan.equals("9")) {
            return "September";
        }else if (bulan.equals("October") || bulan.equals("10") ) {
            return "Oktober";
        }else if (bulan.equals("November") || bulan.equals("11")) {
            return "November";
        }else if (bulan.equals("December") || bulan.equals("12")) {
            return "Desember";
        }else {
            return null;
        }
    }

    public static String moneyToText(BigDecimal money) {
        if (money == null) {
            return "0.00";
        }

        if (money != null && money.compareTo(new BigDecimal(0)) != 0) {
            boolean isNegative = false;
            if(money.toString().contains("-")){
                money = money.abs();
                isNegative = true;
            }
            //end

            String lsMoney1 = "";
            String lsMoney2 = "";

            if (!money.toString().contains(".")) {
                lsMoney1 += "00.";
                for (int i = money.toString().length() - 1; i > -1; i--) {
                    lsMoney1 += money.toString().charAt(i);
                }
            } else {
                boolean point = false;
                money.toString().indexOf(".");
                for (int i = money.toString().indexOf(".") + 1; i >= money.toString().indexOf("."); i--) {
                    lsMoney1 += money.toString().charAt(i);
                }

                for (int i = money.toString().length() - 1; i > -1; i--) {
                    if (point) {
                        lsMoney1 += money.toString().charAt(i);
                    }
                    if (money.toString().charAt(i) == '.') {
                        point = true;
                    }
                }
            }

            for (int i = 0; i < lsMoney1.length(); i++) {
                if (i == 6 || i == 9 || i == 12 || i == 15 || i == 18)
                    lsMoney2 += ",";
                lsMoney2 += lsMoney1.charAt(i);
            }

            lsMoney1 = "";

            for (int i = lsMoney2.length() - 1; i > -1; i--) {
                lsMoney1 += lsMoney2.toString().charAt(i);
            }


            if(isNegative){
                lsMoney1 = "-"+lsMoney1;
            }
            //end

            return (lsMoney1);
        } else {
            return ("0.00");
        }
    }

    public static String moneyToTextUS(BigDecimal money) {
        if (money == null) {
            return "0.00";
        }

        if (money != null && money.compareTo(new BigDecimal(0)) != 0) {
            //diubah shovi buat nanganin kalo negative suka aneh. misal -300000
            boolean isNegative = false;
            if(money.toString().contains("-")){
                money = money.abs();
                isNegative = true;
            }
            //end

            String lsMoney1 = "";
            String lsMoney2 = "";
            //ambil belakang koma
            if (!money.toString().contains(".")) {
                lsMoney1 += "00.";
                for (int i = money.toString().length() - 1; i > -1; i--) {
                    lsMoney1 += money.toString().charAt(i);
                }
            } else {
                boolean point = false;
                money.toString().indexOf(".");
                for (int i = money.toString().indexOf(".") + 2; i >= money.toString().indexOf("."); i--) {
                    lsMoney1 += money.toString().charAt(i);
                }

                for (int i = money.toString().length() - 1; i > -1; i--) {
                    if (point) {
                        lsMoney1 += money.toString().charAt(i);
                    }
                    if (money.toString().charAt(i) == '.') {
                        point = true;
                    }
                }
            }

            for (int i = 0; i < lsMoney1.length(); i++) {
                if (i == 6 || i == 9 || i == 12 || i == 15 || i == 18)
                    lsMoney2 += ".";
                lsMoney2 += lsMoney1.charAt(i);
            }
            lsMoney1 = "";

            for (int i = lsMoney2.length() - 1; i > -1; i--) {
                lsMoney1 += lsMoney2.toString().charAt(i);
            }

            if(isNegative){
                lsMoney1 = "-"+lsMoney1;
            }

            lsMoney1 = lsMoney1.substring(0,lsMoney1.length()-3).trim();
            return (lsMoney1);
        } else {
            return ("0");
        }
    }

    public static String moneyToTextUS2(BigDecimal money) {
        if (money == null) {
            return "0,00";
        }

        if (money != null && money.compareTo(new BigDecimal(0)) != 0) {

            boolean isNegative = false;
            if(money.toString().contains("-")){
                money = money.abs();
                isNegative = true;
            }
            //end

            String lsMoney1 = "";
            String lsMoney2 = "";

            if (!money.toString().contains(",")) {
                lsMoney1 += "00,";
                for (int i = money.toString().length() - 1; i > -1; i--) {
                    lsMoney1 += money.toString().charAt(i);
                }
            } else {
                boolean point = false;
                money.toString().indexOf(",");
                for (int i = money.toString().indexOf(",") + 2; i >= money.toString().indexOf(","); i--) {
                    lsMoney1 += money.toString().charAt(i);
                }

                for (int i = money.toString().length() - 1; i > -1; i--) {
                    if (point) {
                        lsMoney1 += money.toString().charAt(i);
                    }
                    if (money.toString().charAt(i) == ',') {
                        point = true;
                    }
                }
            }

            for (int i = 0; i < lsMoney1.length(); i++) {
                if (i == 6 || i == 9 || i == 12 || i == 15 || i == 18)
                    lsMoney2 += ",";
                lsMoney2 += lsMoney1.charAt(i);
            }
            lsMoney1 = "";

            for (int i = lsMoney2.length() - 1; i > -1; i--) {
                lsMoney1 += lsMoney2.toString().charAt(i);
            }

            //diubah shovi buat nanganin kalo negative suka aneh. misal -300000
            if(isNegative){
                lsMoney1 = "-"+lsMoney1;
            }
            //end
            //buang koma .00
            lsMoney1 = lsMoney1.substring(0,lsMoney1.length()-7).trim();
            return (lsMoney1);
        } else {
            return ("0");
        }
    }

    public static BigDecimal moneyToBigDecimal(String money) {
        if (!money.equals("")) {
            String temp = "";
            char c;

            for (int i = 0; i < money.length(); i++) {
                c = money.charAt(i);
                if (c >= '0' && c <= '9' || c == '.' || c == '-')
                    temp += c;
            }
            return new BigDecimal(temp);
        } else {
            return new BigDecimal("0");
        }
    }

    public static BigDecimal moneyToBigDecimalUS(String money) {
        if (!money.equals("")) {
            String temp = "";
            char c;

            for (int i = 0; i < money.length(); i++) {
                c = money.charAt(i);
                if (c >= '0' && c <= '9' || c == '-')
                    temp += c;
            }
            return new BigDecimal(temp);
        } else {
            return new BigDecimal("0");
        }
    }
    public static Double moneyToDouble(String money) {
        if (!money.equals("")) {
            String temp = "";
            char c;

            for (int i = 0; i < money.length(); i++) {
                c = money.charAt(i);
                if (c >= '0' && c <= '9' || c == '.')
                    temp += c;
            }
            return new Double(temp);
        } else {
            return new Double("0");
        }
    }



    public static void createDirectory(String pathName) {
        File path = new File(pathName);
        path.mkdirs();
    }

    public static boolean checkedFile(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    /*
     * Method yang memetakan TextStatus ke CodeStatus
     */
    public static char getStatus(String textStatus) {
        if (textStatus.equals("CREATED")) {
            return ('0');
        } else if (textStatus.equals("ACTIVE")) {
            return ('1');
        } else if (textStatus.equals("CLOSED")) {
            return ('2');
        } else if (textStatus.equals("DELETED")) {
            return ('3');
        }

        return ' ';
    }

    /*
     * Method yang memetakan CodeStatus ke TextStatus
     */
    public static String getStatusName(char code) {
        if (code == '0') {
            return "CREATED";
        } else if (code == '1') {
            return "ACTIVE";
        } else if (code == '2') {
            return "CLOSED";
        } else if (code == '3') {
            return "DELETED";
        } else {
            return null;
        }
    }

    /**
     * @author Gemala Candra M.D.A.
     * @since January 08, 2008
     */
    public static String getFileType(String fileName) {
        String fileType = "";
        char tmp;
        boolean isPassed = false;
        for (int i = 0; i < fileName.length(); i++) {
            tmp = fileName.charAt(i);

            if (tmp == '.') {
                isPassed = true;
            } else if (isPassed) {
                fileType += tmp;
            }
        }
        return fileType.trim();
    }


    public static String formatAccountNumber(String strAccNbr) {
        String tmp = "";
        for (int i = 0; i < 10; i++) {
            try {
                tmp += strAccNbr.charAt(i);
            } catch (StringIndexOutOfBoundsException e) {
                tmp += "x";
            }
            if (i == 2 || i == 3 || i == 8) {
                tmp += "-";
            }
        }
        return tmp;
    }


    public static String AccountNumberToString(String strAccNbr) {
        String accNbr = "";

        for (int i = 0; i < strAccNbr.length(); i++) {
            if (strAccNbr.charAt(i) != '-') {
                accNbr += strAccNbr.charAt(i);
            }
        }
        return accNbr;
    }


    public static Date getNextDate(Date startDate, Integer duration, Integer jenis) {

        Calendar newCal = Calendar.getInstance();
        newCal.setTime(startDate);
        switch (jenis) {
            case 0:
                newCal.add(Calendar.DATE, duration);
                break;
            case 1:
                newCal.add(Calendar.MONTH, duration);
                break;
            case 2:
                newCal.add(Calendar.YEAR, duration);
                break;
            default:
                break;
        }
        newCal.get(Calendar.DATE);
        return newCal.getTime();
    } // getNextDate

    public static String createCheckDigit(String accNbr) {
        int[] wFactor = { 8, 7, 6, 5, 4, 3, 2 };
        int c2 = 6;
        long rest, sum = 0;

        for (int i = 0; i < accNbr.length(); i++) {
            sum += (accNbr.charAt(i) - 48) * wFactor[c2];
            if (c2 == 6) {
                c2 = 0;
            }
        }

        rest = sum % 11;
        if (rest == 1) {
            rest = 0;
        } else if (rest == 10 || rest == 0) {
            rest = 1;
        }

        return accNbr + String.valueOf(rest);
    }

    /**
     * @author mala
     *
     * Menghitung banyaknya hari dari tanggal date1 sampai tanggal date2.
     */
    public static int dateDiff(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            long hari = ((date2.getTime() - date1.getTime()) / (24 * 3600 * 1000));
            return Math.abs((Integer.parseInt(String.valueOf(hari))));
        }
        return 0;
    }

    /**
     * @author uwie
     *
     * Menghitung banyaknya bulan dari tanggal date1 sampai tanggal date2.
     */

    @SuppressWarnings("deprecation")
    public static int MonthDiff(Date date1, Date date2) {
        int diffMonth = 0;
        if (date1 != null && date2 != null) {
            Integer year = date2.getYear() - date1.getYear();
            Integer month = date2.getMonth() - date1.getMonth();
            System.out.println("month1: " + month);
            Integer days = date2.getDate() - date1.getDate();
            System.out.println("days1: " + days);

            if (days < 0) {
                month = month - 1;
            }

            if (month < 0) {
                year = year - 1;
                month = 12 - (month * -1);
            }

            diffMonth = (year * 12) + month;
            System.out.println("month: " + month);
            System.out.println("year: " + year);
            System.out.println("diffMonth: " + diffMonth);
        }
        return diffMonth;
    }

    /**
     * @author Mala
     *
     * Menghitung banyaknya tahun dari tanggal date1 sampai tanggal date2.
     */

    public static int yearDiff(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            long hari = ((date2.getTime() - date1.getTime()) / (24 * 3600 * 1000));
            long month = hari / 30;
            long year = month / 12;
            return (Integer.parseInt(String.valueOf(year)));
        }
        return 0;
    }

    public static Date removeTime(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    @SuppressWarnings("deprecation")
    public static int getHariDalamSatuBulan(Date date){
        Integer hari = 0;
        if(date.getMonth() == 1 || date.getMonth() == 3 || date.getMonth() == 5 || date.getMonth() == 7 ||
                date.getMonth() == 8 || date.getMonth() == 10 || date.getMonth() == 12){
            hari = 31;
        }else if(date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 || date.getMonth() == 11) {
            hari = 30;
        }else if(date.getMonth() == 2){
            if(date.getYear() % 4 == 0){
                hari = 29;
            }else{
                hari = 28;
            }
        }
        return hari;
    }

    /**
     * Memformat suatu string menjadi title case.<br><br>
     * Contoh :<br>
     * String s = "aris afandi";<br>
     * String titleCase = FunctionCollection.toTitleCase(s);<br>
     * System.out.println(titleCase);<br><br>
     * hasilnya = Aris Afandi
     *
     *
     * @param s string yang akan di format menjadi title case
     * @return string yang sudah terformat
     */
    public static String toTitleCase(String s) {
        String lowerCase = s.toLowerCase();
        String[] split = lowerCase.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            char charAt = split[i].charAt(0);
            String upper = String.valueOf(charAt).toUpperCase();
            String substring = upper+split[i].substring(1);
            sb.append(substring+" ");
        }

        return sb.toString();
    }

    /**
     * mengambil description dari combobox berformat "id1 - id2 - descr"
     * @param list
     * @param key1
     * @param key2
     * @return
     */
    public static String getNameFromCodeDua(String[] list, String key1, String key2) {
        System.out.println(key1 + " key 1");
        System.out.println(key2 + " key 2");
        for (int i = 0; i < list.length; i++) {
            if (list[i].split("-")[0].trim().equals(key1.trim())) {
                System.out.println(list[i].split("-")[1].trim() + " masuk 1 " + key2.trim());
                if (list[i].split("-")[1].trim().equals(key2.trim())) {
                    System.out.println(" masuk 2");
                    return list[i].split("-")[2].trim();
                }
            }
        }
        return "";
    }

    /**
     * memformat number dalam format dengan panjang tertentu
     * @author dewanta
     * @param value
     * @param masking
     * @param resultLength
     * @return String
     * contoh:
     * untuk menghasilkan 'xxxx4'
     * > formatNumber(4, 'x', 5)
     * untuk menghasilkan '00000007'
     * > formatNumber(7, '0', 8)
     */
    public static String formatNumber(Integer value, String masking, Integer resultLength) {
        String result = "";

        if (masking == null || masking.equals("")) {
            masking = "0";
        }

        for (int i = 0; i < resultLength; i++) {
            result = result + masking;
        }

        result = result + value.toString();

        return result.substring(result.length() - resultLength, result.length());
    }


    public static String formatNumber(String value, String masking, Integer resultLength) {
        String result = "";

        if (masking == null || masking.equals("")) {
            masking = "0";
        }

        for (int i = 0; i < resultLength; i++) {
            result = result + masking;
        }

        result = result + value;

        return result.substring(result.length() - resultLength, result.length());
    }


    public static String formatNumber(String value, String masking, Integer resultLength, String firstSequenceNo) {
        String result = "";

        if (masking == null || masking.equals("")) {
            masking = "0";
        }

        for (int i = 0; i < resultLength; i++) {
            result = result + masking;
        }

        result = value + result;

        return result.substring(0, resultLength - 1) + firstSequenceNo;
    }

    public static String numberToTerbilang(double number) {
        String bilangan[] = new String[] { "", "satu ", "dua ", "tiga ", "empat ", "lima ", "enam ", "tujuh ", "delapan ", "sembilan ", "sepuluh ",
                "sebelas " };

        StringBuffer sb = new StringBuffer();

        if (number < Double.valueOf(12)) {
            sb.append(bilangan[(int) number]);
        }

        if (number >= 12 && number < 20) {
            sb.append(numberToTerbilang(number - 10));
            sb.append("belas ");
        }

        if (number >= 20 && number < 100) {
            sb.append(numberToTerbilang(number / 10));
            sb.append("puluh ");
            sb.append(numberToTerbilang(number % 10));
        }

        if (number >= 100 && number < 200) {
            sb.append("seratus ");
            sb.append(numberToTerbilang(number % 100));
        }

        if (number >= 200 && number < 1000) {
            sb.append(numberToTerbilang(number / 100));
            sb.append("ratus ");
            sb.append(numberToTerbilang(number % 100));
        }

        if (number >= 1000 && number < 2000) {
            sb.append("seribu ");
            sb.append(numberToTerbilang(number % 1000));
        }

        if (number >= 2000 && number < 1000000) {
            sb.append(numberToTerbilang(number / 1000));
            sb.append("ribu ");
            sb.append(numberToTerbilang(number % 1000));
        }

        if (number >= 1000000 && number < 1000000000) {
            sb.append(numberToTerbilang(number / 1000000));
            sb.append("juta ");
            sb.append(numberToTerbilang(number % 1000000));
        }

        if (number >= 1000000000 && number < 1000000000000L) {
            sb.append(numberToTerbilang(number / 1000000000));
            sb.append("milyar ");
            sb.append(numberToTerbilang(number % 1000000000));
        }

        return sb.toString();
    }


    public static int dateCompare(Date date1, Date date2){
        Calendar cal1=Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2=Calendar.getInstance();
        cal2.setTime(date2);

        if(cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)){
            return 1;
        } else if(cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)){
            return -1;
        } else {
            if(cal1.get(Calendar.MONTH) > cal2.get(Calendar.MONTH)){
                return 1;
            } else if(cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH)){
                return -1;
            } else {
                if(cal1.get(Calendar.DATE) > cal2.get(Calendar.DATE)){
                    return 1;
                } else if(cal1.get(Calendar.DATE) < cal2.get(Calendar.DATE)){
                    return -1;
                }
            }
        }
        return 0;
    }

    public static boolean dateIsOnRange(Date date, Date dateFrom, Date dateTo){
        if (dateCompare(date, dateFrom) == 0 || dateCompare(date, dateTo) == 0){
            return true;
        }

        if (dateCompare(date, dateFrom) == 1 && dateCompare(date, dateTo) == -1){
            return true;
        }

        return false;
    }

    public static String FormatTanggalToText(Date tanggal) {
        SimpleDateFormat sdfTanggal = new SimpleDateFormat("dd");
        SimpleDateFormat sdfBulan = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfTahun = new SimpleDateFormat("yyyy");

        return sdfTanggal.format(tanggal)+" "+
                FunctionCollection.getNamaBulan(sdfBulan.format(tanggal)) +" "+
                sdfTahun.format(tanggal);
    }

    public static BigDecimal notNullBigDecimal(BigDecimal angka) {
        if (angka == null) {
            return BigDecimal.valueOf(0);
        }

        return angka;
    }

    public static BigDecimal NullBigDecimal(BigDecimal angka) {
        if (angka == BigDecimal.ZERO) {
            return null;
        }

        return angka;
    }

    /**
     * mendetailkan no polisi
     *
     * contoh: "DK999WW" menjadi "DK","999","WW"
     *
     * @param noPolisi
     * @return String[3]
     */
    public static String[] getNoPolisiDetail(String noPolisi) {
        if (noPolisi != null) {
            String[] noPolDetail = new String[3];
            StringBuilder sb = new StringBuilder();
            char[] chrNoPol = noPolisi.toCharArray();
            for (char c : chrNoPol) {

                if (c >= '0' &&  c <= '9') {
                    noPolDetail[0] = sb.toString();
                    break;
                } else {
                    sb.append(c);
                }
            }

            sb = new StringBuilder();
            noPolisi = noPolisi.substring(noPolDetail[0].length(),noPolisi.length());

            chrNoPol = noPolisi.toCharArray();
            for (char c : chrNoPol) {

                if (c >= '0' &&  c <= '9') {
                    sb.append(c);

                } else {
                    noPolDetail[1] = sb.toString();
                    break;
                }
            }

            sb = new StringBuilder();
            noPolDetail[2] = noPolisi.substring(noPolDetail[1].length(),noPolisi.length());

            return noPolDetail;
        }
        return null;

    }

    public static Boolean isAlphaNumeric(String string) {
        if (string != null) {
            char[] chrString = string.toCharArray();
            for (char c : chrString) {

                if ((c >= '0' &&  c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ) {
                }  else {
                    return false;
                }

            }

            return true;
        } else {
            return false;
        }


    }
    public Object[] DateDifference(Date d1, Date d2) {
        Object object[] = new Object[3];
        Integer years = 0;
        Integer months = 0;
        Integer days = 0;
        Date startDate, endDate;
        Integer startDay = 0;
        Integer startMonth = 0;

        if (d1.compareTo(d2) < 0){
            startDate = d1;
            endDate = d2;
        } else {
            startDate = d2;
            endDate = d1;
        }

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTime(startDate);
        end.setTime(endDate);

        if (start.get(Calendar.YEAR) == end.get(Calendar.YEAR)
                && start.get(Calendar.MONTH) == end.get(Calendar.MONTH)) {
            days = end.get(Calendar.DATE) - start.get(Calendar.DATE);
            months = 0;
            years = 0;
        } else {
            years = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
            start.add(Calendar.YEAR, years);
            if (start.after(end)) {
                start.add(Calendar.YEAR, -1);
                years--;
            }
            System.out.println("years " + years);

            do {
                months++;
                start.add(Calendar.MONTH, 1);
            } while (start.before(end));
            months--;
            start.add(Calendar.MONTH, -1);
            System.out.println("months " + months);

            System.out.println("days 2 " + days);
            do {
                days++;
                start.add(Calendar.DAY_OF_MONTH, 1);
            } while (start.before(end));
            System.out.println("days 1 " + days);
//			days--;
            start.add(Calendar.DAY_OF_MONTH, -1);
            System.out.println("days 2 " + days);
        }

        object[0] = (Integer) years;
        object[1] = (Integer)months;
        object[2] = (Integer)days;
        return object;
    }



    public static String formatNoPol(String noPol){
        String retVal="";
        for (int i = 0; i < noPol.length(); i++) {
            char c=noPol.charAt(i);
            char before=c;
            if (i>0){
                before=noPol.charAt(i-1);
            }

            if ((c >= 'A' && c <= 'z' && before >= 'A' && before <= 'z') ||
                    (c >= '0' && c <= '9' && before >= '0' && before <= '9')){
                retVal+=c;
            } else {
                retVal+="-"+c;
            }
        }

        return retVal;
    }

    public static String formatNoPolSpacy(String noPol){
        String retVal="";
        for (int i = 0; i < noPol.length(); i++) {
            char c=noPol.charAt(i);
            char before=c;
            if (i>0){
                before=noPol.charAt(i-1);
            }

            if ((c >= 'A' && c <= 'z' && before >= 'A' && before <= 'z') ||
                    (c >= '0' && c <= '9' && before >= '0' && before <= '9')){
                retVal+=c;
            } else {
                retVal+=" "+c;
            }
        }

        return retVal;
    }

    public static String getAlphanumericOnly(String str){
        String retVal="";
        if(str!=null){
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i)>='0' && str.charAt(i)<='9') || (str.charAt(i)>='A' && str.charAt(i)<='Z')
                        || (str.charAt(i)>='a' && str.charAt(i)<='z')){
                    retVal+=str.charAt(i);
                }
            }
        }

        return retVal;
    }

    public static String getAlphanumericOnly2(String str){
        String retVal="";
        if(str!=null){
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '-' || str.charAt(i) == '&' || str.charAt(i) == '*' || str.charAt(i) == '-'
                        || str.charAt(i) == '('|| str.charAt(i) == ')') {
                    retVal+=""+str.charAt(i);
                } else
                if ((str.charAt(i)>='0' && str.charAt(i)<='9') || (str.charAt(i)>='A' && str.charAt(i)<='Z')
                        || (str.charAt(i)>='a' && str.charAt(i)<='z')){
                    retVal+=str.charAt(i);
                }
            }
        }

        return retVal;
    }

    public static String replaceStringForNoBPKB(String str){
        String temp=getAlphanumericOnly(str);
        temp=temp.replace('O', '0');
        temp=temp.replace('I', '1');
        return temp;
    }

    public static String replaceNamaForCompareToKK(String nama){

        String temp=nama;

        try{

            temp=temp.replace(" ","");
            temp=temp.replace(".","");
            temp=temp.replace(",","");
            temp=temp.replace(";","");
            temp=temp.replace("()","");
            temp=temp.replace("[]","");
            temp=temp.replace("<>","");
            temp=temp.replace("'","");
            temp=temp.replace("!","");
            temp=temp.replace("?","");
            temp=temp.replace("-","");
            temp=temp.replace("_","");
            temp=temp.replace("/","");
            temp=temp.replace("dr.","");
            temp=temp.replace("DR.","");
            temp=temp.replace("Drs.","");
            temp=temp.replace("Ir.","");
            temp=temp.replace("Mr.","");
            temp=temp.replace("S.Pt","");
            temp=temp.replace("S.IP","");
            temp=temp.replace("S. E. I.","");
            temp=temp.replace("S.E.","");
            temp=temp.replace("S.Kom","");
            temp=temp.replace("S.K.M.","");
            temp=temp.replace("S.Kep.","");
            temp=temp.replace("S.H.","");
            temp=temp.replace("S. H. I.","");
            temp=temp.replace("S.AB.","");
            temp=temp.replace("S.P.","");
            temp=temp.replace("S.T.","");
            temp=temp.replace("S.T.P.","");
            temp=temp.replace("S.Pd.I.","");
            temp=temp.replace("S.Pd.","");
            temp=temp.replace("S.IK.","");
            temp=temp.replace("S.Psi.","");
            temp=temp.replace("S.I.Kom.","");
            temp=temp.replace("S.Sos.","");
            temp=temp.replace("S.Sy.","");
            temp=temp.replace("Teol.","");
            temp=temp.replace("S.Th.l.","");
            temp=temp.replace("S.Th.","");
            temp=temp.replace("S.Si.","");
            temp=temp.replace("S.S","");
            temp=temp.replace("SST.","");
            temp=temp.replace("S.Farm.","");
            temp=temp.replace("S. Sn","");
            temp=temp.replace("S.AP","");
            temp=temp.replace("S.Mb.","");
            temp=temp.replace("S.Inf.","");
            temp=temp.replace("S.Arl.","");
            temp=temp.replace("S.SArI.","");
            temp=temp.replace("S.AB","");
            temp=temp.replace("S.AP","");
            temp=temp.replace("B.A.","");
            temp=temp.replace("B.Sc.","");
            temp=temp.replace("B.Comp.Sc.","");
            temp=temp.replace("L.L.B.","");
            temp=temp.replace("B.Eng.","");
            temp=temp.replace("S.Ked","");
            temp=temp.replace("M.Cs.","");
            temp=temp.replace("M.Ag.","");
            temp=temp.replace("M.Hut.","");
            temp=temp.replace("M.M.","");
            temp=temp.replace("M.Si.","");
            temp=temp.replace("M.Kom.","");
            temp=temp.replace("M.T.I.","");
            temp=temp.replace("M.Pd.","");
            temp=temp.replace("M.Ak.","");
            temp=temp.replace("M.Sn","");
            temp=temp.replace("M.Farm.","");
            temp=temp.replace("M.Psi.","");
            temp=temp.replace("M.Kn.","");
            temp=temp.replace("M.M.Pd.","");
            temp=temp.replace("M.T.","");
            temp=temp.replace("M.Hum.","");
            temp=temp.replace("M.Stat.","");
            temp=temp.replace("M.Psi.P","");
            temp=temp.replace("M.Psi.T.","");
            temp=temp.replace("M.I.Kom.","");
            temp=temp.replace("M.Inf.","");
            temp=temp.replace("M.SI.","");
            temp=temp.replace("M.TI.","");
            temp=temp.replace("M.Kom.","");
            temp=temp.replace("M.SArI.","");
            temp=temp.replace("M.Arl.","");
            temp=temp.replace("M.AB","");
            temp=temp.replace("M.AP","");
            temp=temp.replace("M.A.","");
            temp=temp.replace("M.Sc.","");
            temp=temp.replace("M.Eng.","");
            temp=temp.replace("M.Eng.Sc.","");
            temp=temp.replace("M.B.A.","");
            temp=temp.replace("M.Th.","");
            temp=temp.replace("Th.M.","");
            temp=temp.replace("L.L.M","");
            temp=temp.replace("M.Pharm.","");
            temp=temp.replace("M.Com.","");
            temp=temp.replace("M.Sport.","");
            temp=temp.replace("M.Mar.","");
            temp=temp.replace("M.Ked","");
            temp=temp.replace("SpAn","");
            temp=temp.replace("SpB","");
            temp=temp.replace("SpPD","");
            temp=temp.replace("SpA","");
            temp=temp.replace("SpOG","");
            temp=temp.replace("SpS","");
            temp=temp.replace("SpKJ","");
            temp=temp.replace("SpM","");
            temp=temp.replace("SpKK","");
            temp=temp.replace("SpTHT-KL","");
            temp=temp.replace("SpJP","");
            temp=temp.replace("SpP","");
            temp=temp.replace("SpRad","");
            temp=temp.replace("SpF","");
            temp=temp.replace("SpPA","");
            temp=temp.replace("SpPK","");
            temp=temp.replace("SpOT","");
            temp=temp.replace("SpU","");
            temp=temp.replace("SpBS","");
            temp=temp.replace("SpRM","");
            temp=temp.replace("SpBP","");
            temp=temp.replace("SpKO","");
            temp=temp.replace("SpMK","");
            temp=temp.replace("SpFK","");
            temp=temp.replace("SpOK","");
            temp=temp.replace("SpBTKV","");
            temp=temp.replace("SpOnkRad","");
            temp=temp.replace("SpKP","");
            temp=temp.replace("SpPark","");
            temp=temp.replace("SpGK","");
            temp=temp.replace("SpAk","");
            temp=temp.replace("DR","");
            temp=temp.replace("M.Phil.","");
            temp=temp.replace("Ph.D.","");
            temp=temp.replace("D.Th.","");
            temp=temp.replace("Ed.D.","");
            temp=temp.replace("PT","");
            temp=temp.replace("PUTU","");
            temp=temp.replace("MD","");
            temp=temp.replace("MADE","");
            temp=temp.replace("NYM ","");
            temp=temp.replace("NYOMAN","");
            temp=temp.replace("KT ","");
            temp=temp.replace("KETUT","");
            temp=temp.replace("GST","");
            temp=temp.replace("GUSTI","");
            temp=temp.replace("IB ","");
            temp=temp.replace("IDA BAGUS","");
            temp=temp.replace("AA ","");
            temp=temp.replace("ANAK ","");
            temp=temp.replace("AGUNG GD","");
            temp=temp.replace("GEDE","");
            temp=temp.replace("NGR ","");
            temp=temp.replace("NGURAH","");
            temp=temp.replace("NGRH","");
            temp=temp.replace("BGS","");
            temp=temp.replace("BAGUS","");
            temp=temp.replace("IDA AYU","");
            temp=temp.replace("GUSTI","");
            temp=temp.replace("DEWA ","");
            temp=temp.replace("IDA BAGUS","");
            temp=temp.replace("DW ","");
            temp=temp.replace("SG ","");

        } catch (Exception e) {
            e.printStackTrace();

        }

        return temp;
    }

    public static String getMonth(String month) {
        String bulan = "";
        if (month == "01") {
            bulan = "I";
        } else if (month.matches("02")) {
            bulan = "II";
        } else if (month.matches("03")) {
            bulan = "III";
        } else if (month.matches("04")) {
            bulan = "IV";
        } else if (month.matches("05")) {
            bulan = "V";
        } else if (month.matches("06")) {
            bulan = "VI";
        } else if (month.matches("07")) {
            bulan = "VII";
        } else if (month.matches("08")) {
            bulan = "VIII";
        } else if (month.matches("09")) {
            bulan = "IX";
        } else if (month.matches("10")) {
            bulan = "X";
        } else if (month.matches("11")) {
            bulan = "XI";
        } else if (month.matches("12")) {
            bulan = "XII";
        }
        return bulan;
    }

    private static int itung(String bulan) {
        if(bulan.equals("01")){
            return 31;
        }else if(bulan.equals("02")){
            return 28;
        }else if(bulan.equals("03")){
            return 31;
        }else if(bulan.equals("04")){
            return 30;
        }else if(bulan.equals("05")){
            return 31;
        }else if(bulan.equals("06")){
            return 30;
        }else if(bulan.equals("07")){
            return 31;
        }else if(bulan.equals("08")){
            return 31;
        }else if(bulan.equals("09")){
            return 30;
        }else if(bulan.equals("10")){
            return 31;
        }else if(bulan.equals("11")){
            return 30;
        }else if(bulan.equals("12")){
            return 31;
        }
        return 0;

    }


    public static int CalculateMonth(Date dateFrom, Date dateUntil){
        System.out.println("INVEST");
        SimpleDateFormat sdfTanggal = new SimpleDateFormat("dd");
        SimpleDateFormat sdfBulan = new SimpleDateFormat("MM");
        SimpleDateFormat sdfTahun = new SimpleDateFormat("yyyy");
        int tahun =0;
        int bulanLama = Integer.valueOf(sdfBulan.format(dateFrom));
        int bulanBaru = Integer.valueOf(sdfBulan.format(dateUntil));
        if(bulanLama > bulanBaru){
            tahun = Integer.valueOf(sdfTahun.format(dateUntil))-Integer.valueOf(sdfTahun.format(dateFrom));
        }else{
            tahun = 1+Integer.valueOf(sdfTahun.format(dateUntil))-Integer.valueOf(sdfTahun.format(dateFrom));
        }
        int resultBulan =0;
        System.out.println(" +++++++++++DATA MENTAH AS PARAMETER ++++++++++++++");
        System.out.println(" Date From        :"+dateFrom);
        System.out.println(" Date Until       :"+dateUntil);
        System.out.println(" Looping sebanyak :"+tahun);
        for (int i = 1; i < tahun; i++) {
            resultBulan = resultBulan + 12;
        }
        Calendar zdate = Calendar.getInstance();
        zdate.setTime(dateFrom);
        zdate.add(Calendar.MONTH, resultBulan);
        Date xc = zdate.getTime();

        int tglFrom = Integer.valueOf(sdfTanggal.format(xc));
        int tglTo = Integer.valueOf(sdfTanggal.format(dateUntil));
        int bulanFrom = Integer.valueOf(sdfBulan.format(xc));
        int bulanTo = Integer.valueOf(sdfBulan.format(dateUntil));

        //KALO BULAN FROM LEBIH BESAR DARI BULAN UNTIL
        if(bulanFrom > bulanTo){
            int movebulan = (12+bulanTo) - bulanFrom;
            System.out.println("Move Bulan :"+movebulan);
            System.out.println("Start      :"+zdate.getTime());
            if(tglFrom>tglTo){
                for (int i = 1; i < movebulan; i++) {
                    zdate.add(Calendar.MONTH, 1);
                }
            }else{
                for (int i = 1; i <= movebulan; i++) {
                    zdate.add(Calendar.MONTH, 1);
                }
            }
            System.out.println(" TEMP      :"+zdate.getTime());
            String tempBulan = sdfBulan.format(zdate.getTime());
            int tempTanggal = Integer.valueOf(sdfTanggal.format(zdate.getTime()));
            int temdays = (itung(tempBulan))-tempTanggal + tglTo ;
            if(temdays > itung(tempBulan)){
                temdays = temdays - itung(tempBulan);
            }
            System.out.println(" DAYS ACCURATE :"+temdays);
            if(temdays>15){
                if(movebulan<=1){
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan+movebulan;
                    }else{
                        resultBulan = resultBulan+movebulan+1;
                    }
                }else{
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan+movebulan;
                    }else{
                        resultBulan = resultBulan+movebulan+1;
                    }
                }
            }else{
                if(movebulan<=1){
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan;
                    }else{
                        resultBulan = resultBulan+1;
                    }
                }else{
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan+movebulan-1;
                    }else{
                        resultBulan = resultBulan+movebulan;
                    }
                }

            }
        }else{
            // jika bulan from lebih kecil
            System.out.println(" BULAN FROM LEBIH KECIL DARI BULAN UNTIL");
            int movebulan = bulanTo - bulanFrom;
            System.out.println("Move Bulan :"+movebulan);
            System.out.println("Start :"+zdate.getTime());
            if(tglFrom>tglTo){
                for (int i = 1; i < movebulan; i++) {
                    zdate.add(Calendar.MONTH, 1);
                }
            }else{
                for (int i = 1; i <= movebulan; i++) {
                    zdate.add(Calendar.MONTH, 1);
                }
            }
            System.out.println(" TEMP :"+zdate.getTime());
            String tempBulan = sdfBulan.format(zdate.getTime());
            int tempTanggal = Integer.valueOf(sdfTanggal.format(zdate.getTime()));
            int temdays = (itung(tempBulan))-tempTanggal + tglTo ;
            if(temdays > itung(tempBulan)){
                temdays = temdays - itung(tempBulan);
            }
            System.out.println(" DAYS ACCURATE :"+temdays);
            if(temdays>15){
                if(movebulan<=1){
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan+movebulan;
                    }else{
                        resultBulan = resultBulan+movebulan+1;
                    }
                }else{
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan+movebulan;
                    }else{
                        resultBulan = resultBulan+movebulan+1;
                    }
                }
            }else{
                if(movebulan<=1){
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan;
                    }else{
                        resultBulan = resultBulan+1;
                    }
                }else{
                    if(tglFrom>tglTo){
                        resultBulan = resultBulan+movebulan-1;
                    }else{
                        resultBulan = resultBulan+movebulan;
                    }
                }
            }
        }
        return resultBulan;
    }

    public static String getNamaBulan(Date date){
        String result = new String();
        String bulan = new SimpleDateFormat("MM").format(date);

        if(bulan.equals("01"))return "JANUARI";
        else if(bulan.equals("02"))return "FEBRUARI";
        else if(bulan.equals("03"))return "MARET";
        else if(bulan.equals("04"))return "APRIL";
        else if(bulan.equals("05"))return "MEI";
        else if(bulan.equals("06"))return "JUNI";
        else if(bulan.equals("07"))return "JULI";
        else if(bulan.equals("08"))return "AGUSTUS";
        else if(bulan.equals("09"))return "SEPTEMBER";
        else if(bulan.equals("10"))return "OKTOBER";
        else if(bulan.equals("11"))return "NOVEMBER";
        else if(bulan.equals("12"))return "DESEMBER";


        return result;
    }
}
