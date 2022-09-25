package jon.whatson.service;

import jon.whatson.iservice.IReviewService;
import jon.whatson.model.Review;
import jon.whatson.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements IReviewService {

    private ReviewRepository reviewrepository;

    public ReviewService(ReviewRepository reviewrepository) {
        this.reviewrepository = reviewrepository;
    }

    @Override
    public List<Review> findAll() {
        return new ArrayList<>(reviewrepository.findAll());
    }

    @Override
    public Review save(Review object) {
        return reviewrepository.save(object);
    }

    @Override
    public boolean existsById(Long aLong) {
        return reviewrepository.existsById(aLong);
    }


    @Override
    public void deleteById(Long aLong) {
        reviewrepository.deleteById(aLong);

    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return reviewrepository.findById(aLong);
    }
}
