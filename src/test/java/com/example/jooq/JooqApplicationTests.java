package com.example.jooq;

import com.example.jooq.Dto.jasuilDto;
import com.example.jooq.controll.rest;
import com.example.jooq.settings.ApiConfig;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JooqApplicationTests {

	Logger log = LoggerFactory.getLogger(JooqApplicationTests.class);

	@Autowired
	private DSLContext dsl;
    @Autowired
    private MessageSource messageSource;

/*
	    @Test
	    public void givenValidData_whenInserting_thenSucceed() {
	        dsl.insertInto(AUTHOR)
	                .set(AUTHOR.ID, 4)
	                .set(AUTHOR.FIRST_NAME, "Herbert")
	                .set(AUTHOR.LAST_NAME, "Schildt")
	                .execute();

	        dsl.insertInto(BOOK)
	                .set(BOOK.ID, 4)
	                .set(BOOK.TITLE, "A Beginner's Guide")
	                .execute();

	        dsl.insertInto(AUTHOR_BOOK)
	                .set(AUTHOR_BOOK.AUTHOR_ID, 4)
	                .set(AUTHOR_BOOK.BOOK_ID, 4)
	                .execute();

	        final Result<Record3<Integer, String, Integer>> result = dsl.select(AUTHOR.ID, AUTHOR.LAST_NAME, DSL.count())
	                .from(AUTHOR).join(AUTHOR_BOOK).on(AUTHOR.ID.equal(AUTHOR_BOOK.AUTHOR_ID))
	                .join(BOOK).on(AUTHOR_BOOK.BOOK_ID.equal(BOOK.ID))
	                .groupBy(AUTHOR.LAST_NAME)
	                .fetch();

	        assertEquals(3, result.size());
	        assertEquals("Sierra", result.getValue(0, AUTHOR.LAST_NAME));
	        assertEquals(Integer.valueOf(2), result.getValue(0, DSL.count()));
	        assertEquals("Schildt", result.getValue(2, AUTHOR.LAST_NAME));
	        assertEquals(Integer.valueOf(1), result.getValue(2, DSL.count()));
	    }
/*
	    @Test(expected = DataAccessException.class)
	    public void givenInvalidData_whenInserting_thenFail() {
	        dsl.insertInto(AUTHOR_BOOK)
	                .set(AUTHOR_BOOK.AUTHOR_ID, 4)
	                .set(AUTHOR_BOOK.BOOK_ID, 5)
	                .execute();
	    }

	    @Test
	    public void givenValidData_whenUpdating_thenSucceed() {
	        dsl.update(AUTHOR)
	                .set(AUTHOR.LAST_NAME, "Baeldung")
	                .where(AUTHOR.ID.equal(3))
	                .execute();

	        dsl.update(BOOK)
	                .set(BOOK.TITLE, "Building your REST API with Spring")
	                .where(BOOK.ID.equal(3))
	                .execute();

	        dsl.insertInto(AUTHOR_BOOK)
	                .set(AUTHOR_BOOK.AUTHOR_ID, 3)
	                .set(AUTHOR_BOOK.BOOK_ID, 3)
	                .execute();

	        final Result<Record3<Integer, String, String>> result = dsl.select(AUTHOR.ID, AUTHOR.LAST_NAME, BOOK.TITLE)
	                .from(AUTHOR).join(AUTHOR_BOOK).on(AUTHOR.ID.equal(AUTHOR_BOOK.AUTHOR_ID))
	                .join(BOOK).on(AUTHOR_BOOK.BOOK_ID.equal(BOOK.ID))
	                .where(AUTHOR.ID.equal(3))
	                .fetch();

	        assertEquals(1, result.size());
	        assertEquals(Integer.valueOf(3), result.getValue(0, AUTHOR.ID));
	        assertEquals("Baeldung", result.getValue(0, AUTHOR.LAST_NAME));
	        assertEquals("Building your REST API with Spring", result.getValue(0, BOOK.TITLE));
	    }

	    @Test(expected = DataAccessException.class)
	    public void givenInvalidData_whenUpdating_thenFail() {
	        dsl.update(AUTHOR_BOOK)
	                .set(AUTHOR_BOOK.AUTHOR_ID, 4)
	                .set(AUTHOR_BOOK.BOOK_ID, 5)
	                .execute();
	    }

	    @Test
	    public void givenValidData_whenDeleting_thenSucceed() {
	        dsl.delete(AUTHOR)
	                .where(AUTHOR.ID.lt(3))
	                .execute();

	        final Result<Record3<Integer, String, String>> result = dsl.select(AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
	                .from(AUTHOR).fetch();

	        assertEquals(1, result.size());
	        assertEquals("Bryan", result.getValue(0, AUTHOR.FIRST_NAME));
	        assertEquals("Basham", result.getValue(0, AUTHOR.LAST_NAME));
	    }

	    @Test(expected = DataAccessException.class)
	    public void givenInvalidData_whenDeleting_thenFail() {
	        dsl.delete(BOOK)
	                .where(BOOK.ID.equal(1))
	                .execute();
	    }
*/

	@Test
	public void test2() {
		ApiConfig apiConfig = new ApiConfig();
		ApiConfig.MyAPI<String> a = apiConfig.myapi();
		Call<jasuilDto> g = a.get1("jasuil");

		g.enqueue(new Callback<jasuilDto>() {
			@Override
			public void onResponse(Call<jasuilDto> call, Response<jasuilDto> response) {

				log.info("성공 : ", response.body());
			}

			@Override
			public void onFailure(Call<jasuilDto> call, Throwable t) {
				log.info("실패 : ", t.toString());
			}
		});
	}

	@Test
	public void test3(){
		Locale locale = new Locale("th", "TH");
		log.info(messageSource.getMessage("my.msg", null, locale));
	}

}

