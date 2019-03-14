<div class="m-subheader">
	<div class="d-flex align-items-center">
		<div class="mr-auto">
			<h3 class="m-subheader__title">
				Host Network
			</h3>
		</div>
		<span class="m-subheader__daterange" id="m_dashboard_daterangepicker">
			<span class="m-subheader__daterange-label">
				<span class="m-subheader__daterange-title"></span>
				<span class="m-subheader__daterange-date m--font-brand"></span>
			</span>
			<a href="#" class="btn btn-sm btn-brand m-btn m-btn--icon m-btn--icon-only m-btn--custom m-btn--pill">
				<i class="la la-angle-down"></i>
			</a>
		</span>
	</div>
</div>
<div class="m-content">
	<div class="row">
		<div class="col-lg-12">
			<div class="m-portlet m-portlet--head-sm m-portlet--full-height ">
				<div class="m-portlet__head">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<div class="m-portlet__head-text">Network Receive</div>
						</div>
					</div>
					<div class="m-portlet__head-tools"></div>
				</div>
				<div class="m-portlet__body">
					<div class="m-widget14">
						<div id="networkReceiveChartArea" style="height: 250px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="m-portlet m-portlet--head-sm m-portlet--full-height ">
				<div class="m-portlet__head">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<div class="m-portlet__head-text">Network Send</div>
						</div>
					</div>
					<div class="m-portlet__head-tools"></div>
				</div>
				<div class="m-portlet__body">
					<div class="m-widget14">
						<div id="networkSendChartArea" style="height: 250px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="/resources/js/module/common/client.js" type="text/javascript"></script>
<script src="/resources/js/module/chart/basicLine.js" type="text/javascript"></script>
<script type="text/javascript">
var hostIp = "${hostIp}";
var interfaceId = "${interfaceId}";

new Picker().refreshFunction(timeRefresh).draw();
function timeRefresh (startTime, time) {
	new Client().url("/api/v1/host/" + hostIp + "/network/interface/" + interfaceId + "/rx/byte?startTime=" + startTime + "&time=" + time + "&limit=1000")
	.callback(function(data){
		new BasicLine().area("networkReceiveChartArea").data(data, "rxbyte", interfaceId).draw();
	}).get();
	
	new Client().url("/api/v1/host/" + hostIp + "/network/interface/" + interfaceId + "/tx/byte?startTime=" + startTime + "&time=" + time + "&limit=1000")
	.callback(function(data){
		new BasicLine().area("networkSendChartArea").data(data, "txbyte", interfaceId).draw();
	}).get();
}
</script>