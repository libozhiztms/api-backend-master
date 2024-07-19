package com.lilibozhi.project.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用id请求
 *
 * @author lilibozhi
 */
@Data
public class IdRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}