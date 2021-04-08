//has many-belongs to 
import java.util.*;

class Main {
  public static void main(String[] args) {
    
    Dog uno = new Dog("Uno","Uno's Bark");
    Dog dos = new Dog("Dos","Dos's Bark");

    Owner abdul = new Owner("Abdul");
    abdul.adopt("Uno"); 

    Owner ali = new Owner("Ali");
    ali.adopt("Dos");

    Dog.all();

    System.out.println("--------------");
    // ali.dogs();

    dos.owner();
    uno.owner();

  }
}


class Owner {

  public String name;
  static int e_id;

  static ArrayList<String[]> ownerArr = new ArrayList<String[]>();

  public Owner(String name){
    this.name = name;
    this.e_id += 1;

    String e_id_num = String.valueOf(this.e_id);

    String[] ownerObj = {e_id_num, this.name};

    ownerArr.add(ownerObj);
  }

  public void intro(){
    System.out.println("Hi my name is " + this.name);
    System.out.println("id: " + this.e_id);
  }

  public void adopt(String dogName){
    for(int i = 0; i < Dog.arrli.size(); i++){
      if(dogName.equals(Dog.arrli.get(i)[1])){
        String e_id_num = String.valueOf(this.e_id);
        Dog.arrli.get(i)[3] = e_id_num;
       
        System.out.println(dogName + " Adopted");
        break;
      }
      
    }
    //System.out.println( dogName + " adopted and now belongs to " + this.name);
  }


  public void release(String dogName){
      for(int i = 0; i < Dog.arrli.size(); i++){
        if(dogName.equals(Dog.arrli.get(i)[1])){
          String e_id_num = String.valueOf(this.e_id);
          System.out.println("eid:  " + e_id_num);
          Dog.arrli.get(i)[3] = "0";
        
          System.out.println(dogName + " Released");
          break;
        }
      }
      //System.out.println( dogName + " adopted and now belongs to " + this.name);
    }

    public void dogs(){
      System.out.println("List of " + this.name +"'s dogs");
      String e_id_num = String.valueOf(this.e_id);

      ArrayList<String[]> owners_dog_li = new ArrayList<String[]>();

      for(int i = 0; i < Dog.arrli.size(); i++){
        if(e_id_num.equals(Dog.arrli.get(i)[3])){
          owners_dog_li.add(Dog.arrli.get(i));
        }
      }

      for(int i = 0; i < owners_dog_li.size(); i++ ){
        System.out.println(owners_dog_li.get(i)[1]);
      }

      // System.out.println(owners_dog_li);

    }
  }

class Dog {

  public String bark;
  String name;
  static int dog_id; 
  public int owner_id;

  static ArrayList<String[]> arrli = new ArrayList<String[]>();

  public Dog(String name, String sound){
    this.dog_id += 1;
    this.name = name;
    this.bark = sound;
    this.owner_id= 0;

    // System.out.println("id: " + this.dog_id + " " + "name: " + this.name);
    // System.out.println("++++++++++++++++++++++++++");

    String dog_id_num = String.valueOf(this.dog_id);
    String owner_id_num = String.valueOf(this.owner_id);

    String dog_array[] = {dog_id_num, this.name, this.bark, owner_id_num};

    arrli.add(dog_array);
  }
  
  public void bark() {
    System.out.println(bark);
  }

  public static void all(){
    System.out.println("inside hashtable");
  
    for(int i= 0; i < arrli.size(); i++){
      System.out.println("id: " + arrli.get(i)[0] + " | " + "name: " + arrli.get(i)[1] +" | " + "bark: " + arrli.get(i)[2] + " | " + "Owner " + arrli.get(i)[3]);
    }
  }

  public void owner(){
    System.out.println("List of " + this.name + " 's owners.'");

    
    for(int i = 0; i < Owner.ownerArr.size(); i++){
      if(arrli.get(this.dog_id-1)[3].equals(Owner.ownerArr.get(i)[0])){
        System.out.println("true");
        System.out.println(Owner.ownerArr.get(i)[1]);
        continue;
      }else {
        continue;
      }
      } 
    }


  
}