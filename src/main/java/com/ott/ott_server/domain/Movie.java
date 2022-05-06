package com.ott.ott_server.domain;

import com.ott.ott_server.dto.movie.MovieListRes;
import com.ott.ott_server.dto.movie.MovieResponseData;
import lombok.*;
import org.hibernate.metamodel.model.domain.spi.MapPersistentAttribute;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.LAZY;

@Entity
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Movie extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "movie", orphanRemoval = true)
    @Builder.Default
    private List<MovieOtt> otts = new ArrayList<>();

    @OneToMany(mappedBy = "movie", orphanRemoval = true)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    private String genre;

    private String title;

    private String imageUrl;

    private String director;

    private String actor;

    @Builder.Default
    private boolean deleted = false;

    public MovieResponseData toMovieResponseData() {
        return MovieResponseData.builder()
                .imageUrl(imageUrl)
                .title(title)
                .genre(genre)
                .actor(actor)
                .director(director)
                .movieOtts(otts.stream().map(MovieOtt::toMovieOttResponseData).collect(Collectors.toList()))
                .build();
    }

    public MovieListRes toMovieListRes(List<Review> reviews) {
        OptionalDouble average = reviews.stream().mapToDouble(r -> r.getScore().doubleValue()).average();
        Double score = null;
        if(average.isPresent()) {
            score = average.getAsDouble();
        }
        return MovieListRes.builder()
                .movieId(id)
                .score(score)
                .imageUrl(imageUrl)
                .build();
    }

    public void addReview(Review review) {
        review.setMovie(this);
        reviews.add(review);
    }

    public void addOtt(MovieOtt ott) {
        otts.add(ott);
    }

}
