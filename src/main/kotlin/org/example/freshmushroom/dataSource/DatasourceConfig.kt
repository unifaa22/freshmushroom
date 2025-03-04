package org.example.freshmushroom.dataSource

import org.example.freshmushroom.enums.DataSourceType
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource


@Configuration
@EnableAspectJAutoProxy
@EnableCaching
class DatasourceConfig {
    @Bean
    @Primary
    fun dataSource(): DataSource {
        val dataSource = DynamicDataSource()


        val primaryDataSource = DataSourceBuilder.create()
            .url("jdbc:mysql://sh-cynosdbmysql-grp-hwyktvck.sql.tencentcdb.com:23257/freshmushroom?allowPublicKeyRetrieval=true&useSSL=false")
            .username("repl")
            .password("name123321@")
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .build()

        val secondaryDataSource = DataSourceBuilder.create()
            .url("jdbc:mysql://localhost:3306/freshmushroom?allowPublicKeyRetrieval=true&useSSL=false")
            .username("root")
            .password("12345")
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .build()


        val targetDataSources = mapOf<Any, Any>(
            DataSourceType.MASTER to primaryDataSource,
            DataSourceType.SLAVE to secondaryDataSource
        )

        dataSource.setDefaultTargetDataSource(primaryDataSource)
        dataSource.setTargetDataSources(targetDataSources)
        return dataSource
    }
    @Bean
    fun transactionManager(dataSource: DataSource): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}