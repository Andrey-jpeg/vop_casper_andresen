package vop;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RecursiveBinarySearchTest {

    private static final int[] FIBOS
            = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    public RecursiveBinarySearchTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldFindIndexOfNumber() {
        // Our version:
        assertEquals(3, RecursiveBinarySearch.recursiveFind(FIBOS, 3));
        assertEquals(9, RecursiveBinarySearch.recursiveFind(FIBOS, 55));

        // JDK version:
        assertEquals(3, Arrays.binarySearch(FIBOS, 3));
        assertEquals(9, Arrays.binarySearch(FIBOS, 55));
    }

    @Test
    public void shouldReturnNegativeInsertionPointWhenNotFound() {
        // Our version:
        assertEquals(-1, RecursiveBinarySearch.recursiveFind(FIBOS, 0));
        assertEquals(-5, RecursiveBinarySearch.recursiveFind(FIBOS, 4));

        // JDK version:
        assertEquals(-1, Arrays.binarySearch(FIBOS, 0));
        assertEquals(-5, Arrays.binarySearch(FIBOS, 4));
    }
}