dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = ""
	password = ""
}

hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory'
}

// environment specific settings
environments {
	
	development {
		dataSource {
			dbCreate = "validate" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:mysql://localhost:3306/VrkDB?useUnicode=yes&characterEncoding=UTF-8"
		}
	}
	
	test {
		dataSource {
			dbCreate = "validate"
			jndiName = "java:/comp/env/jdbc/VRKConnectorDB"
		}
	}
	
	production {
		dataSource {
			dbCreate = "validate"
			jndiName = "java:/comp/env/jdbc/VRKConnectorDB"
		}
	}
		
}