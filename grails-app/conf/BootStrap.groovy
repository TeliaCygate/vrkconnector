import org.apache.log4j.BasicConfigurator;

import grails.util.Environment;

import com.propentus.vrkconnector.bootstrap.BootStrapDevelopment;
import com.propentus.vrkconnector.bootstrap.BootStrapTest;
import com.propentus.vrkconnector.bootstrap.BootStrapProduction;

class BootStrap {

    def init = { servletContext ->
		
		Environment.executeForCurrentEnvironment {
			development {
				BootStrapDevelopment.init()
				//Initialize log4J
				BasicConfigurator.configure();
			}
			test {
				BootStrapTest.init()
			}
			production {
				BootStrapDevelopment.init()
			}
		}		
    }
		
    def destroy = {
    }
}
