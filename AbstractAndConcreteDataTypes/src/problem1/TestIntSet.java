package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntSet {

	@Test
	public void test1() {
		IntSet set = new IntSet(new int[] { 3, 4, 5, 9, 8, 8, 7, 10 });
		int[] complimentArray = set.getComplement();
		// assumed that universal set if set of integers from 1 to 20
		assertArrayEquals(new int[] { 1, 2, 6, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }, complimentArray);

	}

	@Test
	public void testmember() {
		IntSet set = new IntSet(new int[] { 5, 9, 8, 8, 7, 10 });
		boolean member = set.isMember(10);
		assertEquals(true, member);
	}

	@Test
	public void testmember1() {
		IntSet set = new IntSet(new int[] { 5, 9, 8, 8, 7, 10, 56, 58 });
		boolean member = set.isMember(24);
		assertEquals(false, member);
	}

	@Test
	public void testUnion() {
		IntSet set1 = new IntSet(new int[] { 5, 9, 15 });
		IntSet set2 = new IntSet(new int[] { 5, 9, 8, 8, 7, 10, 56, 58 });
		int[] union = set1.union(set2);
		assertArrayEquals(new int[] { 5, 7, 8, 9, 10, 15, 56, 58 }, union);
	}

	@Test
	public void testUnion1() {
		IntSet set1 = new IntSet(new int[] { 2, 3, 4 });
		IntSet set2 = new IntSet(new int[] { 5, 9, 8 });
		int[] union = set1.union(set2);
		assertArrayEquals(new int[] { 2, 3, 4 , 5 , 8, 9 }, union);
	}

	@Test
	public void testIsSubset() {
		IntSet set1 = new IntSet(new int[] { 5, 9, 15 });
		IntSet set2 = new IntSet(new int[] { 5, 9, 8, 8, 7, 10, 56, 58 });
		boolean isSubset = set1.isSubSet(set2);
		assertEquals(false, isSubset);
	}

	@Test
	public void testIsSubset1() {
		IntSet set1 = new IntSet(new int[] { 5, 9 });
		IntSet set2 = new IntSet(new int[] { 5, 9, 8, 8, 7, 10, 56, 58 });
		boolean isSubset = set1.isSubSet(set2);
		assertEquals(true, isSubset);
	}

	@Test
	public void testIsSubset2() {
		IntSet set1 = new IntSet(new int[] {});// if first set is empty
		IntSet set2 = new IntSet(new int[] { 5, 9, 8, 8, 7, 10, 56, 58 });
		boolean isSubset = set1.isSubSet(set2);
		assertEquals(true, isSubset);
	}

}
