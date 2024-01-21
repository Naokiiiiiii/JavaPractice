package src.section11.datastore;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    record Person(String firstName, String lastName, Long id) {}
    private List<T> records = new ArrayList<>();

    List<T> findAll() {
        return records;
    }

    T save(T record) {
        records.add(record);
        return record;
    }

    T findByID(long id) {
        return records.get(Long.valueOf(id).intValue());
    }

    public static void main(String[] args) {
        Repository<String> repo = new Repository<>();
        repo.save("house");
        repo.save("tree");
        repo.save("boat");

        Repository<Person> pRepo = new Repository<>();
        pRepo.save(new Person("Fred", "Flinstone", 1L));
        pRepo.save(new Person("Mary", "Johnson", 2L));

        System.out.println(repo.findAll());
        System.out.println(pRepo.findAll());
    }
}
