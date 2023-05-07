package com.official.hotel.repo;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.official.hotel.model.Hotel;
import com.official.hotel.repo.explicit.ExplicitHotelRepo;

public interface HotelRepo extends JpaRepositoryImplementation<Hotel, Integer>, ExplicitHotelRepo{


}
