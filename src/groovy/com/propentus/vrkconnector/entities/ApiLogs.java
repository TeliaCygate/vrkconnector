package com.propentus.vrkconnector.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Main response object returned by /api/getLoggingStatistics.
 */
public class ApiLogs {

	String count;
	List<ProviderLog> providersLogs = new ArrayList<ProviderLog>();
}
