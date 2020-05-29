package com.example.demo.Model.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 26/05/2020 - 3:36 PM
 * @created_by duongnch
 * @since 26/05/2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageMetaData<T> {
    private int size;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private String nextPageURL;
    private String previousPageURL;

}
