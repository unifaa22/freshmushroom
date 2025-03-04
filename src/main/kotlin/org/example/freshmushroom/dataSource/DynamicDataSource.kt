package org.example.freshmushroom.dataSource

import org.example.freshmushroom.enums.DataSourceType
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource


class DynamicDataSource : AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): DataSourceType {
        return DynamicDataSourceContextHolder.getDataSourceType()
    }
}