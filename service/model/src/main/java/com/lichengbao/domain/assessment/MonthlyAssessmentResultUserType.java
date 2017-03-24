/**
 * 
 */
package com.lichengbao.domain.assessment;

import com.lichengbao.usertype.JacksonUserType;

public class MonthlyAssessmentResultUserType extends JacksonUserType {

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return MonthlyAssessmentResult.class;
	}
	
}