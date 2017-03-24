/**
 * 
 */
package com.lichengbao.domain.insurance;

import com.lichengbao.usertype.JacksonUserType;

public class PackageDetailUserType extends JacksonUserType {

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return PackageDetail.class;
	}
	
}