package com.official.booking.repo.explicit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.official.booking.model.Booking;

@Repository
public class ExplicitBookingRepoImpl implements ExplicitBookingRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Booking> getBookings() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Booking> query = builder.createQuery(Booking.class);

        Root<Booking> from = query.from(Booking.class);
        query.select(from);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Integer addBooking(Booking booking) {

        entityManager.persist(booking);
        return 1;
    }

}
