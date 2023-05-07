package com.official.hotel.repo.explicit;

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

import com.official.hotel.model.Hotel;
import com.official.hotel.model.Room;

@Repository
public class ExplicitHotelRepoImpl implements ExplicitHotelRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Hotel> getHotels() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> query = builder.createQuery(Hotel.class);

        Root<Hotel> from = query.from(Hotel.class);
        query.select(from);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Hotel> getSearchedHotels(String name, String city, Date checkIn, Date checkOut) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> query = builder.createQuery(Hotel.class);
        Root<Hotel> from = query.from(Hotel.class);

        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            predicates.add(
                    builder.equal(builder.lower(from.get("name")), name.toLowerCase()));
        }
        if (StringUtils.isNotBlank(city)) {
            predicates
                    .add(builder.equal(builder.lower(from.get("city")), city.toLowerCase()));
        }
//        if (ObjectUtils.isNotEmpty(checkIn) && ObjectUtils.isNotEmpty(checkOut)) {
//            predicates.add(builder.between(builder.literal(from.get),
//                    from.get("flightStart"), from.get("flightEnd")));
//        }

        query.select(from);

        query.where(builder.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Integer bookHotel(Integer hotelId, Integer roomId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaUpdate<Room> update = builder.createCriteriaUpdate(Room.class);

        Root<Room> from = update.from(Room.class);

        update.set("available", false);
        update.where(builder.and(builder.equal(from.get("roomId"), roomId),
                builder.equal(from.get("hotelId"), hotelId)));

        return entityManager.createQuery(update).executeUpdate();

    }

    @Override
    public Boolean checkAvailability(Integer roomId, Integer hotelId) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Room> query = builder.createQuery(Room.class);
        Root<Room> from = query.from(Room.class);

        query.select(from);
        query.where(builder.and(builder.equal(from.get("roomId"), roomId),
                builder.equal(from.get("hotelId"), hotelId)));

        return entityManager.createQuery(query).getSingleResult().getAvailable();
    }

}
