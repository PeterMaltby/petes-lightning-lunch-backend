package com.sainsburys.lightninglunchbackend.models;

import java.util.List;

public class SearchResponse {


    private MetaData metaData;
    private List<Product> products;

    public MetaData getMetaData() {
        return metaData;
    }
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static class MetaData {
        private long totalData;
        private long pageSize;
        private long currentPage;
        private long totalPages;

        public long getTotalData() {
            return totalData;
        }

        public void setTotalData(long totalData) {
            this.totalData = totalData;
        }

        public long getPageSize() {
            return pageSize;
        }

        public void setPageSize(long pageSize) {
            this.pageSize = pageSize;
        }

        public long getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(long currentPage) {
            this.currentPage = currentPage;
        }

        public long getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(long totalPages) {
            this.totalPages = totalPages;
        }
    }
}
