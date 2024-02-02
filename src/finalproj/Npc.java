package finalproj;

public class Npc {
    private String name;
    private int age;

    public String getName(String name){
       return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge (int age){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public static void main (String [] args){
        Npc npc = new Npc();
        npc.setAge(25);
        npc.setName("Chuck");
        System.out.println(npc.age);
        System.out.println(npc.name);
    }
}
