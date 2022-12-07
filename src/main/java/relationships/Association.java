package relationships;

public class Association {

    public static void main(String[] args) {
        // association
        /*
        Citizen citizen = new Citizen("Jumabekova Baxtigul", 22);
        IdentityCard identityCard = new IdentityCard("AB", "1889090");
        String fullInfo = " Full name : %s%n age : %d%n identity info : %s%s%n "
                .formatted(citizen.getFullName(), citizen.getAge(), identityCard.getSerial(), identityCard.getNumber());
        System.out.println( fullInfo);*/
        // aggregation
/*
        IdentityCard identityCard = new IdentityCard("AB", "1889090");
        Citizen citizen = new Citizen("Jumabekova Baxtigul", 22, identityCard);

        String fullInfo = " Full name : %s%n age : %d%n identity info : %s%s%n "
                .formatted(citizen.getFullName(), citizen.getAge(), citizen.getSerial(), citizen.getNumber());
        System.out.println(fullInfo);*/

        // composition
        Car car = new Car("Subaro", "slodiugheri87yt938ut543o8678054yulhjg");

    }

}

class Citizen {
    private String fullName;
    private int age;

    private IdentityCard identityCard;

    public Citizen(String fullName, int age, IdentityCard identityCard) {
        this.fullName = fullName;
        this.age = age;
        this.identityCard = identityCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSerial() {
        return identityCard.getSerial();
    }


    public String getNumber() {
        return identityCard.getNumber();
    }
}

class IdentityCard {
    private String serial;
    private String number;

    public IdentityCard(String serial, String number) {
        this.serial = serial;
        this.number = number;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

class Car {
    private String maker;
    private final Engine engine;

    public Car(String maker, String serialNumber) {
        this.maker = maker;
        this.engine = new Engine(serialNumber);
    }

    private class Engine {
        private final String serialNumber;

        private Engine(String serialNumber) {
            this.serialNumber = serialNumber;
        }
    }

}

