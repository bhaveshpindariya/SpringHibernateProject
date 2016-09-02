package com.solusoft.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.solusoft.jpa.dao.AdminMasterDAO;
import com.solusoft.jpa.entity.AdminMaster;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	AdminMasterDAO adminMasterDAO;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			List<AdminMaster> users = adminMasterDAO.findByProperty(username.toUpperCase());
			AdminMaster adminMaster;
			if(users==null || users.isEmpty()){
				throw new UsernameNotFoundException("Credetials Invalid!");
			}
			adminMaster=users.get(0);
			if (adminMaster == null){
				throw new UsernameNotFoundException("Credetials Invalid!");
			}

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			String password = adminMaster.getPassword();

			return new User(username, password, enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked,
					getGrantedAuthorities(adminMaster.getRoleManagement().getRolename()));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param roles Sets of RoleMaster entities which is associated to the user
	 * 
	 * @return It returns the converted to lists of granted authority.
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(
			String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

}