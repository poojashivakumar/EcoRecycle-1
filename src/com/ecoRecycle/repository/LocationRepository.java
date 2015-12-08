package com.ecoRecycle.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ecoRecycle.helper.HibernateLoader;
import com.ecoRecycle.model.Item;
import com.ecoRecycle.model.Location;

public class LocationRepository {
	
	public List<Location> getAllLocations() {
		Session session = HibernateLoader.getSessionFactory().openSession();
		Transaction tx = null;
		List<Location> locations = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Location.class);
			locations = criteria.list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return locations;
	} 
	
	public Location getLocationById(int id) {
		Session session = HibernateLoader.getSessionFactory().openSession();
		Transaction tx = null;
		Location location = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Location.class);
			criteria.add(Restrictions.eq("id", id));
			location = (Location) criteria.uniqueResult();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return location;
	}
	
	public Location getLocationByCity(String city) {
		Session session = HibernateLoader.getSessionFactory().openSession();
		Transaction tx = null;
		Location location = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Location.class);
			criteria.add(Restrictions.eq("city", city));
			location = (Location) criteria.uniqueResult();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return location;
	}
}
