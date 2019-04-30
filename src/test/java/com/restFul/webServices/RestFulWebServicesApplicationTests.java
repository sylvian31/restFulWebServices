package com.restFul.webServices;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestFulWebServicesApplicationTests {

	@Mock
	List<String> mockedList;

	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Captor
	ArgumentCaptor<String> argCaptor;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

//	@Test
//	public void contextLoads() {
//	}

	// Mock test

	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
		mockedList.add("one");
		verify(mockedList).add("one");
		assertEquals(0, mockedList.size());

		when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
	}

	// Spy test

	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjected() {
		spiedList.add("one");
		spiedList.add("two");

		verify(spiedList).add("one");
		verify(spiedList).add("two");

		assertEquals(2, spiedList.size());

		doReturn(100).when(spiedList).size();
		assertEquals(100, spiedList.size());
	}

	// captor test

	@Test
	public void whenUseCaptorAnnotation_thenTheSam() {
		mockedList.add("one");
		verify(mockedList).add(argCaptor.capture());

		assertEquals("one", argCaptor.getValue());
	}

	// ------------------------- Mockito Moks method
	// -------------------------------------//

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testMockWithName() {
		MyList listMock = mock(MyList.class, "myMock");

		when(listMock.add(anyString())).thenReturn(false);
		listMock.add("salut");

		thrown.expect(TooLittleActualInvocations.class);
		thrown.expectMessage(containsString("myMock.add"));

		verify(listMock, times(2)).add(anyString());

	}

	@Test
	public void whenUsingMockWithAnswer_thenCorrect() {
		MyList listMock = mock(MyList.class, new CustomAnswer());
		boolean added = listMock.add("salut");

		verify(listMock).add(anyString());
		assertThat(added, is(false));
	}

    @Test
    public void whenUsingMockWithSettings_thenCorrect() {
        MockSettings customSettings = withSettings().defaultAnswer(new CustomAnswer());
        MyList listMock = mock(MyList.class, customSettings);
        boolean added = listMock.add("salut");

        verify(listMock).add(anyString());
        assertThat(added, is(false));
    }

	private static class CustomAnswer implements Answer<Boolean> {
		@Override
		public Boolean answer(InvocationOnMock invocation) throws Throwable {
			return false;
		}
	}

	public class MyList extends AbstractList<String> {

		@Override
		public String get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

	}
	
	
	
	
	
	
	
	
	
	
	// ----------------ArgumentMatchers------------------------------
	
	
	
	
}
