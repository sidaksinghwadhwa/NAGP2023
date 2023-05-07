package com.official.flight.repo.explicit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.official.flight.model.Flight;
import com.official.flight.model.Flight.FlightType;
import com.official.flight.model.Seat;

@Repository
public class ExplicitFlightRepoImpl implements ExplicitFlightRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Flight> getFlights() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);

        Root<Flight> from = query.from(Flight.class);
        query.select(from);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Flight> getSearchedFlights(String departure, String arrival, FlightType flightType,
            Date flightInputDate) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
        Root<Flight> from = query.from(Flight.class);

        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(departure)) {
            predicates.add(
                    builder.equal(builder.lower(from.get("departure")), departure.toLowerCase()));
        }
        if (StringUtils.isNotBlank(arrival)) {
            predicates
                    .add(builder.equal(builder.lower(from.get("arrival")), arrival.toLowerCase()));
        }
        if (ObjectUtils.isNotEmpty(flightType)) {
            predicates.add(builder.equal(from.get("flightType"), flightType));
        }
        if (ObjectUtils.isNotEmpty(flightInputDate)) {
            predicates.add(builder.between(builder.literal(flightInputDate),
                    from.get("flightStart"), from.get("flightEnd")));
        }

        query.select(from);

        query.where(builder.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Integer bookFlight(Integer flightId, Integer seatId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaUpdate<Seat> update = builder.createCriteriaUpdate(Seat.class);

        Root<Seat> from = update.from(Seat.class);

        update.set("available", false);
        update.where(builder.and(builder.equal(from.get("seatId"), seatId),
                builder.equal(from.get("flightId"), flightId)));

        return entityManager.createQuery(update).executeUpdate();

    }

    @Override
    public Boolean checkAvailability(Integer seatId, Integer flightId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Seat> query = builder.createQuery(Seat.class);
        Root<Seat> from = query.from(Seat.class);

        query.select(from);
        query.where(builder.and(builder.equal(from.get("seatId"), seatId),
                builder.equal(from.get("flightId"), flightId)));

        return entityManager.createQuery(query).getSingleResult().getAvailable();
    }

}
