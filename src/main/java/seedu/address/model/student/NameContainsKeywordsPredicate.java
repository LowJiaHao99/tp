package seedu.address.model.student;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Student}'s {@code Name} matches all the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<Student> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Student student) {
        String keys = String.join(" ", keywords);
        String name = student.getName().fullName;
        return StringUtil.containsPartialSentenceIgnoreCase(name, keys);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
