package com.niit.dao;

import com.niit.model.ProfilePicture;

public interface ProfilePicDAO {

	public void save(ProfilePicture profilePicture);

	public ProfilePicture getProfilePicture(String loginname);
}
