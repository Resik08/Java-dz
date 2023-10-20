import java.util.*;

public class Main {
    public static void main(String[] args) {
        addContacts("Пользователь 1", "123-556-445");
        addContacts("Пользователь 2", "984-113-789");
        addContacts("Пользователь 3", "555-632-789");
        addContacts("Пользователь 1", "365-897-316");
        addContacts("Пользователь 4", "777-444-888");
        addContacts("Пользователь 4", "788-455-788");
        addContacts("Пользователь 1", "111-454-646");

        printContacts();
    }
   private static final HashMap<String, ArrayList> contacts = new HashMap<>();

   public static void addContacts(String name, String number) {
       if(contacts.containsKey(name)) {
           ArrayList PhoneNumbers = contacts.get(name);
           PhoneNumbers.add(number);
           contacts.put(name, PhoneNumbers);
       }
       else {
           ArrayList PhoneNumbers = new ArrayList();
           PhoneNumbers.add(number);
           contacts.put(name, PhoneNumbers);
       }
   }
   public static void printContacts() {
       ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(contacts.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
           @Override
           public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
               return o2.getValue().size() - o1.getValue().size();
           }
       });
       for (Map.Entry<String, ArrayList> entry: list) {
           System.out.println(entry.getKey() + " : " + entry.getValue());
       }
   }

}