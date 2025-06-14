package aquarium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AquariumTests {

    private Aquarium aquarium;
    private Fish fish;

    @BeforeEach
    void setUp(){
        aquarium = new Aquarium("aquarium", "fresh");
        fish = new Fish("Beta", "fresh", 10, false);
    }

//    CONSTRUCTOR

    @Test
    public void testConstructor_Should_Throw_When_Name_Null (){
        assertThrows(NullPointerException.class,
                () -> new Aquarium(null, "fresh"));
    }

    @Test
    public void testConstructor_Should_Throw_When_Name_Empty (){
        assertThrows(NullPointerException.class,
                () -> new Aquarium("", "fresh"));
    }

    @Test
    public void testConstructor_Should_Throw_When_Name_WhiteSpace (){
        assertThrows(NullPointerException.class,
                () -> new Aquarium("   ", "fresh"));

    }

//    @Test
//    void testConstructor_Should_Create_Correct_Object() {
//        Aquarium aquarium = new Aquarium("aquarium", "fresh");
//        assertEquals("aquarium", aquarium.getName());
//        assertEquals(0, aquarium.getCount());
//    }


//    ADD FISH

    @Test
    void testAddFish_Should_Throw_When_Not_Compatible() {
        assertThrows(IllegalArgumentException.class,
                () -> aquarium.addFish(new Fish("Nemo", "saltwater", 100, false)));
    }

    @Test
    void testAddFish_Should_Throw_When_Fish_Exists() {
        aquarium.addFish(fish);
        assertThrows(IllegalArgumentException.class,
                () -> aquarium.addFish(fish));
    }

    @Test
    void testAddFish_Add_Fish_Successfully() {
        aquarium.addFish(fish);
        assertEquals(1, aquarium.getCount());
    }

//    REMOVE FISH

    @Test
    void testRemoveFish_Removes_Fish_Successfully() {
        aquarium.addFish(fish);
        aquarium.removeFish(fish.getName());
        assertEquals(0, aquarium.getCount());
    }



}
