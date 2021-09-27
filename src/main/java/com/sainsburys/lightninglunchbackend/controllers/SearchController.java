package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.models.Product;
import com.sainsburys.lightninglunchbackend.models.SearchResponse;
import com.sainsburys.lightninglunchbackend.service.ProductService;
import com.sainsburys.lightninglunchbackend.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("{searchTerm}")
    public SearchResponse search(@PathVariable("searchTerm") String searchTerm) {
        List<Product> products = searchService.searchProducts(searchTerm);

        SearchResponse searchResponse = new SearchResponse();
        SearchResponse.MetaData meta = new SearchResponse.MetaData();

        meta.setCurrentPage(1);
        meta.setPageSize(24);
        meta.setTotalPages(1);
        meta.setTotalData(products.size());

        searchResponse.setProducts(products);
        searchResponse.setMetaData(meta);

        return searchResponse;
    }

}
