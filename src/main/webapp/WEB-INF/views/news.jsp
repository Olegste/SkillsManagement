<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container">
	<div class="row row-centered">
		<div class="col-md-12 col-centered">
			<div id="divRss"></div>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://momentjs.com/downloads/moment-with-langs.min.js"></script>
<script src="<c:url value="/resources/js/FeedEk.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#divRss').FeedEk({
			FeedUrl : 'https://dou.ua/calendar/feed/',
			ShowDesc : true,
			MaxCount : 10,
			ShowPubDate : true,
			DescCharacterLimit : 1200

		});

	});
</script>
</body>
</html>
