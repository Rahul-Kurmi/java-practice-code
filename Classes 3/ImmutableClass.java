import java.util.ArrayList;
import java.util.List;

final class MyImmutableClass {

    // Making data members private means they cannot be directly
    // accessed from outside the class.
    //
    // Making them final means their references cannot be reassigned
    // after they are initialized.
    private final String name;
    private final List<Object> petNameList;


    // Constructor is used to initialize the values.
    //
    // There are no setter methods because once the object is created,
    // we don't want its state to be changed.
    MyImmutableClass(String name, List<Object> petNameList) {

        this.name = name;
        this.petNameList = petNameList;
    }


    public String getName() {
        return name;
    }


    public List<Object> getPetNameList() {

        // We should NOT return the original list reference.
        //
        // If we return:
        //
        // return petNameList;
        //
        // then the caller would receive the reference to the
        // original list.
        //
        // Since the List is mutable, the caller could then do:
        //
        // obj.getPetNameList().add("hello");
        //
        // and modify the internal list of our object.
        //
        // Therefore, we return a COPY of the list.
        return new ArrayList<>(petNameList);
    }
}


public class ImmutableClass {

    public static void main(String[] args) {

        // Create the original list outside the immutable object.
        List<Object> petNames = new ArrayList<>();

        petNames.add("sj");
        petNames.add("pj");


        // Create the immutable object.
        MyImmutableClass obj = new MyImmutableClass("myName", petNames);


        // --------------------------------------------------
        // TEST 1: Modify the original list
        // --------------------------------------------------

        petNames.add("hello");

        // Since the original list and the internal list refer
        // to the SAME List object, this modification WILL affect
        // the list inside obj.
        System.out.println(obj.getPetNameList());

        // Output:
        // [sj, pj, hello]


        // --------------------------------------------------
        // TEST 2: Modify the list returned by getter
        // --------------------------------------------------

        obj.getPetNameList().add("java");

        // getPetNameList() returns a COPY of the internal list.
        //
        // Therefore, adding "java" modifies only the returned copy,
        // NOT the internal list inside obj.
        System.out.println(obj.getPetNameList());

        // Output:
        // [sj, pj, hello]
    }
}