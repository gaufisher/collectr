package com.catalyst.collector.services.impl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;
import org.junit.Before;
import com.catalyst.collector.entities.Age;
import org.junit.Test;
import com.catalyst.collector.daos.hibernate.CollectionsDaoHibernate;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Color;
public class CollectionsServiceImplTest {

    CollectionsServiceImpl collectionsServiceImpl = new CollectionsServiceImpl();
    CollectionsDaoHibernate mockCollectionsDao = mock(CollectionsDaoHibernate.class);

    @Before
    public void setup() {
        collectionsServiceImpl = new CollectionsServiceImpl();
        mockCollectionsDao = mock(CollectionsDaoHibernate.class);
        collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
    }

	private CollectionsServiceImpl collectionsServiceImpl;
	CollectionsDaoHibernate mockCollectionsDao = mock(CollectionsDaoHibernate.class);

	@Before
	public void setup(){
		collectionsServiceImpl = new CollectionsServiceImpl();
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
	}


	@Test
	public void testGetColor() {
		Color sample = new Color();
		when(mockCollectionsDao.getColor(1)).thenReturn(sample);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		Color result = mockCollectionsDao.getColor(1);
		assertEquals(sample, result);
	}
	@Test
	public void testAddColor(){
		Color sample = new Color();
		sample.setColor("rojo");
		when(mockCollectionsDao.addColor(sample)).thenReturn(true);

		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addColor(sample);
		assertTrue(result);
	}
	@Test
	public void testAddColor_nullName(){

		Color sample = new Color();

		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addColor(sample);
		assertFalse(result);
	}
	@Test
	public void testAddColor_blankName(){
		Color sample = new Color();
		sample.setColor("  ");

		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addColor(sample);
		assertFalse(result);
	}
	@Test
	public void testAddColor_longName(){
		Color sample = new Color();
		sample.setColor("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way� in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");

		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addColor(sample);
		assertFalse(result);
	}
	@Test
	public void testAddColor_noName(){
		Color sample = new Color();
		when(mockCollectionsDao.addColor(sample)).thenReturn(false);

		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addColor(sample);
		assertFalse(result);
	}
	@Test
	public void testUpdateColor(){
		Color sample = new Color();
		sample.setId(1);
		sample.setColor("verde");
		when(mockCollectionsDao.updateColor(sample)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateColor(sample);
		assertTrue(result);
	}
	@Test
	public void testUpdateColor_nullColor(){
		Color sample = new Color();
		sample.setId(1);
		when(mockCollectionsDao.updateColor(sample)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateColor(sample);
		assertFalse(result);
	}
	@Test
	public void testUpdateColor_emptyColor(){
		Color sample = new Color();
		sample.setId(1);
		sample.setColor("    ");
		when(mockCollectionsDao.updateColor(sample)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateColor(sample);
		assertFalse(result);
	}
	@Test
	public void testUpdateColor_longColor(){
		Color sample = new Color();
		sample.setId(1);
		sample.setColor("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way� in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");
		when(mockCollectionsDao.updateColor(sample)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateColor(sample);
		assertFalse(result);
	}
	@Test
	public void testRemoveColor(){
		when(mockCollectionsDao.removeColor(0)).thenReturn(true);

		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.removeColor(0);
		assertTrue(result);
	}
	@Test
	public void HappyPathGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockCollectionsDao.getCategory()).thenReturn(sample);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		ArrayList<Category> result = collectionsServiceImpl.getCategory();
		assertEquals(sample, result);			
	}
	@Test
	public void HappyPathAddCategory(){
		Category sample = new Category();
		sample.setCategory("Books");
		when(mockCollectionsDao.addCategory(sample)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertTrue(result);
	}
	


	@Test
	public void SadPathAddCategoryNameIsNull(){
		Category sample = new Category();
		
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	

	@Test
	public void SadPathAddCategoryNameIsBlank(){
		Category sample = new Category();
		sample.setName("  ");

		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathAddCategoryNameIsTooLong(){
		Category sample = new Category();
		sample.setName("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way� in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");

		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathAddCategoryNameContainsDigits(){
		Category sample = new Category();
		sample.setCategory("Comi5s");

		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}

	@Test
	public void SadPathAddCategoryIdIsLessThan1(){
		Category sample = new Category();
		sample.setId(0);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}

	@Test
	public void HappyPathUpdateCategory(){
		Category sample = new Category();
		sample.setId(1);
		sample.setCategory("Books");
		when(mockCollectionsDao.updateCategory(sample)).thenReturn(true);
		
		boolean result = collectionsServiceImpl.updateCategory(1, sample);
		assertTrue(result);
	}
	
	@Test
	public void SadPathUpdateCategoryNameIsNull(){

		Category sample = new Category();
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		sample.setId(1);
		boolean result = collectionsServiceImpl.updateCategory(1, sample);

		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathUpdateCategoryNameIsBlank(){
		Category sample = new Category();
		sample.setId(1);
		sample.setCategory("  ");
		boolean result = collectionsServiceImpl.updateCategory(1, sample);
		assertFalse(result);
	}

	@Test
	public void SadPathUpdateCategoryNameContainsDigits(){
		Category sample = new Category();
		sample.setId(1);
		sample.setCategory("Comi5s");
		boolean result = collectionsServiceImpl.updateCategory(1, sample);
		assertFalse(result);
	}

	@Test
	public void SadPathUpdateCategoryIdLessThanOne(){
		Category sample = new Category();
		sample.setId(0);
		sample.setCategory("Flavors");
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathUpdateCategoryNameIsTooLong(){
		Category sample = new Category();
		sample.setCategory("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way� in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");
		boolean result = collectionsServiceImpl.updateCategory(1, sample);
		assertFalse(result);
	}

	@Test
	public void happyPathDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(0)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.deleteCategory(0);

	public void SadPathUpdateCategoryIdIsLessThan1(){
		Category sample = new Category();
		sample.setId(0);
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void HappyPathDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(1)).thenReturn(true);

		boolean result = collectionsServiceImpl.deleteCategory(1);

		assertTrue(result);
	}

	@Test
	public void happyPathGetAgeTypes(){
		ArrayList<Age> sample = new ArrayList<Age>();
		when(mockCollectionsDao.getAgeTypes()).thenReturn(sample);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		ArrayList<Age> result = collectionsServiceImpl.getAgeTypes();
		assertEquals(sample, result);
	}

	@Test
	public void happyPathAddAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge("Antique");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(1)).addAge(age);
	}

	@Test
	public void sadPathAddAgeWithOnlyANumber(){
		Age age = new Age();
		age.setId(1);
		age.setAge("2");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddAgeWithNumbersInWords(){
		Age age = new Age();
		age.setId(1);
		age.setAge("These are 3 Words");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddNullAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge(null);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddEmptyStringAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge("");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddWhiteSpaceOnlyStringAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge("     ");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddAgeWithTooManyCharacters(){
		Age age = new Age();
		age.setId(1);
		age.setAge("this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void happyPathUpdateAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge("A good age");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(1)).updateAge(age);
	}


	@Test
	public void sadPathUpdateAgeWithOnlyANumber(){
		Age age = new Age();
		age.setId(1);
		age.setAge("2");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateAgeWithNumbersInWords(){
		Age age = new Age();
		age.setId(1);
		age.setAge("These are 3 Words");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateNullAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge(null);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateEmptyStringAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge("");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateWhiteSpaceOnlyStringAge(){
		Age age = new Age();
		age.setId(1);
		age.setAge("     ");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateAgeWithTooManyCharacters(){
		Age age = new Age();
		age.setId(1);
		age.setAge("this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void happyPathDeleteAge(){
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.deleteAge(1);
		verify(mockCollectionsDao, times(1)).deleteAge(1);
	}

	@Test
	public void sadPathDeleteAgeThatDoesNotExist(){
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.deleteAge(0);
		verify(mockCollectionsDao, times(0)).deleteAge(0);
	}

	public void HappyPathDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(1)).thenReturn(true);

		boolean result = collectionsServiceImpl.deleteCategory(1);
		assertTrue(result);
	}

	@Test
	public void SadPathDeleteCategoryIdLessThanOne(){

		boolean result = collectionsServiceImpl.deleteCategory(0);
		assertFalse(result);
	}

	@Test
	public void SadPathDeleteCategoryIdIsLessThan1(){
		when(mockCollectionsDao.deleteCategory(0)).thenReturn(true);

		boolean result = collectionsServiceImpl.deleteCategory(0);
		assertFalse(result);
	}

    @Test
    public void testAddAValidKeyword() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("AValidWord1");

        assertTrue(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testAddAInvalidKeywordWithEmptyString() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testAddAInvalidKeywordWithStringLengthTooLong() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("asdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfas");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testAddAInvalidKeywordWithInvalidCharacterInString() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("asdf#as");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testGetAllKeywords() throws Exception {
        ArrayList<Keyword> expected = new ArrayList<>();
        when(mockCollectionsDao.getAllKeywords()).thenReturn(expected);
        ArrayList<Keyword> actual = collectionsServiceImpl.getAllKeywords();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKeywordsByLetter() throws Exception {
        ArrayList<Keyword> expected = new ArrayList<>();
        when(mockCollectionsDao.getKeywordsByLetter('c')).thenReturn(expected);
        ArrayList<Keyword> actual = collectionsServiceImpl.getKeywordsByLetter('c');
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateAValidKeyword() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("AValidWord1");

        assertTrue(collectionsServiceImpl.updateKeyword(keyword));
    }

    @Test
    public void testUpdateAInvalidKeywordWithNullString() {
        Keyword keyword = new Keyword();
        keyword.setKeyword(null);

        assertFalse(collectionsServiceImpl.updateKeyword(keyword));
    }

    @Test
    public void testUpdateAInvalidKeywordWithStringLengthTooLong() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("asdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfas");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testUpdateAInvalidKeywordWithInvalidCharacterInString() {
        Keyword keyword = new Keyword();
        keyword.setKeyword("asdf#as");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testRemoveKeywordHappyPath() throws Exception {
        collectionsServiceImpl.removeKeyword(3);
        verify(mockCollectionsDao, times(1)).removeKeyword(3);
    }

    @Test
    public void testRemoveKeywordSadPath() throws Exception {
        collectionsServiceImpl.removeKeyword(-1);
        verify(mockCollectionsDao, times(0)).removeKeyword(-1);
    }
}
