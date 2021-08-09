package com.example.songr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test void testAlbum(){
		Album first = new Album("ElDorado" , "Shakira" , 15 , "2:30" , "https://upload.wikimedia.org/wikipedia/en/a/a7/Shakira_El_Dorado_cover.png");
		Assertions.assertEquals("ElDorado" , first.getTitle());
		Assertions.assertEquals("Shakira" , first.getArtist());
		Assertions.assertEquals(15 , first.getSongCount());
		Assertions.assertEquals("2:30" , first.getLength());
		Assertions.assertNotNull(first.getImageUrl());
		first.setArtist("Ali Shiyyab");
		first.setSongCount(350);
		first.setTitle("Green");
		Assertions.assertEquals("Ali Shiyyab" , first.getArtist());
		Assertions.assertEquals("Green" , first.getTitle());
		Assertions.assertEquals(350 , first.getSongCount());
	}

}
