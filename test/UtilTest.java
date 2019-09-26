

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.everest.cricket.utility.Util;

public class UtilTest {
	@InjectMocks
	Util util;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetRandomScore() {
		int scores[] = { 0, 1, 2, 3, 4, 5, 6, -1 };
		int probabilities[] = { 5, 30, 25, 10, 15, 1, 9, 5 };
		int score = util.getRandomScore(scores, probabilities);
		// converting array to list
		List<Integer> list = Arrays.stream(scores).boxed().collect(Collectors.toList());
		assertNotNull(score);
		assertTrue(list.contains(score));

	}

}
