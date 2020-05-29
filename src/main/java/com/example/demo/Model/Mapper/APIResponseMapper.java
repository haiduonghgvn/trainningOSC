package com.example.demo.Model.Mapper;

import com.example.demo.Entity.Student;
import com.example.demo.Model.APIResponse.APIResponse;
import com.example.demo.Model.APIResponse.PageMetaData;
import com.example.demo.Model.APIResponse.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 27/05/2020 - 1:50 PM
 * @created_by duongnch
 * @since 27/05/2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseMapper<T> {
    APIResponse apiResponse = new APIResponse();
    Status status = new Status();
    PageMetaData pageMetaData = new PageMetaData();

    public APIResponse<T> mapperAPIResponse(int code, String message, String description, Page page) {
        status.setMessage(message);
        status.setCode(code);
        status.setDescription(description);
        pageMetaData.setTotalPages(page.getTotalPages());
        pageMetaData.setTotalElements(page.getTotalElements());
        pageMetaData.setCurrentPage(page.getNumber());
        pageMetaData.setSize(page.getSize());
        if (page.hasNext()) {
            pageMetaData.setNextPageURL("?page="+(pageMetaData.getCurrentPage()+1)+"&size="+pageMetaData.getSize());
        }else{
            pageMetaData.setNextPageURL("null");
        }

        if (page.hasPrevious()){
            pageMetaData.setPreviousPageURL("?page="+(pageMetaData.getCurrentPage()-1) +"&size="+pageMetaData.getSize());
        }else{
            pageMetaData.setPreviousPageURL("null");
        }
        apiResponse.setStatus(status);
        apiResponse.setPageMetaData(pageMetaData);
        apiResponse.setData(page.getContent());
        return apiResponse;
    }

    public APIResponse<T> mapperAPIResponse(int code, String message, String description, Student students) {
        status.setMessage(message);
        status.setCode(code);
        status.setDescription(description);
        apiResponse.setStatus(status);
        apiResponse.setPageMetaData(pageMetaData);
        apiResponse.setData(students);
        return apiResponse;
    }
}
