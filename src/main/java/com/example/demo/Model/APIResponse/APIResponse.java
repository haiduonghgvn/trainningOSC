package com.example.demo.Model.APIResponse;

import lombok.*;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 26/05/2020 - 9:27 AM
 * @created_by duongnch
 * @since 26/05/2020
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    private Status status;
    private T data;
    private PageMetaData pageMetaData;

}
