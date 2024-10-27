public class Checker {

    public static boolean checkAnimal (String[] a){
        if (a[0].equals("Animal") && a[1].equals("species")
                && a[3].equals("eyeColor") && a[5].equals("hasHair")){
            if (checkName(a[2]) && checkName(a[4])
                    && (a[6].equals("true") || a[6].equals("false"))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkBarrel (String[] b){
        if (b[0].equals("Barrel") && b[1].equals("volume")
                && b[3].equals("storedMaterial") && b[5].equals("ownMaterial")){
            if (checkName(b[4]) && checkName(b[6])) {
                try {
                    if (Integer.parseInt(b[2]) >= 0){
                        return true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e){
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkPerson (String[] p){
        if (p[0].equals("Person") && p[1].equals("gender")
                && p[3].equals("age") && p[5].equals("surname")){
            if (checkName(p[2]) && checkName(p[6])) {
                try {
                    if (Integer.parseInt(p[4]) >= 0 && Integer.parseInt(p[4]) <= 150){
                        return true;
                    } else {
                        return false;
                    }
                } catch (NumberFormatException e){
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean checkName (String s){
        for (Character c : s.toCharArray()){
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
