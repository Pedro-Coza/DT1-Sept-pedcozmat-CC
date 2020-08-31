<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:message code="administrator.dashboard.form.title" />

<acme:form readonly="true">
	<acme:form-integer code="administrator.dashboard.form.totalNotice" path="totalNotice"/>
	<acme:form-integer code="administrator.dashboard.form.totalTechRec" path="totalTechRec"/>
	<acme:form-integer code="administrator.dashboard.form.totalToolRec" path="totalToolRec"/>
	<acme:form-integer code="administrator.dashboard.form.minInq" path="minInq"/>
	<acme:form-integer code="administrator.dashboard.form.maxInq" path="maxInq"/>
	<acme:form-integer code="administrator.dashboard.form.avgInq" path="avgInq"/>
	<acme:form-double code="administrator.dashboard.form.stdDevInq" path="stdDevInq"/>
	<acme:form-integer code="administrator.dashboard.form.minOvt" path="minOvt"/>
	<acme:form-integer code="administrator.dashboard.form.maxOvt" path="maxOvt"/>
	<acme:form-integer code="administrator.dashboard.form.avgOvt" path="avgOvt"/>
	<acme:form-double code="administrator.dashboard.form.stdDevOvt" path="stdDevOvt"/>
	<acme:form-double code="administrator.dashboard.form.avgInvRoundXEnterpreneur" path="avgInvRoundXEnterpreneur"/>
	<acme:form-double code="administrator.dashboard.form.avgAppsXEnterpreneur" path="avgAppsXEnterpreneur"/>
	<acme:form-double code="administrator.dashboard.form.avgInvRoundXInvestor" path="avgInvRoundXInvestor"/>
	
</acme:form>

<acme:form-panel code="administrator.dashboard.form.charts">

<acme:message code="administrator.dashboard.form.title.groupedByAS" />

<acme:menu-separator/>

<div>
	<canvas id="canvas1"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: ["Technology","Science","Arts","Business","Health"],
				datasets : [
					{
						label: "Technology Records",
						data : [
							<jstl:out value = "${countTechAS1}" />,
							<jstl:out value = "${countTechAS2}" />,
							<jstl:out value = "${countTechAS3}" />,
							<jstl:out value = "${countTechAS4}" />,
							<jstl:out value = "${countTechAS5}" />
						],backgroundColor: [
							"#0080ff", "#00ff00","#bf00ff","#996633","#ff3300"
			            ]	
						
					},{
						label: "Tool Records",
						data : [
							<jstl:out value = "${countToolAS1}" />,
							<jstl:out value = "${countToolAS2}" />,
							<jstl:out value = "${countToolAS3}" />,
							<jstl:out value = "${countToolAS4}" />,
							<jstl:out value = "${countToolAS5}" />
						],backgroundColor: [
							"#80bfff", "#99ff99","#e699ff","#f9f2ec","#ffc2b3"
			            ]		
					}
				]		
		};
		
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 5.0
							}
						}
					]
				},
				legend : {
					display : false
				}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas1");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>


<acme:message code="administrator.dashboard.form.title.techSource" />

<div>
	<canvas id="canvas2"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: [
					"OPEN-SOURCE", "CLOSED-SOURCE"
				],
				datasets : [
					{
						data : [
							<jstl:out value = "${techCountOS}" />,
							<jstl:out value = "${techCountCS}" />
						],backgroundColor: [
							"#0080ff", "#00bfff"
			            ]	
						
					}
				]		
		};
		var options = {
				legend : {
					display : false
				}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas2");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options: options
		});
	});
</script>

<acme:menu-separator/>

<acme:message code="administrator.dashboard.form.title.toolSource" />

<div>
	<canvas id="canvas3"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: [
					"OPEN-SOURCE", "CLOSED-SOURCE"
				],
				datasets : [
					{
						data : [
							<jstl:out value = "${toolCountOS}" />,
							<jstl:out value = "${toolCountCS}" />
						],backgroundColor: [
							"#00ffaa", "#53ff1a"
			            ]	
						
					}
				]		
		};
		
		var options = {
				legend : {
					display : false
				}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas3");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>


<acme:menu-separator/>

 <acme:message code="administrator.dashboard.form.title.iRKind" />
 
<div>
	<canvas id="canvas4"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: ["SEED", "ANGEL","SERIES-A","SERIES-B","SERIES-C","BRIDGE"],
				datasets : [
					{
						label: "Number of rounds of this kind",
						data : [
							<jstl:out value = "${iRKindSeed}" />,
								<jstl:out value = "${iRKindAngel}" />,
								<jstl:out value = "${iRKindSeriesA}" />,
								<jstl:out value = "${iRKindSeriesB}" />,
								<jstl:out value = "${iRKindSeriesC}" />,
								<jstl:out value = "${iRKindBridge}" />
						],backgroundColor: [
							"#0080ff", "#00ff00","#bf00ff","#996633","#ff3300","#f9f2ec"
			            ]	
						
					}]		
		};
		
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 5.0
							}
						}
					]
				},
				legend : {
					display : false
				}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas4");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>

<acme:menu-separator/>

 <acme:message code="administrator.dashboard.form.title.appByStatus" />
 
<div>
	<canvas id="canvas5"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels: ["Accepted", "Rejected"],
				datasets : [
					{
						data : [
							<jstl:out value = "${acceptedApps}" />,
							<jstl:out value = "${rejectedApps}" />,
						],backgroundColor: [
							"#00ff00","#ff3300"
							]	
						
					}]		
		};
		
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 8.0
							}
						}
					]
				},
				legend : {
					display : false
				}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas5");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script>

</acme:form-panel>