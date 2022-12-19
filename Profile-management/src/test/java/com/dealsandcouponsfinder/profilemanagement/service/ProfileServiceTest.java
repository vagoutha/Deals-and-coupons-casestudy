package com.dealsandcouponsfinder.profilemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dealsandcouponsfinder.profilemanagement.exception.ProfileRequestException;
import com.dealsandcouponsfinder.profilemanagement.model.Credentials;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.CredentialsRepository;
import com.dealsandcouponsfinder.profilemanagement.repository.ProfileRepository;

@SpringBootTest
public class ProfileServiceTest {

	@Autowired
	ProfileService profileService;

	@MockBean
	private ProfileRepository profileRepository;
	@MockBean
	private CredentialsRepository credentialsRepository;

	@Test
	void saveTest() {
		Profile pro = new Profile("gouthami98@gmail.com", "gouthami", "9989733321", "junnu1");
		when(profileRepository.save(pro)).thenReturn(pro);
		assertEquals(pro, profileService.save(pro));
	}

	@Test
	 public void deleteByIdTest() throws ProfileRequestException {
		when (profileRepository.findById("gouthami98@gmail.com")).thenReturn(Optional.of(new Profile("gouthami98@gmail.com", "gouthami", "9989733321", "junnu")));
		doNothing().when(profileRepository).deleteById("gouthami98@gmail.com");
		assertEquals(profileService.deleteById("gouthami98@gmail.com"), "Id gouthami98@gmail.com deleted!");
	}

	@Test
	public void findByIdTest() throws ProfileRequestException {
		when (profileRepository.findById("gouthami98@gmail.com")).thenReturn(Optional.of(new Profile("gouthami98@gmail.com", "gouthami", "9989733321", "junnu")));
		Optional<Profile> profile = profileService.findById("gouthami98@gmail.com");
		assertEquals("gouthami98@gmail.com",profile.get().getEmailId());
		assertEquals("gouthami",profile.get().getFullName());
		assertEquals("9989733321",profile.get().getMobileNo());


	}


}
