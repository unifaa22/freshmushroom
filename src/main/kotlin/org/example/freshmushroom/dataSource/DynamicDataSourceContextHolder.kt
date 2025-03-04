package org.example.freshmushroom.dataSource

import org.example.freshmushroom.enums.DataSourceType
import org.slf4j.LoggerFactory

object DynamicDataSourceContextHolder {
    private val logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder::class.java)
    private val contextHolder = ThreadLocal<DataSourceType>()

    fun setDataSourceType(dataSourceType: DataSourceType) {
        logger.info("Setting DataSourceType to $dataSourceType")
        contextHolder.set(dataSourceType)
    }

    fun getDataSourceType(): DataSourceType {
        val dataSourceType = contextHolder.get() ?: DataSourceType.MASTER
        logger.info("Getting DataSourceType: $dataSourceType")
        return dataSourceType
    }

    fun clearDataSourceType() {
        logger.info("Clearing DataSourceType")
        contextHolder.remove()
    }
}