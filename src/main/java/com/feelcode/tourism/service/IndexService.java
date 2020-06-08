package com.feelcode.tourism.service;

import com.feelcode.tourism.entity.IndexRequestDTO;
import com.feelcode.tourism.entity.IndexResponseDTO;

/**
 * @Author: 朱利尔
 * @Description:
 * @Date: Created in 16:39 2020/6/5
 * @Modified By:
 */
public interface IndexService {
    IndexResponseDTO getIndexData(IndexRequestDTO request);
}
