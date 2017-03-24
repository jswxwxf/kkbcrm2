/**
 * 
 */
package com.lichengbao.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * @author jwang
 *
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	default T findOneExist(ID id) throws ObjectRetrievalFailureException {
        T result = findOne(id);
        if (result == null) throw new ObjectRetrievalFailureException("Entity " + id + " not found", null);
        return result;
    }

}
