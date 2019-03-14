package com.nexcloud.tsdb.client.adapter.influx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nexcloud.tsdb.adapter.K8sClusterAdapter;
import com.nexcloud.tsdb.client.influx.InfluxClient;

@Component
public class K8sClusterInfluxAdapter implements K8sClusterAdapter {
	
	@Autowired private InfluxClient influxClient;

	@Override
	public String getCpuTotal(String startTime, String time, int limit) {
		return influxClient.get(getQuery("cpu_total", "cpuTotal", startTime, time, limit));
	}
	@Override
	public String getCpuUsed(String startTime, String time, int limit) {
		return influxClient.get(getQuery("cpu_used", "cpuUsed", startTime, time, limit));
	}
	@Override
	public String getCpuUsedPercent(String startTime, String time, int limit) {
		return influxClient.get(getQuery("cpu_used_percent", "cpuPercent", startTime, time, limit));
	}
	@Override
	public String getMemoryTotal(String startTime, String time, int limit) {
		return influxClient.get(getQuery("mem_total", "memoryTotal", startTime, time, limit));
	}
	@Override
	public String getMemoryUsed(String startTime, String time, int limit) {
		return influxClient.get(getQuery("mem_used", "memoryUsed", startTime, time, limit));
	}
	@Override
	public String getMemoryUsedPercent(String startTime, String time, int limit) {
		return influxClient.get(getQuery("mem_used_percent", "memoryPercent", startTime, time, limit));
	}
	@Override
	public String getPodTotal(String startTime, String time, int limit) {
		return influxClient.get(getQuery("pod_total", "podTotal", startTime, time, limit));
	}
	@Override
	public String getPodUsed(String startTime, String time, int limit) {
		return influxClient.get(getQuery("pod_used", "podUsed", startTime, time, limit));
	}
	@Override
	public String getPodUsedPercent(String startTime, String time, int limit) {
		return influxClient.get(getQuery("pod_used_percent", "podPercent", startTime, time, limit));
	}
	private String getQuery(String field, String alias, String startTime, String time, int limit) {
		return  "SELECT mean(" + field + ") AS " + alias
				+ " FROM \"k8s_cluster\""
				+ " WHERE time > now() - " + startTime
				+ " GROUP By time(" + time + ") fill(linear)"
				+ " ORDER By time asc"
				+ " LIMIT " + limit;
	}
}
