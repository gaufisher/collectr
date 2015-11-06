package com.catalyst.collector.daos.hibernate;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import javax.persistence.EntityManager;

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.Collectible;
import org.junit.Before;
import javax.persistence.TypedQuery;
import org.junit.Test;

import com.catalyst.collector.entities.*;

public class CollectionsDaoHibernateTest {
	CollectionsDaoHibernate collectionsDaoHibernate = new CollectionsDaoHibernate();
	EntityManager mockEm = mock(EntityManager.class);
	private CollectionsDaoHibernate target;

	@Before
	public void setup() {
		target = new CollectionsDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testGetCollection(){
		ArrayList<Collectible> expected = new ArrayList<Collectible>();
		TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Collectible.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Collectible> result = collectionsDaoHibernate.getCollectibles();
		assertEquals(expected, result);
	}

	/*
	 * Category Dao Tests
	 */
	@Test
	public void happyPathGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		collectionsDaoHibernate.getCategory();

		verify(mockTypedQuery, times(1)).getResultList();
	}
	@Test
	public void happyPathAddCategory(){
		Category sample = new Category();

		target.addCategory(sample);

		verify(mockEm, times(1)).persist(sample);
	}

	@Test(expected=Exception.class)
	public void testAddCategoryNoName(){
		Category sample = new Category();
		doThrow(new Exception()).when(mockEm).persist(sample);
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addCategory(sample);
		assertFalse(result);
	}

	@Test(expected=Exception.class)
	public void testUpdateCategoryTooLong(){
		Category sample = new Category();
		sample.setName("I am far too long to be a valid name. Well over 255 characters. I'm just going to keep typing until I reach that amount of characters. Wow this is taking a while. How do typists do this every day without getting blisters? Boy I could go for some pizza right now. Okay this has got to be 256 characters by now, right? I will assume that it is because I'm mocking the results anyway.");
		doThrow(new Exception()).when(mockEm).merge(sample);
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void happyPathUpdateCategory(){
		Category sample = new Category();
		sample.setId(1);
		target.updateCategory(sample);
		verify(mockEm, times(1)).merge(sample);
	}
	@Test
	public void happyPathGetByCategoryId(){

		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);

		target.getByCategoryId(0);

		verify(mockTypedQuery, times(1)).setParameter(eq("ID"), eq(0));
	}
	@Test
	public void happyPathDeleteCategory(){
		Category sample = new Category();
		sample.setId(5);

		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		Category cat = collectionsDaoHibernate.getByCategoryId(0);
		boolean result = collectionsDaoHibernate.deleteCategory(0);
		assertTrue(result);
	}
	
	@Test(expected=Exception.class)
	public void testDeleteCategoryInvalidId(){
		Category sample = new Category();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		doThrow(new Exception()).when(mockEm).remove(sample);

		collectionsDaoHibernate.setEm(mockEm);
		Category cat = collectionsDaoHibernate.getByCategoryId(0);
		boolean result = collectionsDaoHibernate.deleteCategory(0);
		assertFalse(result);

		target.deleteCategory(5);
		verify(mockEm, times(1)).remove(sample);
		verify(mockTypedQuery, times(1)).setParameter(eq("ID"), eq(5));
	}



	@Test
	public void happyAddAgeToDatabase(){
		Age test = new Age();
		test.setAge_id(1);
		test.setAge("Antique");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addAge(test);
		assertTrue(result);
	}

	@Test
	public void sadAddAgeWithNumbersToDatabase(){
		Age test = new Age();
		test.setAge_id(1);
		test.setAge("2");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addAge(test);
		assertFalse(result);
	}

	@Test
	public void sadAddAgeWithTooManyCharactersToDatabase(){
		Age test = new Age();
		test.setAge_id(1);
		test.setAge("this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addAge(test);
		assertFalse(result);
	}

    @Test
    public void testGetAllKeywordsHappyPathMakesADBCall() throws Exception {
        ArrayList<Keyword> testList = new ArrayList<>();
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(testList);
        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Keyword> result = collectionsDaoHibernate.getAllKeywords();
        assertEquals(testList, result);
    }

    @Test
    public void testGetKeywordsByLetterHappyPathMakesADBCall() throws Exception {
        ArrayList<Keyword> testList = new ArrayList<>();
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), anyChar())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(testList);
        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Keyword> result = collectionsDaoHibernate.getKeywordsByLetter('c');
        assertEquals(testList, result);
    }

    @Test
    public void testAddKeywordHappyPathMakesADBCall() throws Exception {
        target.addKeyword(null);

        //We have nothing we can assert. So use verify to check how many times a dependency's method was called.
        verify(mockEm, times(1)).persist(null);
    }

    @Test
    public void testUpdateKeywordHappyPathMakesADBCall() throws Exception {
        Keyword expected = new Keyword();
        expected.setId(1);

        target.updateKeyword(expected);

        verify(mockEm, times(1)).merge(expected);
    }

    @Test
    public void testRemoveKeywordHappyPathMakesADBCall() throws Exception {
        Keyword keywordToDelete = new Keyword();
        keywordToDelete.setId(5);

        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);

        when(mockEm.createQuery(anyString(), eq(Keyword.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getSingleResult()).thenReturn(keywordToDelete);

        target.removeKeyword(5);


        verify(mockEm, times(1)).remove(keywordToDelete);
        verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
    }

    @Test
    public void testGetAllConditionsHappyPathMakesADBCall() throws Exception {
        ArrayList<Condition> testList = new ArrayList<>();
        TypedQuery<Condition> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Condition.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(testList);
        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Condition> result = collectionsDaoHibernate.getAllConditions();
        assertEquals(testList, result);
    }

    @Test
    public void testAddConditionHappyPathMakesADBCall() throws Exception {
        target.addCondition(null);

        //We have nothing we can assert. So use verify to check how many times a dependency's method was called.
        verify(mockEm, times(1)).persist(null);
    }

    @Test
    public void testUpdateConditionHappyPathMakesADBCall() throws Exception {
        Condition expected = new Condition();
        expected.setId(1);

        target.updateCondition(expected);

        verify(mockEm, times(1)).merge(expected);
    }

    @Test
    public void testDeleteConditionHappyPathMakesADBCall() throws Exception {
        Condition condition = new Condition();
        condition.setId(5);

        TypedQuery<Condition> mockTypedQuery = mock(TypedQuery.class);

        when(mockEm.createQuery(anyString(), eq(Condition.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getSingleResult()).thenReturn(condition);

        target.deleteCondition(5);


        verify(mockEm, times(1)).remove(condition);
        verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
    }

/*	@Test
	public void happyGetAgeTypesFromDatabase(){
		ArrayList<Age> sample = new ArrayList<Age>();
		TypedQuery<Age> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Age> result = collectionsDaoHibernate.getAgeTypes();
		assertEquals(sample, result);
	}*/




}
