package practise;

import java.util.HashMap;

public class practise1 {

    static class Employee{
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashMap<String, Employee> map = new HashMap<>();
        map.put("nitin", new Employee(1, "nitin"));
        map.put("abhi", new Employee(2, "abhi"));

        HashMap<String, Employee> map2 = new HashMap<>(map);

        System.out.println(map.get("nitin"));
        //map.get("nitin").setName("Nitin Singh");
        map.put("nitin", new Employee(1, "Nitinkumar"));
        System.out.println(map.get("nitin")+ "-----"+ map2.get("nitin"));

    }
}
