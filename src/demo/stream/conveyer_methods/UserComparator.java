package demo.stream.conveyer_methods;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().length() > o2.getName().length()? 1:-1;
    }
}
