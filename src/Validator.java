public class Validator {
    public boolean isValid(String name){
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i)>='0'&&name.charAt(i)<='9')
                return false;
        }
       return name.length()>2&&name.length()<=20;
    }
    public boolean isValid(int age){
        return age>1&&age<120;
    }

}
