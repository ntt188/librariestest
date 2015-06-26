package fr.tungnguyen.hamcrest;

import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.startsWith;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FirstTest {

    @Test
    public void testList() {
        List<Long> expected = asList(1L, 2L, 4L);
        List<Long> actual = asList(1L, 2L, 4L);
        assertThat(actual, equalTo(expected));
        assertThat(actual, is(expected));
        assertThat(actual, is(equalTo(expected)));

        assertThat(Collections.emptyList(), is(empty()));

        assertThat(actual, hasItem(1L));
        assertThat(actual, not(hasItem(3L)));
        assertThat(actual, hasItems(1L, 2L));
        assertThat(actual, contains(1L, 2L, 4L));
        assertThat(actual, containsInAnyOrder(2L, 4L, 1L));
        assertThat(actual, hasSize(3));

        assertThat(actual, sameInstance(actual));
        assertThat(actual, not(sameInstance(expected)));
    }

    @Test
    public void testMap() {
        Map<String, Double> mapPrix = new HashMap<String, Double>();
        mapPrix.put("salade", 1.0);
        mapPrix.put("pêche", 2.5);

        assertThat(mapPrix, hasKey("salade"));
        assertThat(mapPrix, not(hasKey("nectarine")));

        assertThat(mapPrix, hasValue(1.0));
        assertThat(mapPrix, not(hasValue(2.4)));
    }

    @Test
    public void testBoolean() {
        Boolean b = TRUE;
        assertThat(b, is(TRUE));

        b = !b;
        assertThat(b, is(not(TRUE)));
        assertThat(b, is(not(TRUE)));
        assertThat(b, is(instanceOf(Boolean.class)));
    }

    @Test
    public void testNumber() {
        Double montant = 40.0 - 1.0;
        assertThat(montant, is(equalTo(39.0)));
        assertThat(montant, is(greaterThan(38.5)));
        assertThat(montant, is(lessThan(40.0)));
    }

    @Test
    public void testString() {
        String str = null;
        assertThat(str, is(nullValue()));
        assertThat(str, isEmptyOrNullString());

        str = "";
        assertThat(str, isEmptyString());
        assertThat(str, isEmptyOrNullString());

        str = "abc";
        assertThat(str, is(equalTo("abc")));
        assertThat(str, is(startsWith("ab")));
        assertThat(str, is(endsWith("bc")));
    }
}
