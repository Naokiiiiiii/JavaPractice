package src.section8.Employees.java;

public interface Chef {

    String favoriteFood = "pizza";

    default void cook(String food) {
        System.out.println("I'm cooking " + food);
    }

    default String cleanUp() {
        return "I'm done cleaning up";
    }

    default String getFavoriteFood() {
        return favoriteFood;
    }
}
