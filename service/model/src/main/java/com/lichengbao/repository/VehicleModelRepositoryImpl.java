/**
 * 
 */
package com.lichengbao.repository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.HibernateQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.ToListResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.lichengbao.domain.common.VehicleModel;
import com.lichengbao.domain.insurance.order.Order;
import com.lichengbao.domain.insurance.order.Order10;
import com.lichengbao.domain.insurance.order.Order15;
import com.lichengbao.domain.user.User;
import com.lichengbao.domain.user.UserBalance;

/**
 * @author jwang
 *
 */
public class VehicleModelRepositoryImpl implements VehicleModelRepositoryEx {
	
	@PersistenceUnit(unitName = "kkb")
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext(unitName = "kkb")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.lichengbao.repository.VehicleModelRepositoryEx#getBrands()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set<VehicleModel> getBrands() {
		
//		this.entityManagerFactory.addNamedQuery("findVehicleModelByNameCn", this.entityManager.createQuery("select m from VehicleModel m where m.nameCn = :nameCn"));
		
//		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
//		CriteriaQuery<VehicleModel> criteria = cb.createQuery(VehicleModel.class);
//		Root<VehicleModel> root = criteria.from(VehicleModel.class);
//		ParameterExpression<String> nameCnParam = cb.parameter(String.class);
//		criteria.select(root).where(cb.equal(root.<Long>get("nameCn"), nameCnParam));
//		Query query = this.entityManager.createQuery("select u.id, u.username, u.createdAt from User u");
//		TypedQuery<VehicleModel> query = this.entityManager.createNamedQuery("findVehicleModelByNameCn", VehicleModel.class);
//		TypedQuery<VehicleModel> query = this.entityManager.createQuery(criteria);
//		query.setParameter("types", Arrays.asList(Order10.class, Order15.class));
//		org.hibernate.Query hibernateQuery = query.unwrap(HibernateQuery.class).getHibernateQuery();
//		ScrollableResults cursor = hibernateQuery.scroll(ScrollMode.SCROLL_INSENSITIVE);
//		cursor.setRowNumber(3);
//		cursor.last();
//		System.out.println(cursor.getRowNumber() + 1);
//		VehicleModel result = (VehicleModel) cursor.get(0);
//		cursor.close();
//		query.setFirstResult(5).setMaxResults(10);
//		System.out.println(hibernateQuery.getQueryString());
//		System.out.println(hibernateQuery.getReturnAliases());
//		for (Parameter<?> param : query.getParameters()) {
//			System.out.println(query.isBound(param));
//		} 
//		query.getResultList();
		
		Session session = this.entityManager.unwrap(Session.class);
//		org.hibernate.Query query = session.createQuery("select u.id, u.username, u.createdAt from User u");
//		List<?> result = query.list();
		Criteria query = session.createCriteria(VehicleModel.class)
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("py"))
						.add(Projections.rowCount()))
				.add(Restrictions.sqlRestriction("length({alias}.PY) < ?", 8, StandardBasicTypes.INTEGER))
				.addOrder(org.hibernate.criterion.Order.asc("py"))
				.addOrder(org.hibernate.criterion.Order.desc("nameCn"));
		query.list();
//		query.add(Restrictions.eq("id", 80l));
//		SQLQuery query = session.createSQLQuery("SELECT {m.*} FROM vehicle_models {m}").addEntity("m", VehicleModel.class);
//		Iterator<VehicleModel> it = query.iterate();
//		while (it.hasNext()) {
//			VehicleModel m = it.next();
//			System.out.println(m);
//		}
//		Hibernate.close(it);
		
		return null;
		
	}

}
