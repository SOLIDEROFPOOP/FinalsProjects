package com.muratkapparov.springbootlibrary.RequestModels;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Data
public class ReviewRequest {
    private Double rating;
    private Long bookId;
    private Optional<String> reviewDescription;

}
