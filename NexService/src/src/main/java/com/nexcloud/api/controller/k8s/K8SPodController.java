package com.nexcloud.api.controller.k8s;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nexcloud.api.service.k8s.K8sPodService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/kubernetes/pod")
public class K8SPodController {
	static final Logger logger = LoggerFactory.getLogger(K8SPodController.class);

	@Autowired private K8sPodService k8sPodService;

	@ApiOperation(value="Cpu Used", httpMethod="GET", notes="Cpu Used")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/used", method=RequestMethod.GET)
	public String getCpuUsed(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuUsed(startTime, time, limit);
	}
	@ApiOperation(value="Cpu Used Percent", httpMethod="GET", notes="Cpu Used Percent")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/used/percent", method=RequestMethod.GET)
	public String getCpuUsedPercent(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuUsedPercent(startTime, time, limit);
	}
	@ApiOperation(value="Cpu Limit", httpMethod="GET", notes="Cpu Limit")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/limit", method=RequestMethod.GET)
	public String getCpuLimit(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuLimit(startTime, time, limit);
	}
	@ApiOperation(value="Cpu Request", httpMethod="GET", notes="Cpu Request")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/cpu/request", method=RequestMethod.GET)
	public String getCpuRequest(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuRequest(startTime, time, limit);
	}
	
	@ApiOperation(value="Memory Used", httpMethod="GET", notes="Memory Used")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/used", method=RequestMethod.GET)
	public String getMemoryUsed(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryUsed(startTime, time, limit);
	}
	@ApiOperation(value="Memory Used Percent", httpMethod="GET", notes="Memory Used Percent")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/used/percent", method=RequestMethod.GET)
	public String getMemoryUsedPercent(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryUsedPercent(startTime, time, limit);
	}
	@ApiOperation(value="Memory Limit", httpMethod="GET", notes="Memory Limit")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/limit", method=RequestMethod.GET)
	public String getMemoryLimit(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryLimit(startTime, time, limit);
	}
	@ApiOperation(value="Memory Request", httpMethod="GET", notes="Memory Request")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/memory/request", method=RequestMethod.GET)
	public String getMemoryRequest(
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryRequest(startTime, time, limit);
	}
	
	// by pod

	@ApiOperation(value="Cpu Used By pod", httpMethod="GET", notes="Cpu Used By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/cpu/used", method=RequestMethod.GET)
	public String getCpuUsedByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuUsedByPod(pod, startTime, time, limit);
	}
	@ApiOperation(value="Cpu Used Percent By pod", httpMethod="GET", notes="Cpu Used Percent By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/cpu/used/percent", method=RequestMethod.GET)
	public String getCpuUsedPercentByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuUsedPercentByPod(pod, startTime, time, limit);
	}
	@ApiOperation(value="Cpu Limit By pod", httpMethod="GET", notes="Cpu Limit By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/cpu/limit", method=RequestMethod.GET)
	public String getCpuLimitByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuLimitByPod(pod, startTime, time, limit);
	}
	@ApiOperation(value="Cpu Request By pod", httpMethod="GET", notes="Cpu Request By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/cpu/request", method=RequestMethod.GET)
	public String getCpuRequestByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getCpuRequestByPod(pod, startTime, time, limit);
	}
	
	@ApiOperation(value="Memory Used By pod", httpMethod="GET", notes="Memory Used By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/memory/used", method=RequestMethod.GET)
	public String getMemoryUsedByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryUsedByPod(pod, startTime, time, limit);
	}
	@ApiOperation(value="Memory Used Percent By pod", httpMethod="GET", notes="Memory Used Percent By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/memory/used/percent", method=RequestMethod.GET)
	public String getMemoryUsedPercentByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryUsedPercentByPod(pod, startTime, time, limit);
	}
	@ApiOperation(value="Memory Limit By pod", httpMethod="GET", notes="Memory Limit By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/memory/limit", method=RequestMethod.GET)
	public String getMemoryLimitByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryLimitByPod(pod, startTime, time, limit);
	}
	@ApiOperation(value="Memory Request By pod", httpMethod="GET", notes="Memory Request By pod")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "startTime", paramType = "query", 
				defaultValue = "1h", value = "조회 시간 (ex) 20분전 : 20m, 한시가전 : 1h, 두시간전 :2h .."),
		@ApiImplicitParam(name = "time", paramType = "query", 
				defaultValue = "5s", value = "group by time (ex) 1s"),
		@ApiImplicitParam(name = "limit", paramType = "query", 
				defaultValue = "1000", value = "limit (ex) 1000")
	}) 
	@ApiResponses(value={@ApiResponse( code=200, message="SUCCESS"), @ApiResponse( code=500, message="Internal Server Error")})
	@RequestMapping(value="/{pod}/memory/request", method=RequestMethod.GET)
	public String getMemoryRequestByPod(
			@PathVariable(value="pod", required=false) String pod,
			@RequestParam(value="startTime", defaultValue="1h") String startTime,
			@RequestParam(value="time", defaultValue="5s") String time,
			@RequestParam(value="limit", defaultValue="1000") int limit) {
		return k8sPodService.getMemoryRequestByPod(pod, startTime, time, limit);
	}
}
