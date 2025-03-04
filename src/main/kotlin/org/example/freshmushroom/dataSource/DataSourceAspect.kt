package org.example.freshmushroom.dataSource

import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.example.freshmushroom.enums.DataSourceType
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
class DataSourceAspect {
    @Before("@annotation(org.example.freshmushroom.annotation.SlaveDataSource)")
    fun setSlaveDataSource() {
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE)
    }

    @After("@annotation(org.example.freshmushroom.annotation.SlaveDataSource)")
    fun clearDataSource() {
        DynamicDataSourceContextHolder.clearDataSourceType()
    }
}